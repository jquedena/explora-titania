package com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1;

/**
 * RdbRuntimeUpdateTemplate
 */
public class RdbRuntimeUpdateTemplate {
private class CodeBuffer{
		private char[] value;
		private int count;
	public CodeBuffer(int capacity){
			value = new char[capacity];
	}
	public int length() {
		return count;
	}
	public CodeBuffer append(String str) {

		int len = str.length();
		int newcount = count + len;

		str.getChars(0, len, value, count);
		count = newcount;
		return this;
	}
	public void deleteLastChars(int numChars){
		 count = count - numChars;
	}
	public String toString(){
		return new String(value, 0, count);
	}
}
private static final String AND = " AND ";
private static final String ISNULL  = " IS NULL ";
private static final String EQUALMARKER = " = ? ";
private int maxQueryBufferSize;
private String fRootFragment;
private String fWhereKeyFragment;
private String fWhereKeyAndPredicateFragment;
private String[] fAssignmentColumns;
private String[] fPredicateColumns;
private boolean fHasNullablePredicates;
private int[] fCmpFieldMap;

public RdbRuntimeUpdateTemplate(
	 String rootFragment,
	 String keyFragment,
	 String[] assignmentFragments,
	 int maxQuerySize,
	 boolean nullbalePredicates) {
	fRootFragment      = rootFragment;
	fWhereKeyFragment  = keyFragment;
	maxQueryBufferSize  = maxQuerySize;
	fAssignmentColumns  = assignmentFragments;
	fHasNullablePredicates = nullbalePredicates;
}
public boolean isNullablePredicates() {
	return fHasNullablePredicates;
}
public void setPredicateColumns(String[] predicateColumns, int maxQuerySize) {
	maxQueryBufferSize = maxQuerySize;
	if (isNullablePredicates()){
		fPredicateColumns = predicateColumns;
	}
	else{
		StringBuffer buf = new StringBuffer(fWhereKeyFragment);
		for(int j=0; j < predicateColumns.length; j++){
			buf.append(AND).append(predicateColumns[j]).append(EQUALMARKER);
		}
		fWhereKeyAndPredicateFragment = buf.toString();
	}
}
public void cmpFieldMap(int[] cmpFieldMap) {
	fCmpFieldMap = cmpFieldMap;
}
public int[] cmpFieldMap() {
	return fCmpFieldMap;
}
public String nativeQuery(boolean[] dirtyFlags) {
	CodeBuffer aBuffer = new CodeBuffer(maxQueryBufferSize);
	aBuffer.append(fRootFragment);
	if (!assignmentsOn(aBuffer, dirtyFlags))
		return null;
	aBuffer.append(fWhereKeyFragment);
	return aBuffer.toString();
}
public String nativeOptimisticQuery(boolean[] dirtyFlags) {
	CodeBuffer aBuffer = new CodeBuffer(maxQueryBufferSize);
	aBuffer.append(fRootFragment);
	if (!assignmentsOn(aBuffer, dirtyFlags))
		return null;
	aBuffer.append(fWhereKeyAndPredicateFragment);
	return aBuffer.toString();
}
public String nativeOptimisticQuery(boolean[] dirtyFlags, Object[] values) {
	CodeBuffer aBuffer = new CodeBuffer(maxQueryBufferSize);
	aBuffer.append(fRootFragment);
	if (!assignmentsOn(aBuffer, dirtyFlags))
		return null;
	aBuffer.append(fWhereKeyFragment);
	predicatesOn(aBuffer, values);
	return aBuffer.toString();
}
private boolean assignmentsOn(CodeBuffer aBuffer, boolean[] dirtyFlags) {
	boolean touched = false;
	int numColumns = fAssignmentColumns.length;
	for (int i = 0; i < numColumns; i++) {
		if (dirtyFlags[fCmpFieldMap[i]]) {
			aBuffer.append(fAssignmentColumns[i]);
			touched = true;
		}
	}

	if(touched)
		aBuffer.deleteLastChars(2);
	return touched;

}
private void predicatesOn(CodeBuffer buf, Object[] values){
	for (int i=0; i < fPredicateColumns.length; i++){
		buf.append(AND).append(fPredicateColumns[i]);
		if (values[i] != null)
			buf.append(EQUALMARKER);
		else
			buf.append(ISNULL);
	}

}
}
