<%-- Set the content type header with the JSP directive --%>
<%@ page contentType="application/vnd.ms-excel" %>
                                                                                                                   
<%-- Set the content disposition header --%>
<% response.setHeader("Content-Disposition", "attachment; filename=\"mult-table.xls\""); %>
                                                                                                                   
<table>
<% for(int i = 1; i <= 12; i++){ %>
  <tr>
    <% for(int j = 1; j <= 12; j++){ %>
      <td>
        <%= i * j %>
      </td>
    <% } %>
  </tr>
<% } %>
</table>