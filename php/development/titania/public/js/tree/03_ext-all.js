/*
 * Ext JS Library 1.0
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://www.extjs.com/license
 */

Ext.DomHelper = function() {
	var _1 = null;
	var _2 = /^(?:br|frame|hr|img|input|link|meta|range|spacer|wbr|area|param|col)$/i;
	var _3 = function(o) {
		if (typeof o == "string") {
			return o;
		}
		var b = "";
		if (!o.tag) {
			o.tag = "div";
		}
		b += "<" + o.tag;
		for ( var _6 in o) {
			if (_6 == "tag" || _6 == "children" || _6 == "cn" || _6 == "html"
					|| typeof o[_6] == "function") {
				continue;
			}
			if (_6 == "style") {
				var s = o["style"];
				if (typeof s == "function") {
					s = s.call();
				}
				if (typeof s == "string") {
					b += " style=\"" + s + "\"";
				} else {
					if (typeof s == "object") {
						b += " style=\"";
						for ( var _8 in s) {
							if (typeof s[_8] != "function") {
								b += _8 + ":" + s[_8] + ";";
							}
						}
						b += "\"";
					}
				}
			} else {
				if (_6 == "cls") {
					b += " class=\"" + o["cls"] + "\"";
				} else {
					if (_6 == "htmlFor") {
						b += " for=\"" + o["htmlFor"] + "\"";
					} else {
						b += " " + _6 + "=\"" + o[_6] + "\"";
					}
				}
			}
		}
		if (_2.test(o.tag)) {
			b += "/>";
		} else {
			b += ">";
			var cn = o.children || o.cn;
			if (cn) {
				if (cn instanceof Array) {
					for ( var i = 0, _b = cn.length; i < _b; i++) {
						b += _3(cn[i], b);
					}
				} else {
					b += _3(cn, b);
				}
			}
			if (o.html) {
				b += o.html;
			}
			b += "</" + o.tag + ">";
		}
		return b;
	};
	var _c = function(o, _e) {
		var el = document.createElement(o.tag);
		var _10 = el.setAttribute ? true : false;
		for ( var _11 in o) {
			if (_11 == "tag" || _11 == "children" || _11 == "cn"
					|| _11 == "html" || _11 == "style"
					|| typeof o[_11] == "function") {
				continue;
			}
			if (_11 == "cls") {
				el.className = o["cls"];
			} else {
				if (_10) {
					el.setAttribute(_11, o[_11]);
				} else {
					el[_11] = o[_11];
				}
			}
		}
		Ext.DomHelper.applyStyles(el, o.style);
		var cn = o.children || o.cn;
		if (cn) {
			if (cn instanceof Array) {
				for ( var i = 0, len = cn.length; i < len; i++) {
					_c(cn[i], b);
				}
			} else {
				_c(cn, b);
			}
		}
		if (o.html) {
			el.innerHTML = o.html;
		}
		if (_e) {
			_e.appendChild(el);
		}
		return el;
	};
	var _15 = function(_16, s, h, e) {
		_1.innerHTML = [ s, h, e ].join("");
		var i = -1, el = _1;
		while (++i < _16) {
			el = el.firstChild;
		}
		return el;
	};
	var ts = "<table>", te = "</table>", tbs = ts + "<tbody>", tbe = "</tbody>"
			+ te, trs = tbs + "<tr>", tre = "</tr>" + tbe;
	var _22 = function(tag, _24, el, _26) {
		if (!_1) {
			_1 = document.createElement("div");
		}
		var _27;
		var _28 = null;
		if (tag == "td") {
			if (_24 == "afterbegin" || _24 == "beforeend") {
				return;
			}
			if (_24 == "beforebegin") {
				_28 = el;
				el = el.parentNode;
			} else {
				_28 = el.nextSibling;
				el = el.parentNode;
			}
			_27 = _15(4, trs, _26, tre);
		} else {
			if (tag == "tr") {
				if (_24 == "beforebegin") {
					_28 = el;
					el = el.parentNode;
					_27 = _15(3, tbs, _26, tbe);
				} else {
					if (_24 == "afterend") {
						_28 = el.nextSibling;
						el = el.parentNode;
						_27 = _15(3, tbs, _26, tbe);
					} else {
						if (_24 == "afterbegin") {
							_28 = el.firstChild;
						}
						_27 = _15(4, trs, _26, tre);
					}
				}
			} else {
				if (tag == "tbody") {
					if (_24 == "beforebegin") {
						_28 = el;
						el = el.parentNode;
						_27 = _15(2, ts, _26, te);
					} else {
						if (_24 == "afterend") {
							_28 = el.nextSibling;
							el = el.parentNode;
							_27 = _15(2, ts, _26, te);
						} else {
							if (_24 == "afterbegin") {
								_28 = el.firstChild;
							}
							_27 = _15(3, tbs, _26, tbe);
						}
					}
				} else {
					if (_24 == "beforebegin" || _24 == "afterend") {
						return;
					}
					if (_24 == "afterbegin") {
						_28 = el.firstChild;
					}
					_27 = _15(2, ts, _26, te);
				}
			}
		}
		el.insertBefore(_27, _28);
		return _27;
	};
	return {
		useDom : false,
		markup : function(o) {
			return _3(o);
		},
		applyStyles : function(el, _2b) {
			if (_2b) {
				el = Ext.fly(el);
				if (typeof _2b == "string") {
					var re = /\s?([a-z\-]*)\:\s?([^;]*);?/gi;
					var _2d;
					while ((_2d = re.exec(_2b)) != null) {
						el.setStyle(_2d[1], _2d[2]);
					}
				} else {
					if (typeof _2b == "object") {
						for ( var _2e in _2b) {
							el.setStyle(_2e, _2b[_2e]);
						}
					} else {
						if (typeof _2b == "function") {
							Ext.DomHelper.applyStyles(el, _2b.call());
						}
					}
				}
			}
		},
		insertHtml : function(_2f, el, _31) {
			_2f = _2f.toLowerCase();
			if (el.insertAdjacentHTML) {
				var tag = el.tagName.toLowerCase();
				if (tag == "table" || tag == "tbody" || tag == "tr"
						|| tag == "td") {
					var rs;
					if (rs = _22(tag, _2f, el, _31)) {
						return rs;
					}
				}
				switch (_2f) {
				case "beforebegin":
					el.insertAdjacentHTML(_2f, _31);
					return el.previousSibling;
				case "afterbegin":
					el.insertAdjacentHTML(_2f, _31);
					return el.firstChild;
				case "beforeend":
					el.insertAdjacentHTML(_2f, _31);
					return el.lastChild;
				case "afterend":
					el.insertAdjacentHTML(_2f, _31);
					return el.nextSibling;
				}
				throw "Illegal insertion point -> \"" + _2f + "\"";
			}
			var _34 = el.ownerDocument.createRange();
			var _35;
			switch (_2f) {
			case "beforebegin":
				_34.setStartBefore(el);
				_35 = _34.createContextualFragment(_31);
				el.parentNode.insertBefore(_35, el);
				return el.previousSibling;
			case "afterbegin":
				if (el.firstChild) {
					_34.setStartBefore(el.firstChild);
				} else {
					_34.selectNodeContents(el);
					_34.collapse(true);
				}
				_35 = _34.createContextualFragment(_31);
				el.insertBefore(_35, el.firstChild);
				return el.firstChild;
			case "beforeend":
				if (el.lastChild) {
					_34.setStartAfter(el.lastChild);
				} else {
					_34.selectNodeContents(el);
					_34.collapse(false);
				}
				_35 = _34.createContextualFragment(_31);
				el.appendChild(_35);
				return el.lastChild;
			case "afterend":
				_34.setStartAfter(el);
				_35 = _34.createContextualFragment(_31);
				el.parentNode.insertBefore(_35, el.nextSibling);
				return el.nextSibling;
			}
			throw "Illegal insertion point -> \"" + _2f + "\"";
		},
		insertBefore : function(el, o, _38) {
			return this.doInsert(el, o, _38, "beforeBegin");
		},
		insertAfter : function(el, o, _3b) {
			return this.doInsert(el, o, _3b, "afterEnd", "nextSibling");
		},
		insertFirst : function(el, o, _3e) {
			return this.doInsert(el, o, _3e, "afterBegin");
		},
		doInsert : function(el, o, _41, pos, _43) {
			el = Ext.getDom(el);
			var _44;
			if (this.useDom) {
				_44 = _c(o, null);
				el.parentNode.insertBefore(_44, _43 ? el[_43] : el);
			} else {
				var _45 = _3(o);
				_44 = this.insertHtml(pos, el, _45);
			}
			return _41 ? Ext.get(_44, true) : _44;
		},
		append : function(el, o, _48) {
			el = Ext.getDom(el);
			var _49;
			if (this.useDom) {
				_49 = _c(o, null);
				el.appendChild(_49);
			} else {
				var _4a = _3(o);
				_49 = this.insertHtml("beforeEnd", el, _4a);
			}
			return _48 ? Ext.get(_49, true) : _49;
		},
		overwrite : function(el, o, _4d) {
			el = Ext.getDom(el);
			el.innerHTML = _3(o);
			return _4d ? Ext.get(el.firstChild, true) : el.firstChild;
		},
		createTemplate : function(o) {
			var _4f = _3(o);
			return new Ext.Template(_4f);
		}
	};
}();

Ext.Template = function(_1) {
	if (_1 instanceof Array) {
		_1 = _1.join("");
	} else {
		if (arguments.length > 1) {
			_1 = Array.prototype.join.call(arguments, "");
		}
	}
	this.html = _1;
};
Ext.Template.prototype = {
	applyTemplate : function(_2) {
		if (this.compiled) {
			return this.compiled(_2);
		}
		var _3 = this.disableFormats !== true;
		var fm = Ext.util.Format, _5 = this;
		var fn = function(m, _8, _9, _a) {
			if (_9 && _3) {
				if (_9.substr(0, 5) == "this.") {
					return _5.call(_9.substr(5), _2[_8]);
				} else {
					if (_a) {
						var re = /^\s*['"](.*)["']\s*$/;
						_a = _a.split(",");
						for ( var i = 0, _d = _a.length; i < _d; i++) {
							_a[i] = _a[i].replace(re, "$1");
						}
						_a = [ _2[_8] ].concat(_a);
					} else {
						_a = [ _2[_8] ];
					}
					return fm[_9].apply(fm, _a);
				}
			} else {
				return _2[_8] !== undefined ? _2[_8] : "";
			}
		};
		return this.html.replace(this.re, fn);
	},
	set : function(_e, _f) {
		this.html = _e;
		this.compiled = null;
		if (_f) {
			this.compile();
		}
		return this;
	},
	disableFormats : false,
	re : /\{([\w-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g,
	compile : function() {
		var fm = Ext.util.Format;
		var _11 = this.disableFormats !== true;
		var sep = Ext.isGecko ? "+" : ",";
		var fn = function(m, _15, _16, _17) {
			if (_16 && _11) {
				_17 = _17 ? "," + _17 : "";
				if (_16.substr(0, 5) != "this.") {
					_16 = "fm." + _16 + "(";
				} else {
					_16 = "this.call(\"" + _16.substr(5) + "\", ";
					_17 = "";
				}
			} else {
				_17 = "", _16 = "(values['" + _15 + "'] == undefined ? '' : ";
			}
			return "'" + sep + _16 + "values['" + _15 + "']" + _17 + ")" + sep
					+ "'";
		};
		var _18;
		if (Ext.isGecko) {
			_18 = "this.compiled = function(values){ return '"
					+ this.html.replace(/(\r\n|\n)/g, "\\n")
							.replace("'", "\\'").replace(this.re, fn) + "';};";
		} else {
			_18 = [ "this.compiled = function(values){ return ['" ];
			_18.push(this.html.replace(/(\r\n|\n)/g, "\\n").replace("'", "\\'")
					.replace(this.re, fn));
			_18.push("'].join('');};");
			_18 = _18.join("");
		}
		eval(_18);
		return this;
	},
	call : function(_19, _1a) {
		return this[_19](_1a);
	},
	insertBefore : function(el, _1c, _1d) {
		el = Ext.getDom(el);
		var _1e = Ext.DomHelper.insertHtml("beforeBegin", el, this
				.applyTemplate(_1c));
		return _1d ? Ext.get(_1e, true) : _1e;
	},
	insertAfter : function(el, _20, _21) {
		el = Ext.getDom(el);
		var _22 = Ext.DomHelper.insertHtml("afterEnd", el, this
				.applyTemplate(_20));
		return _21 ? Ext.get(_22, true) : _22;
	},
	append : function(el, _24, _25) {
		el = Ext.getDom(el);
		var _26 = Ext.DomHelper.insertHtml("beforeEnd", el, this
				.applyTemplate(_24));
		return _25 ? Ext.get(_26, true) : _26;
	},
	overwrite : function(el, _28, _29) {
		el = Ext.getDom(el);
		el.innerHTML = this.applyTemplate(_28);
		return _29 ? Ext.get(el.firstChild, true) : el.firstChild;
	}
};
Ext.Template.prototype.apply = Ext.Template.prototype.applyTemplate;
Ext.DomHelper.Template = Ext.Template;
Ext.Template.from = function(el) {
	el = Ext.getDom(el);
	return new Ext.Template(el.value || el.innerHTML);
};
Ext.MasterTemplate = function() {
	Ext.MasterTemplate.superclass.constructor.apply(this, arguments);
	this.originalHtml = this.html;
	var st = {};
	var m, re = this.subTemplateRe;
	re.lastIndex = 0;
	var _2e = 0;
	while (m = re.exec(this.html)) {
		var _2f = m[1], _30 = m[2];
		st[_2e] = {
			name : _2f,
			index : _2e,
			buffer : [],
			tpl : new Ext.Template(_30)
		};
		if (_2f) {
			st[_2f] = st[_2e];
		}
		st[_2e].tpl.compile();
		st[_2e].tpl.call = this.call.createDelegate(this);
		_2e++;
	}
	this.subCount = _2e;
	this.subs = st;
};
Ext.extend(Ext.MasterTemplate, Ext.Template, {
	subTemplateRe : /<tpl(?:\sname="([\w-]+)")?>((?:.|\n)*?)<\/tpl>/gi,
	add : function(_31, _32) {
		if (arguments.length == 1) {
			_32 = arguments[0];
			_31 = 0;
		}
		var s = this.subs[_31];
		s.buffer[s.buffer.length] = s.tpl.apply(_32);
		return this;
	},
	fill : function(_34, _35, _36) {
		var a = arguments;
		if (a.length == 1 || (a.length == 2 && typeof a[1] == "boolean")) {
			_35 = a[0];
			_34 = 0;
			_36 = a[1];
		}
		if (_36) {
			this.reset();
		}
		for ( var i = 0, len = _35.length; i < len; i++) {
			this.add(_34, _35[i]);
		}
		return this;
	},
	reset : function() {
		var s = this.subs;
		for ( var i = 0; i < this.subCount; i++) {
			s[i].buffer = [];
		}
		return this;
	},
	applyTemplate : function(_3c) {
		var s = this.subs;
		var _3e = -1;
		this.html = this.originalHtml.replace(this.subTemplateRe, function(m,
				_40) {
			return s[++_3e].buffer.join("");
		});
		return Ext.MasterTemplate.superclass.applyTemplate.call(this, _3c);
	},
	apply : function() {
		return this.applyTemplate.apply(this, arguments);
	},
	compile : function() {
		return this;
	}
});
Ext.MasterTemplate.prototype.addAll = Ext.MasterTemplate.prototype.fill;
Ext.MasterTemplate.from = function(el) {
	el = Ext.getDom(el);
	return new Ext.MasterTemplate(el.value || el.innerHTML);
};

Ext.DomQuery = function() {
	var _1 = {}, _2 = {}, _3 = {};
	var _4 = /\S/;
	var _5 = /^\s+|\s+$/g;
	var _6 = /\{(\d+)\}/g;
	var _7 = /^(\s?[\/>]\s?|\s|$)/;
	var _8 = /^(#)?([\w-\*]+)/;
	function child(p, _a) {
		var i = 0;
		var n = p.firstChild;
		while (n) {
			if (n.nodeType == 1) {
				if (++i == _a) {
					return n;
				}
			}
			n = n.nextSibling;
		}
		return null;
	}
	function next(n) {
		while ((n = n.nextSibling) && n.nodeType != 1) {
		}
		return n;
	}
	function prev(n) {
		while ((n = n.previousSibling) && n.nodeType != 1) {
		}
		return n;
	}
	function clean(d) {
		var n = d.firstChild, ni = -1;
		while (n) {
			var nx = n.nextSibling;
			if (n.nodeType == 3 && !_4.test(n.nodeValue)) {
				d.removeChild(n);
			} else {
				n.nodeIndex = ++ni;
			}
			n = nx;
		}
		return this;
	}
	function byClassName(c, a, v, re, cn) {
		if (!v) {
			return c;
		}
		var r = [];
		for ( var i = 0, ci; ci = c[i]; i++) {
			cn = ci.className;
			if (cn && (" " + cn + " ").indexOf(v) != -1) {
				r[r.length] = ci;
			}
		}
		return r;
	}
	function attrValue(n, _1c) {
		if (!n.tagName && typeof n.length != "undefined") {
			n = n[0];
		}
		if (!n) {
			return null;
		}
		if (_1c == "for") {
			return n.htmlFor;
		}
		if (_1c == "class" || _1c == "className") {
			return n.className;
		}
		return n.getAttribute(_1c) || n[_1c];
	}
	function getNodes(ns, _1e, _1f) {
		var _20 = [], cs;
		if (!ns) {
			return _20;
		}
		_1e = _1e ? _1e.replace(_5, "") : "";
		_1f = _1f || "*";
		if (typeof ns.getElementsByTagName != "undefined") {
			ns = [ ns ];
		}
		if (_1e != "/" && _1e != ">") {
			for ( var i = 0, ni; ni = ns[i]; i++) {
				cs = ni.getElementsByTagName(_1f);
				for ( var j = 0, ci; ci = cs[j]; j++) {
					_20[_20.length] = ci;
				}
			}
		} else {
			for ( var i = 0, ni; ni = ns[i]; i++) {
				var cn = ni.getElementsByTagName(_1f);
				for ( var j = 0, cj; cj = cn[j]; j++) {
					if (cj.parentNode == ni) {
						_20[_20.length] = cj;
					}
				}
			}
		}
		return _20;
	}
	function concat(a, b) {
		if (b.slice) {
			return a.concat(b);
		}
		for ( var i = 0, l = b.length; i < l; i++) {
			a[a.length] = b[i];
		}
		return a;
	}
	function byTag(cs, _2d) {
		if (cs.tagName || cs == document) {
			cs = [ cs ];
		}
		if (!_2d) {
			return cs;
		}
		var r = [];
		_2d = _2d.toLowerCase();
		for ( var i = 0, ci; ci = cs[i]; i++) {
			if (ci.nodeType == 1 && ci.tagName.toLowerCase() == _2d) {
				r[r.length] = ci;
			}
		}
		return r;
	}
	function byId(cs, _32, id) {
		if (cs.tagName || cs == document) {
			cs = [ cs ];
		}
		if (!id) {
			return cs;
		}
		var r = [];
		for ( var i = 0, ci; ci = cs[i]; i++) {
			if (ci && ci.id == id) {
				r[r.length] = ci;
				return r;
			}
		}
		return r;
	}
	function byAttribute(cs, _38, _39, op, _3b) {
		var r = [], st = _3b == "{";
		var f = Ext.DomQuery.operators[op];
		for ( var i = 0; ci = cs[i]; i++) {
			var a;
			if (st) {
				a = Ext.DomQuery.getStyle(ci, _38);
			} else {
				if (_38 == "class" || _38 == "className") {
					a = ci.className;
				} else {
					if (_38 == "for") {
						a = ci.htmlFor;
					} else {
						if (_38 == "href") {
							a = ci.getAttribute("href", 2);
						} else {
							a = ci.getAttribute(_38);
						}
					}
				}
			}
			if ((f && f(a, _39)) || (!f && a)) {
				r[r.length] = ci;
			}
		}
		return r;
	}
	function byPseudo(cs, _42, _43) {
		return Ext.DomQuery.pseudos[_42](cs, _43);
	}
	var _44 = window.ActiveXObject ? true : false;
	var key = 30803;
	function nodupIEXml(cs) {
		var d = ++key;
		cs[0].setAttribute("_nodup", d);
		var r = [ cs[0] ];
		for ( var i = 1, len = cs.length; i < len; i++) {
			var c = cs[i];
			if (!c.getAttribute("_nodup") != d) {
				c.setAttribute("_nodup", d);
				r[r.length] = c;
			}
		}
		for ( var i = 0, len = cs.length; i < len; i++) {
			cs[i].removeAttribute("_nodup");
		}
		return r;
	}
	function nodup(cs) {
		if (!cs) {
			return [];
		}
		var len = cs.length, c, i, r = cs, cj;
		if (!len || typeof cs.nodeType != "undefined" || len == 1) {
			return cs;
		}
		if (_44 && typeof cs[0].selectSingleNode != "undefined") {
			return nodupIEXml(cs);
		}
		var d = ++key;
		cs[0]._nodup = d;
		for (i = 1; c = cs[i]; i++) {
			if (c._nodup != d) {
				c._nodup = d;
			} else {
				r = [];
				for ( var j = 0; j < i; j++) {
					r[r.length] = cs[j];
				}
				for (j = i + 1; cj = cs[j]; j++) {
					if (cj._nodup != d) {
						cj._nodup = d;
						r[r.length] = cj;
					}
				}
				return r;
			}
		}
		return r;
	}
	function quickDiffIEXml(c1, c2) {
		var d = ++key;
		for ( var i = 0, len = c1.length; i < len; i++) {
			c1[i].setAttribute("_qdiff", d);
		}
		var r = [];
		for ( var i = 0, len = c2.length; i < len; i++) {
			if (c2[i].getAttribute("_qdiff") != d) {
				r[r.length] = c2[i];
			}
		}
		for ( var i = 0, len = c1.length; i < len; i++) {
			c1[i].removeAttribute("_qdiff");
		}
		return r;
	}
	function quickDiff(c1, c2) {
		var _5c = c1.length;
		if (!_5c) {
			return c2;
		}
		if (_44 && c1[0].selectSingleNode) {
			return quickDiffIEXml(c1, c2);
		}
		var d = ++key;
		for ( var i = 0; i < _5c; i++) {
			c1[i]._qdiff = d;
		}
		var r = [];
		for ( var i = 0, len = c2.length; i < len; i++) {
			if (c2[i]._qdiff != d) {
				r[r.length] = c2[i];
			}
		}
		return r;
	}
	function quickId(ns, _62, _63, id) {
		if (ns == _63) {
			var d = _63.ownerDocument || _63;
			return d.getElementById(id);
		}
		ns = getNodes(ns, _62, "*");
		return byId(ns, null, id);
	}
	return {
		getStyle : function(el, _67) {
			return Ext.fly(el).getStyle(_67);
		},
		compile : function(_68, _69) {
			while (_68.substr(0, 1) == "/") {
				_68 = _68.substr(1);
			}
			_69 = _69 || "select";
			var fn = [ "var f = function(root){\n var mode; var n = root || document;\n" ];
			var q = _68, _6c, lq;
			var tk = Ext.DomQuery.matchers;
			var _6f = tk.length;
			var mm;
			while (q && lq != q) {
				lq = q;
				var tm = q.match(_8);
				if (_69 == "select") {
					if (tm) {
						if (tm[1] == "#") {
							fn[fn.length] = "n = quickId(n, mode, root, \""
									+ tm[2] + "\");";
						} else {
							fn[fn.length] = "n = getNodes(n, mode, \"" + tm[2]
									+ "\");";
						}
						q = q.replace(tm[0], "");
					} else {
						if (q.substr(0, 1) != "@") {
							fn[fn.length] = "n = getNodes(n, mode, \"*\");";
						}
					}
				} else {
					if (tm) {
						if (tm[1] == "#") {
							fn[fn.length] = "n = byId(n, null, \"" + tm[2]
									+ "\");";
						} else {
							fn[fn.length] = "n = byTag(n, \"" + tm[2] + "\");";
						}
						q = q.replace(tm[0], "");
					}
				}
				while (!(mm = q.match(_7))) {
					var _72 = false;
					for ( var j = 0; j < _6f; j++) {
						var t = tk[j];
						var m = q.match(t.re);
						if (m) {
							fn[fn.length] = t.select.replace(_6,
									function(x, i) {
										return m[i];
									});
							q = q.replace(m[0], "");
							_72 = true;
							break;
						}
					}
					if (!_72) {
						throw "Error parsing selector, parsing failed at \""
								+ q + "\"";
					}
				}
				if (mm[1]) {
					fn[fn.length] = "mode=\"" + mm[1] + "\";";
					q = q.replace(mm[1], "");
				}
			}
			fn[fn.length] = "return nodup(n);\n}";
			eval(fn.join(""));
			return f;
		},
		select : function(_78, _79, _7a) {
			if (!_79 || _79 == document) {
				_79 = document;
			}
			if (typeof _79 == "string") {
				_79 = document.getElementById(_79);
			}
			var _7b = _78.split(",");
			var _7c = [];
			for ( var i = 0, len = _7b.length; i < len; i++) {
				var p = _7b[i].replace(_5, "");
				if (!_1[p]) {
					_1[p] = Ext.DomQuery.compile(p);
					if (!_1[p]) {
						throw p + " is not a valid selector";
					}
				}
				var _80 = _1[p](_79);
				if (_80 && _80 != document) {
					_7c = _7c.concat(_80);
				}
			}
			return _7c;
		},
		selectNode : function(_81, _82) {
			return Ext.DomQuery.select(_81, _82)[0];
		},
		selectValue : function(_83, _84, _85) {
			_83 = _83.replace(_5, "");
			if (!_3[_83]) {
				_3[_83] = Ext.DomQuery.compile(_83, "select");
			}
			var n = _3[_83](_84);
			n = n[0] ? n[0] : n;
			var v = (n && n.firstChild ? n.firstChild.nodeValue : null);
			return (v === null ? _85 : v);
		},
		selectNumber : function(_88, _89, _8a) {
			var v = Ext.DomQuery.selectValue(_88, _89, _8a || 0);
			return parseFloat(v);
		},
		is : function(el, ss) {
			if (typeof el == "string") {
				el = document.getElementById(el);
			}
			var _8e = (el instanceof Array);
			var _8f = Ext.DomQuery.filter(_8e ? el : [ el ], ss);
			return _8e ? (_8f.length == el.length) : (_8f.length > 0);
		},
		filter : function(els, ss, _92) {
			ss = ss.replace(_5, "");
			if (!_2[ss]) {
				_2[ss] = Ext.DomQuery.compile(ss, "simple");
			}
			var _93 = _2[ss](els);
			return _92 ? quickDiff(_93, els) : _93;
		},
		matchers : [
				{
					re : /^\.([\w-]+)/,
					select : "n = byClassName(n, null, \" {1} \");"
				},
				{
					re : /^\:([\w-]+)(?:\(((?:[^\s>\/]*|.*?))\))?/,
					select : "n = byPseudo(n, \"{1}\", \"{2}\");"
				},
				{
					re : /^(?:([\[\{])(?:@)?([\w-]+)\s?(?:(=|.=)\s?['"]?(.*?)["']?)?[\]\}])/,
					select : "n = byAttribute(n, \"{2}\", \"{4}\", \"{3}\", \"{1}\");"
				},
				{
					re : /^#([\w-]+)/,
					select : "n = byId(n, null, \"{1}\");"
				},
				{
					re : /^@([\w-]+)/,
					select : "return {firstChild:{nodeValue:attrValue(n, \"{1}\")}};"
				} ],
		operators : {
			"=" : function(a, v) {
				return a == v;
			},
			"!=" : function(a, v) {
				return a != v;
			},
			"^=" : function(a, v) {
				return a && a.substr(0, v.length) == v;
			},
			"$=" : function(a, v) {
				return a && a.substr(a.length - v.length) == v;
			},
			"*=" : function(a, v) {
				return a && a.indexOf(v) !== -1;
			},
			"%=" : function(a, v) {
				return (a % v) == 0;
			}
		},
		pseudos : {
			"first-child" : function(c) {
				var r = [], n;
				for ( var i = 0, ci; ci = n = c[i]; i++) {
					while ((n = n.previousSibling) && n.nodeType != 1) {
					}
					if (!n) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"last-child" : function(c) {
				var r = [];
				for ( var i = 0, ci; ci = n = c[i]; i++) {
					while ((n = n.nextSibling) && n.nodeType != 1) {
					}
					if (!n) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"nth-child" : function(c, a) {
				var r = [];
				if (a != "odd" && a != "even") {
					for ( var i = 0, ci; ci = c[i]; i++) {
						var m = child(ci.parentNode, a);
						if (m == ci) {
							r[r.length] = m;
						}
					}
					return r;
				}
				var p;
				for ( var i = 0, l = c.length; i < l; i++) {
					var cp = c[i].parentNode;
					if (cp != p) {
						clean(cp);
						p = cp;
					}
				}
				for ( var i = 0, ci; ci = c[i]; i++) {
					var m = false;
					if (a == "odd") {
						m = ((ci.nodeIndex + 1) % 2 == 1);
					} else {
						if (a == "even") {
							m = ((ci.nodeIndex + 1) % 2 == 0);
						}
					}
					if (m) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"only-child" : function(c) {
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					if (!prev(ci) && !next(ci)) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"empty" : function(c) {
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					var cns = ci.childNodes, j = 0, cn, _bd = true;
					while (cn = cns[j]) {
						++j;
						if (cn.nodeType == 1 || cn.nodeType == 3) {
							_bd = false;
							break;
						}
					}
					if (_bd) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"contains" : function(c, v) {
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					if (ci.innerHTML.indexOf(v) !== -1) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"nodeValue" : function(c, v) {
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					if (ci.firstChild && ci.firstChild.nodeValue == v) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"checked" : function(c) {
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					if (ci.checked == true) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"not" : function(c, ss) {
				return Ext.DomQuery.filter(c, ss, true);
			},
			"odd" : function(c) {
				return this["nth-child"](c, "odd");
			},
			"even" : function(c) {
				return this["nth-child"](c, "even");
			},
			"nth" : function(c, a) {
				return c[a - 1] || [];
			},
			"first" : function(c) {
				return c[0] || [];
			},
			"last" : function(c) {
				return c[c.length - 1] || [];
			},
			"has" : function(c, ss) {
				var s = Ext.DomQuery.select;
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					if (s(ss, ci).length > 0) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"next" : function(c, ss) {
				var is = Ext.DomQuery.is;
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					var n = next(ci);
					if (n && is(n, ss)) {
						r[r.length] = ci;
					}
				}
				return r;
			},
			"prev" : function(c, ss) {
				var is = Ext.DomQuery.is;
				var r = [];
				for ( var i = 0, ci; ci = c[i]; i++) {
					var n = prev(ci);
					if (n && is(n, ss)) {
						r[r.length] = ci;
					}
				}
				return r;
			}
		}
	};
}();
Ext.query = Ext.DomQuery.select;

Ext.util.Observable = function() {
	if (this.listeners) {
		this.on(this.listeners);
		delete this.listeners;
	}
};
Ext.util.Observable.prototype = {
	fireEvent : function() {
		var ce = this.events[arguments[0].toLowerCase()];
		if (typeof ce == "object") {
			return ce.fire.apply(ce, Array.prototype.slice.call(arguments, 1));
		} else {
			return true;
		}
	},
	filterOptRe : /^(?:scope|delay|buffer|single)$/,
	addListener : function(_2, fn, _4, o) {
		if (typeof _2 == "object") {
			o = _2;
			for ( var e in o) {
				if (this.filterOptRe.test(e)) {
					continue;
				}
				if (typeof o[e] == "function") {
					this.addListener(e, o[e], o.scope, o);
				} else {
					this.addListener(e, o[e].fn, o[e].scope, o[e]);
				}
			}
			return;
		}
		o = (!o || typeof o == "boolean") ? {} : o;
		_2 = _2.toLowerCase();
		var ce = this.events[_2] || true;
		if (typeof ce == "boolean") {
			ce = new Ext.util.Event(this, _2);
			this.events[_2] = ce;
		}
		ce.addListener(fn, _4, o);
	},
	removeListener : function(_8, fn, _a) {
		var ce = this.events[_8.toLowerCase()];
		if (typeof ce == "object") {
			ce.removeListener(fn, _a);
		}
	},
	purgeListeners : function() {
		for ( var _c in this.events) {
			if (typeof this.events[_c] == "object") {
				this.events[_c].clearListeners();
			}
		}
	},
	relayEvents : function(o, _e) {
		var _f = function(_10) {
			return function() {
				return this.fireEvent.apply(this, Ext.combine(_10,
						Array.prototype.slice.call(arguments, 0)));
			};
		};
		for ( var i = 0, len = _e.length; i < len; i++) {
			var _13 = _e[i];
			if (!this.events[_13]) {
				this.events[_13] = true;
			}
			o.on(_13, _f(_13), this);
		}
	},
	addEvents : function(o) {
		if (!this.events) {
			this.events = {};
		}
		Ext.applyIf(this.events, o);
	},
	hasListener : function(_15) {
		var e = this.events[_15];
		return typeof e == "object" && e.listeners.length > 0;
	}
};
Ext.util.Observable.prototype.on = Ext.util.Observable.prototype.addListener;
Ext.util.Observable.prototype.un = Ext.util.Observable.prototype.removeListener;
Ext.util.Observable.capture = function(o, fn, _19) {
	o.fireEvent = o.fireEvent.createInterceptor(fn, _19);
};
Ext.util.Observable.releaseCapture = function(o) {
	o.fireEvent = Ext.util.Observable.prototype.fireEvent;
};
(function() {
	var _1b = function(h, o, _1e) {
		var _1f = new Ext.util.DelayedTask();
		return function() {
			_1f.delay(o.buffer, h, _1e, Array.prototype.slice
					.call(arguments, 0));
		};
	};
	var _20 = function(h, e, fn, _24) {
		return function() {
			e.removeListener(fn, _24);
			return h.apply(_24, arguments);
		};
	};
	var _25 = function(h, o, _28) {
		return function() {
			var _29 = Array.prototype.slice.call(arguments, 0);
			setTimeout(function() {
				h.apply(_28, _29);
			}, o.delay || 10);
		};
	};
	Ext.util.Event = function(obj, _2b) {
		this.name = _2b;
		this.obj = obj;
		this.listeners = [];
	};
	Ext.util.Event.prototype = {
		addListener : function(fn, _2d, _2e) {
			var o = _2e || {};
			_2d = _2d || this.obj;
			if (!this.isListening(fn, _2d)) {
				var l = {
					fn : fn,
					scope : _2d,
					options : o
				};
				var h = fn;
				if (o.delay) {
					h = _25(h, o, _2d);
				}
				if (o.single) {
					h = _20(h, this, fn, _2d);
				}
				if (o.buffer) {
					h = _1b(h, o, _2d);
				}
				l.fireFn = h;
				if (!this.firing) {
					this.listeners.push(l);
				} else {
					this.listeners = this.listeners.slice(0);
					this.listeners.push(l);
				}
			}
		},
		findListener : function(fn, _33) {
			_33 = _33 || this.obj;
			var ls = this.listeners;
			for ( var i = 0, len = ls.length; i < len; i++) {
				var l = ls[i];
				if (l.fn == fn && l.scope == _33) {
					return i;
				}
			}
			return -1;
		},
		isListening : function(fn, _39) {
			return this.findListener(fn, _39) != -1;
		},
		removeListener : function(fn, _3b) {
			var _3c;
			if ((_3c = this.findListener(fn, _3b)) != -1) {
				if (!this.firing) {
					this.listeners.splice(_3c, 1);
				} else {
					this.listeners = this.listeners.slice(0);
					this.listeners.splice(_3c, 1);
				}
				return true;
			}
			return false;
		},
		clearListeners : function() {
			this.listeners = [];
		},
		fire : function() {
			var ls = this.listeners, _3e, len = ls.length;
			if (len > 0) {
				this.firing = true;
				var _40 = Array.prototype.slice.call(arguments, 0);
				for ( var i = 0; i < len; i++) {
					var l = ls[i];
					if (l.fireFn.apply(l.scope, arguments) === false) {
						this.firing = false;
						return false;
					}
				}
				this.firing = false;
			}
			return true;
		}
	};
})();

Ext.EventManager = function() {
	var _1, _2, _3 = false;
	var _4, _5, _6, _7;
	var E = Ext.lib.Event;
	var D = Ext.lib.Dom;
	var _a = function() {
		if (!_3) {
			_3 = true;
			if (_2) {
				clearInterval(_2);
			}
			if (Ext.isGecko || Ext.isOpera) {
				document.removeEventListener("DOMContentLoaded", _a, false);
			}
			if (_1) {
				_1.fire();
				_1.clearListeners();
			}
		}
	};
	var _b = function() {
		_1 = new Ext.util.Event();
		if (Ext.isGecko || Ext.isOpera) {
			document.addEventListener("DOMContentLoaded", _a, false);
		} else {
			if (Ext.isIE) {
				document
						.write("<s"
								+ "cript id=\"ie-deferred-loader\" defer=\"defer\" src=\"/"
								+ "/:\"></s" + "cript>");
				E.on("ie-deferred-loader", "readystatechange", function() {
					if (this.readyState == "complete") {
						_a();
					}
				});
			} else {
				if (Ext.isSafari) {
					_2 = setInterval(function() {
						var rs = document.readyState;
						if (rs == "complete") {
							_a();
						}
					}, 10);
				}
			}
		}
		E.on(window, "load", _a);
	};
	var _d = function(h, o) {
		var _10 = new Ext.util.DelayedTask(h);
		return function(e) {
			e = new Ext.EventObjectImpl(e);
			_10.delay(o.buffer, h, null, [ e ]);
		};
	};
	var _12 = function(h, el, _15, fn) {
		return function(e) {
			Ext.EventManager.removeListener(el, _15, fn);
			h(e);
		};
	};
	var _18 = function(h, o) {
		return function(e) {
			e = new Ext.EventObjectImpl(e);
			setTimeout(function() {
				h(e);
			}, o.delay || 10);
		};
	};
	var _1c = function(_1d, _1e, opt, fn, _21) {
		var o = (!opt || typeof opt == "boolean") ? {} : opt;
		fn = fn || o.fn;
		_21 = _21 || o.scope;
		var el = Ext.getDom(_1d);
		if (!el) {
			throw "Error listening for " + _1e + ". Element " + _1d
					+ " doesn't exist.";
		}
		var h = function(e) {
			e = Ext.EventObject.setEvent(e);
			var t;
			if (o.delegate) {
				t = e.getTarget(o.delegate, el);
				if (!t) {
					return;
				}
			} else {
				t = e.target;
			}
			if (o.stopEvent === true) {
				e.stopEvent();
			}
			if (o.preventDefault === true) {
				e.preventDefault();
			}
			if (o.stopPropagation === true) {
				e.stopPropagation();
			}
			if (o.normalized === false) {
				e = e.browserEvent;
			}
			fn.call(_21 || el, e, t, o);
		};
		if (o.delay) {
			h = _18(h, o);
		}
		if (o.single) {
			h = _12(h, el, _1e, fn);
		}
		if (o.buffer) {
			h = _d(h, o);
		}
		fn._handlers = fn._handlers || [];
		fn._handlers.push( [ Ext.id(el), _1e, h ]);
		E.on(el, _1e, h);
		if (_1e == "mousewheel" && el.addEventListener) {
			el.addEventListener("DOMMouseScroll", h, false);
			E.on(window, "unload", function() {
				el.removeEventListener("DOMMouseScroll", h, false);
			});
		}
		if (_1e == "mousedown" && el == document) {
			Ext.EventManager.stoppedMouseDownEvent.addListener(h);
		}
		return h;
	};
	var _27 = function(el, _29, fn) {
		var id = Ext.id(el), hds = fn._handlers;
		if (hds) {
			for ( var i = 0, len = hds.length; i < len; i++) {
				var h = hds[i];
				if (h[0] == id && h[1] == _29) {
					var hd = h[2];
					hds.splice(i, 1);
					return E.un(el, _29, hd);
				}
			}
		}
		E.un(el, _29, fn);
		el = Ext.getDom(el);
		if (_29 == "mousewheel" && el.addEventListener) {
			el.removeEventListener("DOMMouseScroll", fn, false);
		}
		if (_29 == "mousedown" && el == document) {
			Ext.EventManager.stoppedMouseDownEvent.removeListener(fn);
		}
	};
	var _31 = /^(?:scope|delay|buffer|single|stopEvent|preventDefault|stopPropagation|normalized)$/;
	var pub = {
		wrap : function(fn, _34, _35) {
			return function(e) {
				Ext.EventObject.setEvent(e);
				fn.call(_35 ? _34 || window : window, Ext.EventObject, _34);
			};
		},
		addListener : function(_37, _38, fn, _3a, _3b) {
			if (typeof _38 == "object") {
				var o = _38;
				for ( var e in o) {
					if (_31.test(e)) {
						continue;
					}
					if (typeof o[e] == "function") {
						_1c(_37, e, o, o[e], o.scope);
					} else {
						_1c(_37, e, o[e]);
					}
				}
				return;
			}
			return _1c(_37, _38, _3b, fn, _3a);
		},
		removeListener : function(_3e, _3f, fn) {
			return _27(_3e, _3f, fn);
		},
		onDocumentReady : function(fn, _42, _43) {
			if (_3) {
				fn.call(_42 || window, _42);
				return;
			}
			if (!_1) {
				_b();
			}
			_1.addListener(fn, _42, _43);
		},
		onWindowResize : function(fn, _45, _46) {
			if (!_4) {
				_4 = new Ext.util.Event();
				_5 = new Ext.util.DelayedTask(function() {
					_4.fire(D.getViewWidth(), D.getViewHeight());
				});
				E.on(window, "resize", function() {
					if (Ext.isIE) {
						_5.delay(50);
					} else {
						_4.fire(D.getViewWidth(), D.getViewHeight());
					}
				});
			}
			_4.addListener(fn, _45, _46);
		},
		onTextResize : function(fn, _48, _49) {
			if (!_6) {
				_6 = new Ext.util.Event();
				var _4a = new Ext.Element(document.createElement("div"));
				_4a.dom.className = "x-text-resize";
				_4a.dom.innerHTML = "X";
				_4a.appendTo(document.body);
				_7 = _4a.dom.offsetHeight;
				setInterval(function() {
					if (_4a.dom.offsetHeight != _7) {
						_6.fire(_7, _7 = _4a.dom.offsetHeight);
					}
				}, this.textResizeInterval);
			}
			_6.addListener(fn, _48, _49);
		},
		removeResizeListener : function(fn, _4c) {
			if (_4) {
				_4.removeListener(fn, _4c);
			}
		},
		fireResize : function() {
			if (_4) {
				_4.fire(D.getViewWidth(), D.getViewHeight());
			}
		},
		ieDeferSrc : false,
		textResizeInterval : 50
	};
	pub.on = pub.addListener;
	pub.un = pub.removeListener;
	pub.stoppedMouseDownEvent = new Ext.util.Event();
	return pub;
}();
Ext.onReady = Ext.EventManager.onDocumentReady;
Ext.onReady(function() {
	var bd = Ext.get(document.body);
	if (!bd) {
		return;
	}
	var cls = Ext.isIE ? "ext-ie" : Ext.isGecko ? "ext-gecko"
			: Ext.isOpera ? "ext-opera" : Ext.isSafari ? "ext-safari" : "";
	if (Ext.isBorderBox) {
		cls += " ext-border-box";
	}
	if (Ext.isStrict) {
		cls += " ext-strict";
	}
	bd.addClass(cls);
});
Ext.EventObject = function() {
	var E = Ext.lib.Event;
	var _50 = {
		63234 : 37,
		63235 : 39,
		63232 : 38,
		63233 : 40,
		63276 : 33,
		63277 : 34,
		63272 : 46,
		63273 : 36,
		63275 : 35
	};
	var _51 = Ext.isIE ? {
		1 : 0,
		4 : 1,
		2 : 2
	} : (Ext.isSafari ? {
		1 : 0,
		2 : 1,
		3 : 2
	} : {
		0 : 0,
		1 : 1,
		2 : 2
	});
	Ext.EventObjectImpl = function(e) {
		if (e) {
			this.setEvent(e.browserEvent || e);
		}
	};
	Ext.EventObjectImpl.prototype = {
		browserEvent : null,
		button : -1,
		shiftKey : false,
		ctrlKey : false,
		altKey : false,
		BACKSPACE : 8,
		TAB : 9,
		RETURN : 13,
		ENTER : 13,
		SHIFT : 16,
		CONTROL : 17,
		ESC : 27,
		SPACE : 32,
		PAGEUP : 33,
		PAGEDOWN : 34,
		END : 35,
		HOME : 36,
		LEFT : 37,
		UP : 38,
		RIGHT : 39,
		DOWN : 40,
		DELETE : 46,
		F5 : 116,
		setEvent : function(e) {
			if (e == this || (e && e.browserEvent)) {
				return e;
			}
			this.browserEvent = e;
			if (e) {
				this.button = e.button ? _51[e.button] : (e.which ? e.which - 1
						: -1);
				this.shiftKey = e.shiftKey;
				this.ctrlKey = e.ctrlKey || e.metaKey;
				this.altKey = e.altKey;
				this.keyCode = e.keyCode;
				this.charCode = e.charCode;
				this.target = E.getTarget(e);
				this.xy = E.getXY(e);
			} else {
				this.button = -1;
				this.shiftKey = false;
				this.ctrlKey = false;
				this.altKey = false;
				this.keyCode = 0;
				this.charCode = 0;
				this.target = null;
				this.xy = [ 0, 0 ];
			}
			return this;
		},
		stopEvent : function() {
			if (this.browserEvent) {
				if (this.browserEvent.type == "mousedown") {
					Ext.EventManager.stoppedMouseDownEvent.fire(this);
				}
				E.stopEvent(this.browserEvent);
			}
		},
		preventDefault : function() {
			if (this.browserEvent) {
				E.preventDefault(this.browserEvent);
			}
		},
		isNavKeyPress : function() {
			var k = this.keyCode;
			k = Ext.isSafari ? (_50[k] || k) : k;
			return (k >= 33 && k <= 40) || k == this.RETURN || k == this.TAB
					|| k == this.ESC;
		},
		isSpecialKey : function() {
			var k = this.keyCode;
			return k == 9 || k == 13 || k == 40 || k == 27 || (k == 16)
					|| (k == 17) || (k >= 18 && k <= 20)
					|| (k >= 33 && k <= 35) || (k >= 36 && k <= 39)
					|| (k >= 44 && k <= 45);
		},
		stopPropagation : function() {
			if (this.browserEvent) {
				if (this.browserEvent.type == "mousedown") {
					Ext.EventManager.stoppedMouseDownEvent.fire(this);
				}
				E.stopPropagation(this.browserEvent);
			}
		},
		getCharCode : function() {
			return this.charCode || this.keyCode;
		},
		getKey : function() {
			var k = this.keyCode || this.charCode;
			return Ext.isSafari ? (_50[k] || k) : k;
		},
		getPageX : function() {
			return this.xy[0];
		},
		getPageY : function() {
			return this.xy[1];
		},
		getTime : function() {
			if (this.browserEvent) {
				return E.getTime(this.browserEvent);
			}
			return null;
		},
		getXY : function() {
			return this.xy;
		},
		getTarget : function(_57, _58, _59) {
			return _57 ? Ext.fly(this.target).findParent(_57, _58, _59)
					: this.target;
		},
		getRelatedTarget : function() {
			if (this.browserEvent) {
				return E.getRelatedTarget(this.browserEvent);
			}
			return null;
		},
		getWheelDelta : function() {
			var e = this.browserEvent;
			var _5b = 0;
			if (e.wheelDelta) {
				_5b = e.wheelDelta / 120;
				if (window.opera) {
					_5b = -_5b;
				}
			} else {
				if (e.detail) {
					_5b = -e.detail / 3;
				}
			}
			return _5b;
		},
		hasModifier : function() {
			return ((this.ctrlKey || this.altKey) || this.shiftKey) ? true
					: false;
		},
		within : function(el, _5d) {
			var t = this[_5d ? "getRelatedTarget" : "getTarget"]();
			return t && Ext.fly(el).contains(t);
		},
		getPoint : function() {
			return new Ext.lib.Point(this.xy[0], this.xy[1]);
		}
	};
	return new Ext.EventObjectImpl();
}();

(function() {
	var D = Ext.lib.Dom;
	var E = Ext.lib.Event;
	var A = Ext.lib.Anim;
	var _4 = {};
	var _5 = /(-[a-z])/gi;
	var _6 = function(m, a) {
		return a.charAt(1).toUpperCase();
	};
	var _9 = document.defaultView;
	Ext.Element = function(_a, _b) {
		var _c = typeof _a == "string" ? document.getElementById(_a) : _a;
		if (!_c) {
			return null;
		}
		if (!_b && Ext.Element.cache[_c.id]) {
			return Ext.Element.cache[_c.id];
		}
		this.dom = _c;
		this.id = _c.id || Ext.id(_c);
	};
	var El = Ext.Element;
	El.prototype = {
		originalDisplay : "",
		visibilityMode : 1,
		defaultUnit : "px",
		setVisibilityMode : function(_e) {
			this.visibilityMode = _e;
			return this;
		},
		enableDisplayMode : function(_f) {
			this.setVisibilityMode(El.DISPLAY);
			if (typeof _f != "undefined") {
				this.originalDisplay = _f;
			}
			return this;
		},
		findParent : function(_10, _11, _12) {
			var p = this.dom, b = document.body, _15 = 0, dq = Ext.DomQuery, _17;
			_11 = _11 || 50;
			if (typeof _11 != "number") {
				_17 = Ext.getDom(_11);
				_11 = 10;
			}
			while (p && p.nodeType == 1 && _15 < _11 && p != b && p != _17) {
				if (dq.is(p, _10)) {
					return _12 ? Ext.get(p) : p;
				}
				_15++;
				p = p.parentNode;
			}
			return null;
		},
		findParentNode : function(_18, _19, _1a) {
			var p = Ext.fly(this.dom.parentNode, "_internal");
			return p ? p.findParent(_18, _19, _1a) : null;
		},
		up : function(_1c, _1d) {
			return this.findParentNode(_1c, _1d, true);
		},
		is : function(_1e) {
			return Ext.DomQuery.is(this.dom, _1e);
		},
		animate : function(_1f, _20, _21, _22, _23) {
			this.anim(_1f, {
				duration : _20,
				callback : _21,
				easing : _22
			}, _23);
			return this;
		},
		anim : function(_24, opt, _26, _27, _28, cb) {
			_26 = _26 || "run";
			opt = opt || {};
			var _2a = Ext.lib.Anim[_26](this.dom, _24,
					(opt.duration || _27) || 0.35, (opt.easing || _28)
							|| "easeOut", function() {
						Ext.callback(cb, this);
						Ext.callback(opt.callback, opt.scope || this, [ this,
								opt ]);
					}, this);
			opt.anim = _2a;
			return _2a;
		},
		preanim : function(a, i) {
			return !a[i] ? false : (typeof a[i] == "object" ? a[i] : {
				duration : a[i + 1],
				callback : a[i + 2],
				easing : a[i + 3]
			});
		},
		clean : function(_2d) {
			if (this.isCleaned && _2d !== true) {
				return this;
			}
			var ns = /\S/;
			var d = this.dom, n = d.firstChild, ni = -1;
			while (n) {
				var nx = n.nextSibling;
				if (n.nodeType == 3 && !ns.test(n.nodeValue)) {
					d.removeChild(n);
				} else {
					n.nodeIndex = ++ni;
				}
				n = nx;
			}
			this.isCleaned = true;
			return this;
		},
		calcOffsetsTo : function(el) {
			el = Ext.get(el), d = el.dom;
			var _34 = false;
			if (el.getStyle("position") == "static") {
				el.position("relative");
				_34 = true;
			}
			var x = 0, y = 0;
			var op = this.dom;
			while (op && op != d && op.tagName != "HTML") {
				x += op.offsetLeft;
				y += op.offsetTop;
				op = op.offsetParent;
			}
			if (_34) {
				el.position("static");
			}
			return [ x, y ];
		},
		scrollIntoView : function(_38, _39) {
			var c = Ext.getDom(_38) || document.body;
			var el = this.dom;
			var o = this.calcOffsetsTo(c), l = o[0], t = o[1], b = t
					+ el.offsetHeight, r = l + el.offsetWidth;
			var ch = c.clientHeight;
			var ct = parseInt(c.scrollTop, 10);
			var cl = parseInt(c.scrollLeft, 10);
			var cb = ct + ch;
			var cr = cl + c.clientWidth;
			if (t < ct) {
				c.scrollTop = t;
			} else {
				if (b > cb) {
					c.scrollTop = b - ch;
				}
			}
			if (_39 !== false) {
				if (l < cl) {
					c.scrollLeft = l;
				} else {
					if (r > cr) {
						c.scrollLeft = r - c.clientWidth;
					}
				}
			}
			return this;
		},
		scrollChildIntoView : function(_46) {
			Ext.fly(_46, "_scrollChildIntoView").scrollIntoView(this);
		},
		autoHeight : function(_47, _48, _49, _4a) {
			var _4b = this.getHeight();
			this.clip();
			this.setHeight(1);
			setTimeout(function() {
				var _4c = parseInt(this.dom.scrollHeight, 10);
				if (!_47) {
					this.setHeight(_4c);
					this.unclip();
					if (typeof _49 == "function") {
						_49();
					}
				} else {
					this.setHeight(_4b);
					this.setHeight(_4c, _47, _48, function() {
						this.unclip();
						if (typeof _49 == "function") {
							_49();
						}
					}.createDelegate(this), _4a);
				}
			}.createDelegate(this), 0);
			return this;
		},
		contains : function(el) {
			if (!el) {
				return false;
			}
			return D.isAncestor(this.dom, el.dom ? el.dom : el);
		},
		isVisible : function(_4e) {
			var vis = !(this.getStyle("visibility") == "hidden" || this
					.getStyle("display") == "none");
			if (_4e !== true || !vis) {
				return vis;
			}
			var p = this.dom.parentNode;
			while (p && p.tagName.toLowerCase() != "body") {
				if (!Ext.fly(p, "_isVisible").isVisible()) {
					return false;
				}
				p = p.parentNode;
			}
			return true;
		},
		select : function(_51, _52) {
			return El.select("#" + Ext.id(this.dom) + " " + _51, _52);
		},
		query : function(_53, _54) {
			return Ext.DomQuery.select(_53, this.dom);
		},
		child : function(_55, _56) {
			var n = Ext.DomQuery.selectNode(_55, this.dom);
			return _56 ? n : Ext.get(n);
		},
		initDD : function(_58, _59, _5a) {
			var dd = new Ext.dd.DD(Ext.id(this.dom), _58, _59);
			return Ext.apply(dd, _5a);
		},
		initDDProxy : function(_5c, _5d, _5e) {
			var dd = new Ext.dd.DDProxy(Ext.id(this.dom), _5c, _5d);
			return Ext.apply(dd, _5e);
		},
		initDDTarget : function(_60, _61, _62) {
			var dd = new Ext.dd.DDTarget(Ext.id(this.dom), _60, _61);
			return Ext.apply(dd, _62);
		},
		setVisible : function(_64, _65) {
			if (!_65 || !A) {
				if (this.visibilityMode == El.DISPLAY) {
					this.setDisplayed(_64);
				} else {
					this.fixDisplay();
					this.dom.style.visibility = _64 ? "visible" : "hidden";
				}
			} else {
				var dom = this.dom;
				var _67 = this.visibilityMode;
				if (_64) {
					this.setOpacity(0.01);
					this.setVisible(true);
				}
				this.anim( {
					opacity : {
						to : (_64 ? 1 : 0)
					}
				}, this.preanim(arguments, 1), null, 0.35, "easeIn",
						function() {
							if (!_64) {
								if (_67 == El.DISPLAY) {
									dom.style.display = "none";
								} else {
									dom.style.visibility = "hidden";
								}
								Ext.get(dom).setOpacity(1);
							}
						});
			}
			return this;
		},
		isDisplayed : function() {
			return this.getStyle("display") != "none";
		},
		toggle : function(_68) {
			this.setVisible(!this.isVisible(), this.preanim(arguments, 0));
			return this;
		},
		setDisplayed : function(_69) {
			if (typeof _69 == "boolean") {
				_69 = _69 ? this.originalDisplay : "none";
			}
			this.setStyle("display", _69);
			return this;
		},
		focus : function() {
			try {
				this.dom.focus();
			} catch (e) {
			}
			return this;
		},
		blur : function() {
			try {
				this.dom.blur();
			} catch (e) {
			}
			return this;
		},
		addClass : function(_6a) {
			if (_6a instanceof Array) {
				for ( var i = 0, len = _6a.length; i < len; i++) {
					this.addClass(_6a[i]);
				}
			} else {
				if (_6a && !this.hasClass(_6a)) {
					this.dom.className = this.dom.className + " " + _6a;
				}
			}
			return this;
		},
		radioClass : function(_6d) {
			var _6e = this.dom.parentNode.childNodes;
			for ( var i = 0; i < _6e.length; i++) {
				var s = _6e[i];
				if (s.nodeType == 1) {
					Ext.get(s).removeClass(_6d);
				}
			}
			this.addClass(_6d);
			return this;
		},
		removeClass : function(_71) {
			if (!_71 || !this.dom.className) {
				return this;
			}
			if (_71 instanceof Array) {
				for ( var i = 0, len = _71.length; i < len; i++) {
					this.removeClass(_71[i]);
				}
			} else {
				if (this.hasClass(_71)) {
					var re = this.classReCache[_71];
					if (!re) {
						re = new RegExp("(?:^|\\s+)" + _71 + "(?:\\s+|$)", "g");
						this.classReCache[_71] = re;
					}
					this.dom.className = this.dom.className.replace(re, " ");
				}
			}
			return this;
		},
		classReCache : {},
		toggleClass : function(_75) {
			if (this.hasClass(_75)) {
				this.removeClass(_75);
			} else {
				this.addClass(_75);
			}
			return this;
		},
		hasClass : function(_76) {
			return _76
					&& (" " + this.dom.className + " ")
							.indexOf(" " + _76 + " ") != -1;
		},
		replaceClass : function(_77, _78) {
			this.removeClass(_77);
			this.addClass(_78);
			return this;
		},
		getStyles : function() {
			var a = arguments, len = a.length, r = {};
			for ( var i = 0; i < len; i++) {
				r[a[i]] = this.getStyle(a[i]);
			}
			return r;
		},
		getStyle : function() {
			return _9 && _9.getComputedStyle ? function(_7d) {
				var el = this.dom, v, cs, _81;
				if (_7d == "float") {
					_7d = "cssFloat";
				}
				if (v = el.style[_7d]) {
					return v;
				}
				if (cs = _9.getComputedStyle(el, "")) {
					if (!(_81 = _4[_7d])) {
						_81 = _4[_7d] = _7d.replace(_5, _6);
					}
					return cs[_81];
				}
				return null;
			} : function(_82) {
				var el = this.dom, v, cs, _86;
				if (_82 == "opacity") {
					if (typeof el.filter == "string") {
						var fv = parseFloat(el.filter
								.match(/alpha\(opacity=(.*)\)/i)[1]);
						if (!isNaN(fv)) {
							return fv ? fv / 100 : 0;
						}
					}
					return 1;
				} else {
					if (_82 == "float") {
						_82 = "styleFloat";
					}
				}
				if (!(_86 = _4[_82])) {
					_86 = _4[_82] = _82.replace(_5, _6);
				}
				if (v = el.style[_86]) {
					return v;
				}
				if (cs = el.currentStyle) {
					return cs[_86];
				}
				return null;
			};
		}(),
		setStyle : function(_88, _89) {
			if (typeof _88 == "string") {
				var _8a;
				if (!(_8a = _4[_88])) {
					_8a = _4[_88] = _88.replace(_5, _6);
				}
				if (_8a == "opacity") {
					this.setOpacity(_89);
				} else {
					this.dom.style[_8a] = _89;
				}
			} else {
				for ( var _8b in _88) {
					if (typeof _88[_8b] != "function") {
						this.setStyle(_8b, _88[_8b]);
					}
				}
			}
			return this;
		},
		applyStyles : function(_8c) {
			Ext.DomHelper.applyStyles(this.dom, _8c);
			return this;
		},
		getX : function() {
			return D.getX(this.dom);
		},
		getY : function() {
			return D.getY(this.dom);
		},
		getXY : function() {
			return D.getXY(this.dom);
		},
		setX : function(x, _8e) {
			if (!_8e || !A) {
				D.setX(this.dom, x);
			} else {
				this.setXY( [ x, this.getY() ], this.preanim(arguments, 1));
			}
			return this;
		},
		setY : function(y, _90) {
			if (!_90 || !A) {
				D.setY(this.dom, y);
			} else {
				this.setXY( [ this.getX(), y ], this.preanim(arguments, 1));
			}
			return this;
		},
		setLeft : function(_91) {
			this.setStyle("left", this.addUnits(_91));
			return this;
		},
		setTop : function(top) {
			this.setStyle("top", this.addUnits(top));
			return this;
		},
		setRight : function(_93) {
			this.setStyle("right", this.addUnits(_93));
			return this;
		},
		setBottom : function(_94) {
			this.setStyle("bottom", this.addUnits(_94));
			return this;
		},
		setXY : function(pos, _96) {
			if (!_96 || !A) {
				D.setXY(this.dom, pos);
			} else {
				this.anim( {
					points : {
						to : pos
					}
				}, this.preanim(arguments, 1), "motion");
			}
			return this;
		},
		setLocation : function(x, y, _99) {
			this.setXY( [ x, y ], this.preanim(arguments, 2));
			return this;
		},
		moveTo : function(x, y, _9c) {
			this.setXY( [ x, y ], this.preanim(arguments, 2));
			return this;
		},
		getRegion : function() {
			return D.getRegion(this.dom);
		},
		getHeight : function(_9d) {
			var h = this.dom.offsetHeight || 0;
			return _9d !== true ? h : h - this.getBorderWidth("tb")
					- this.getPadding("tb");
		},
		getWidth : function(_9f) {
			var w = this.dom.offsetWidth || 0;
			return _9f !== true ? w : w - this.getBorderWidth("lr")
					- this.getPadding("lr");
		},
		getComputedHeight : function() {
			var h = Math.max(this.dom.offsetHeight, this.dom.clientHeight);
			if (!h) {
				h = parseInt(this.getStyle("height"), 10) || 0;
				if (!this.isBorderBox()) {
					h += this.getFrameWidth("tb");
				}
			}
			return h;
		},
		getComputedWidth : function() {
			var w = Math.max(this.dom.offsetWidth, this.dom.clientWidth);
			if (!w) {
				w = parseInt(this.getStyle("width"), 10) || 0;
				if (!this.isBorderBox()) {
					w += this.getFrameWidth("lr");
				}
			}
			return w;
		},
		getSize : function(_a3) {
			return {
				width : this.getWidth(_a3),
				height : this.getHeight(_a3)
			};
		},
		getValue : function(_a4) {
			return _a4 ? parseInt(this.dom.value, 10) : this.dom.value;
		},
		adjustWidth : function(_a5) {
			if (typeof _a5 == "number") {
				if (this.autoBoxAdjust && !this.isBorderBox()) {
					_a5 -= (this.getBorderWidth("lr") + this.getPadding("lr"));
				}
				if (_a5 < 0) {
					_a5 = 0;
				}
			}
			return _a5;
		},
		adjustHeight : function(_a6) {
			if (typeof _a6 == "number") {
				if (this.autoBoxAdjust && !this.isBorderBox()) {
					_a6 -= (this.getBorderWidth("tb") + this.getPadding("tb"));
				}
				if (_a6 < 0) {
					_a6 = 0;
				}
			}
			return _a6;
		},
		setWidth : function(_a7, _a8) {
			_a7 = this.adjustWidth(_a7);
			if (!_a8 || !A) {
				this.dom.style.width = this.addUnits(_a7);
			} else {
				this.anim( {
					width : {
						to : _a7
					}
				}, this.preanim(arguments, 1));
			}
			return this;
		},
		setHeight : function(_a9, _aa) {
			_a9 = this.adjustHeight(_a9);
			if (!_aa || !A) {
				this.dom.style.height = this.addUnits(_a9);
			} else {
				this.anim( {
					height : {
						to : _a9
					}
				}, this.preanim(arguments, 1));
			}
			return this;
		},
		setSize : function(_ab, _ac, _ad) {
			if (typeof _ab == "object") {
				_ac = _ab.height;
				_ab = _ab.width;
			}
			_ab = this.adjustWidth(_ab);
			_ac = this.adjustHeight(_ac);
			if (!_ad || !A) {
				this.dom.style.width = this.addUnits(_ab);
				this.dom.style.height = this.addUnits(_ac);
			} else {
				this.anim( {
					width : {
						to : _ab
					},
					height : {
						to : _ac
					}
				}, this.preanim(arguments, 2));
			}
			return this;
		},
		setBounds : function(x, y, _b0, _b1, _b2) {
			if (!_b2 || !A) {
				this.setSize(_b0, _b1);
				this.setLocation(x, y);
			} else {
				_b0 = this.adjustWidth(_b0);
				_b1 = this.adjustHeight(_b1);
				this.anim( {
					points : {
						to : [ x, y ]
					},
					width : {
						to : _b0
					},
					height : {
						to : _b1
					}
				}, this.preanim(arguments, 4), "motion");
			}
			return this;
		},
		setRegion : function(_b3, _b4) {
			this.setBounds(_b3.left, _b3.top, _b3.right - _b3.left, _b3.bottom
					- _b3.top, this.preanim(arguments, 1));
			return this;
		},
		addListener : function(_b5, fn, _b7, _b8) {
			Ext.EventManager.on(this.dom, _b5, fn, _b7 || this, _b8);
		},
		removeListener : function(_b9, fn) {
			Ext.EventManager.removeListener(this.dom, _b9, fn);
			return this;
		},
		removeAllListeners : function() {
			E.purgeElement(this.dom);
			return this;
		},
		relayEvent : function(_bb, _bc) {
			this.on(_bb, function(e) {
				_bc.fireEvent(_bb, e);
			});
		},
		setOpacity : function(_be, _bf) {
			if (!_bf || !A) {
				var s = this.dom.style;
				if (Ext.isIE) {
					s.zoom = 1;
					s.filter = (s.filter || "")
							.replace(/alpha\([^\)]*\)/gi, "")
							+ (_be == 1 ? "" : "alpha(opacity=" + _be * 100
									+ ")");
				} else {
					s.opacity = _be;
				}
			} else {
				this.anim( {
					opacity : {
						to : _be
					}
				}, this.preanim(arguments, 1), null, 0.35, "easeIn");
			}
			return this;
		},
		getLeft : function(_c1) {
			if (!_c1) {
				return this.getX();
			} else {
				return parseInt(this.getStyle("left"), 10) || 0;
			}
		},
		getRight : function(_c2) {
			if (!_c2) {
				return this.getX() + this.getWidth();
			} else {
				return (this.getLeft(true) + this.getWidth()) || 0;
			}
		},
		getTop : function(_c3) {
			if (!_c3) {
				return this.getY();
			} else {
				return parseInt(this.getStyle("top"), 10) || 0;
			}
		},
		getBottom : function(_c4) {
			if (!_c4) {
				return this.getY() + this.getHeight();
			} else {
				return (this.getTop(true) + this.getHeight()) || 0;
			}
		},
		position : function(pos, _c6, x, y) {
			if (!pos) {
				if (this.getStyle("position") == "static") {
					this.setStyle("position", "relative");
				}
			} else {
				this.setStyle("position", pos);
			}
			if (_c6) {
				this.setStyle("z-index", _c6);
			}
			if (x !== undefined && y !== undefined) {
				this.setXY( [ x, y ]);
			} else {
				if (x !== undefined) {
					this.setX(x);
				} else {
					if (y !== undefined) {
						this.setY(y);
					}
				}
			}
		},
		clearPositioning : function(_c9) {
			_c9 = _c9 || "";
			this.setStyle( {
				"left" : _c9,
				"right" : _c9,
				"top" : _c9,
				"bottom" : _c9,
				"z-index" : "",
				"position" : "static"
			});
			return this;
		},
		getPositioning : function() {
			var l = this.getStyle("left");
			var t = this.getStyle("top");
			return {
				"position" : this.getStyle("position"),
				"left" : l,
				"right" : l ? "" : this.getStyle("right"),
				"top" : t,
				"bottom" : t ? "" : this.getStyle("bottom"),
				"z-index" : this.getStyle("z-index")
			};
		},
		getBorderWidth : function(_cc) {
			return this.addStyles(_cc, El.borders);
		},
		getPadding : function(_cd) {
			return this.addStyles(_cd, El.paddings);
		},
		setPositioning : function(pc) {
			this.applyStyles(pc);
			if (pc.right == "auto") {
				this.dom.style.right = "";
			}
			if (pc.bottom == "auto") {
				this.dom.style.bottom = "";
			}
			return this;
		},
		fixDisplay : function() {
			if (this.getStyle("display") == "none") {
				this.setStyle("visibility", "hidden");
				this.setStyle("display", this.originalDisplay);
				if (this.getStyle("display") == "none") {
					this.setStyle("display", "block");
				}
			}
		},
		setLeftTop : function(_cf, top) {
			this.dom.style.left = this.addUnits(_cf);
			this.dom.style.top = this.addUnits(top);
			return this;
		},
		move : function(_d1, _d2, _d3) {
			var xy = this.getXY();
			_d1 = _d1.toLowerCase();
			switch (_d1) {
			case "l":
			case "left":
				this.moveTo(xy[0] - _d2, xy[1], this.preanim(arguments, 2));
				break;
			case "r":
			case "right":
				this.moveTo(xy[0] + _d2, xy[1], this.preanim(arguments, 2));
				break;
			case "t":
			case "top":
			case "up":
				this.moveTo(xy[0], xy[1] - _d2, this.preanim(arguments, 2));
				break;
			case "b":
			case "bottom":
			case "down":
				this.moveTo(xy[0], xy[1] + _d2, this.preanim(arguments, 2));
				break;
			}
			return this;
		},
		clip : function() {
			if (!this.isClipped) {
				this.isClipped = true;
				this.originalClip = {
					"o" : this.getStyle("overflow"),
					"x" : this.getStyle("overflow-x"),
					"y" : this.getStyle("overflow-y")
				};
				this.setStyle("overflow", "hidden");
				this.setStyle("overflow-x", "hidden");
				this.setStyle("overflow-y", "hidden");
			}
			return this;
		},
		unclip : function() {
			if (this.isClipped) {
				this.isClipped = false;
				var o = this.originalClip;
				if (o.o) {
					this.setStyle("overflow", o.o);
				}
				if (o.x) {
					this.setStyle("overflow-x", o.x);
				}
				if (o.y) {
					this.setStyle("overflow-y", o.y);
				}
			}
			return this;
		},
		getAnchorXY : function(_d6, _d7, s) {
			var w, h, vp = false;
			if (!s) {
				var d = this.dom;
				if (d == document.body || d == document) {
					vp = true;
					w = D.getViewWidth();
					h = D.getViewHeight();
				} else {
					w = this.getWidth();
					h = this.getHeight();
				}
			} else {
				w = s.width;
				h = s.height;
			}
			var x = 0, y = 0, r = Math.round;
			switch ((_d6 || "tl").toLowerCase()) {
			case "c":
				x = r(w * 0.5);
				y = r(h * 0.5);
				break;
			case "t":
				x = r(w * 0.5);
				y = 0;
				break;
			case "l":
				x = 0;
				y = r(h * 0.5);
				break;
			case "r":
				x = w;
				y = r(h * 0.5);
				break;
			case "b":
				x = r(w * 0.5);
				y = h;
				break;
			case "tl":
				x = 0;
				y = 0;
				break;
			case "bl":
				x = 0;
				y = h;
				break;
			case "br":
				x = w;
				y = h;
				break;
			case "tr":
				x = w;
				y = 0;
				break;
			}
			if (_d7 === true) {
				return [ x, y ];
			}
			if (vp) {
				var sc = this.getScroll();
				return [ x + sc.left, y + sc.top ];
			}
			var o = this.getXY();
			return [ x + o[0], y + o[1] ];
		},
		getAlignToXY : function(el, p, o) {
			el = Ext.get(el), d = this.dom;
			if (!el.dom) {
				throw "Element.alignTo with an element that doesn't exist";
			}
			var c = false;
			var p1 = "", p2 = "";
			o = o || [ 0, 0 ];
			if (!p) {
				p = "tl-bl";
			} else {
				if (p == "?") {
					p = "tl-bl?";
				} else {
					if (p.indexOf("-") == -1) {
						p = "tl-" + p;
					}
				}
			}
			p = p.toLowerCase();
			var m = p.match(/^([a-z]+)-([a-z]+)(\?)?$/);
			if (!m) {
				throw "Element.alignTo with an invalid alignment " + p;
			}
			p1 = m[1], p2 = m[2], c = m[3] ? true : false;
			var a1 = this.getAnchorXY(p1, true);
			var a2 = el.getAnchorXY(p2, false);
			var x = a2[0] - a1[0] + o[0];
			var y = a2[1] - a1[1] + o[1];
			if (c) {
				var w = this.getWidth(), h = this.getHeight(), r = el
						.getRegion();
				var dw = D.getViewWidth() - 5, dh = D.getViewHeight() - 5;
				var p1y = p1.charAt(0), p1x = p1.charAt(p1.length - 1);
				var p2y = p2.charAt(0), p2x = p2.charAt(p2.length - 1);
				var _f6 = ((p1y == "t" && p2y == "b") || (p1y == "b" && p2y == "t"));
				var _f7 = ((p1x == "r" && p2x == "l") || (p1x == "l" && p2x == "r"));
				var doc = document;
				var _f9 = (doc.documentElement.scrollLeft
						|| doc.body.scrollLeft || 0) + 5;
				var _fa = (doc.documentElement.scrollTop || doc.body.scrollTop || 0) + 5;
				if ((x + w) > dw) {
					x = _f7 ? r.left - w : dw - w;
				}
				if (x < _f9) {
					x = _f7 ? r.right : _f9;
				}
				if ((y + h) > dh) {
					y = _f6 ? r.top - h : dh - h;
				}
				if (y < _fa) {
					y = _f6 ? r.bottom : _fa;
				}
			}
			return [ x, y ];
		},
		alignTo : function(_fb, _fc, _fd, _fe) {
			var xy = this.getAlignToXY(_fb, _fc, _fd);
			this.setXY(xy, this.preanim(arguments, 3));
			return this;
		},
		anchorTo : function(el, _101, _102, _103, _104, _105) {
			var _106 = function() {
				this.alignTo(el, _101, _102, _103);
				Ext.callback(_105, this);
			};
			Ext.EventManager.onWindowResize(_106, this);
			var tm = typeof _104;
			if (tm != "undefined") {
				Ext.EventManager.on(window, "scroll", _106, this, {
					buffer : tm == "number" ? _104 : 50
				});
			}
			_106.call(this);
			return this;
		},
		clearOpacity : function() {
			if (window.ActiveXObject) {
				this.dom.style.filter = "";
			} else {
				this.dom.style.opacity = "";
				this.dom.style["-moz-opacity"] = "";
				this.dom.style["-khtml-opacity"] = "";
			}
			return this;
		},
		hide : function(_108) {
			this.setVisible(false, this.preanim(arguments, 0));
			return this;
		},
		show : function(_109) {
			this.setVisible(true, this.preanim(arguments, 0));
			return this;
		},
		addUnits : function(size) {
			return Ext.Element.addUnits(size, this.defaultUnit);
		},
		beginMeasure : function() {
			var el = this.dom;
			if (el.offsetWidth || el.offsetHeight) {
				return this;
			}
			var _10c = [];
			var p = this.dom, b = document.body;
			while ((!el.offsetWidth && !el.offsetHeight) && p && p.tagName
					&& p != b) {
				var pe = Ext.get(p);
				if (pe.getStyle("display") == "none") {
					_10c.push( {
						el : p,
						visibility : pe.getStyle("visibility")
					});
					p.style.visibility = "hidden";
					p.style.display = "block";
				}
				p = p.parentNode;
			}
			this._measureChanged = _10c;
			return this;
		},
		endMeasure : function() {
			var _110 = this._measureChanged;
			if (_110) {
				for ( var i = 0, len = _110.length; i < len; i++) {
					var r = _110[i];
					r.el.style.visibility = r.visibility;
					r.el.style.display = "none";
				}
				this._measureChanged = null;
			}
			return this;
		},
		update : function(html, _115, _116) {
			if (typeof html == "undefined") {
				html = "";
			}
			if (_115 !== true) {
				this.dom.innerHTML = html;
				if (typeof _116 == "function") {
					_116();
				}
				return this;
			}
			var id = Ext.id();
			var dom = this.dom;
			html += "<span id=\"" + id + "\"></span>";
			E.onAvailable(id, function() {
				var hd = document.getElementsByTagName("head")[0];
				var re = /(?:<script([^>]*)?>)((\n|\r|.)*?)(?:<\/script>)/img;
				var _11b = /\ssrc=([\'\"])(.*?)\1/i;
				var _11c;
				while (_11c = re.exec(html)) {
					var _11d = _11c[1] ? _11c[1].match(_11b) : false;
					if (_11d && _11d[2]) {
						var s = document.createElement("script");
						s.src = _11d[2];
						hd.appendChild(s);
					} else {
						if (_11c[2] && _11c[2].length > 0) {
							eval(_11c[2]);
						}
					}
				}
				var el = document.getElementById(id);
				if (el) {
					el.parentNode.removeChild(el);
				}
				if (typeof _116 == "function") {
					_116();
				}
			});
			dom.innerHTML = html.replace(
					/(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)/img, "");
			return this;
		},
		load : function() {
			var um = this.getUpdateManager();
			um.update.apply(um, arguments);
			return this;
		},
		getUpdateManager : function() {
			if (!this.updateManager) {
				this.updateManager = new Ext.UpdateManager(this);
			}
			return this.updateManager;
		},
		unselectable : function() {
			this.dom.unselectable = "on";
			this.swallowEvent("selectstart", true);
			this.applyStyles("-moz-user-select:none;-khtml-user-select:none;");
			this.addClass("x-unselectable");
			return this;
		},
		getCenterXY : function() {
			return this.getAlignToXY(document, "c-c");
		},
		center : function(_121) {
			this.alignTo(_121 || document, "c-c");
			return this;
		},
		isBorderBox : function() {
			return _122[this.dom.tagName.toLowerCase()] || Ext.isBorderBox;
		},
		getBox : function(_123, _124) {
			var xy;
			if (!_124) {
				xy = this.getXY();
			} else {
				var left = parseInt(this.getStyle("left"), 10) || 0;
				var top = parseInt(this.getStyle("top"), 10) || 0;
				xy = [ left, top ];
			}
			var el = this.dom, w = el.offsetWidth, h = el.offsetHeight, bx;
			if (!_123) {
				bx = {
					x : xy[0],
					y : xy[1],
					width : w,
					height : h
				};
			} else {
				var l = this.getBorderWidth("l") + this.getPadding("l");
				var r = this.getBorderWidth("r") + this.getPadding("r");
				var t = this.getBorderWidth("t") + this.getPadding("t");
				var b = this.getBorderWidth("b") + this.getPadding("b");
				bx = {
					x : xy[0] + l,
					y : xy[1] + t,
					width : w - (l + r),
					height : h - (t + b)
				};
			}
			bx.right = bx.x + bx.width;
			bx.bottom = bx.y + bx.height;
			return bx;
		},
		getFrameWidth : function(_130) {
			return this.getPadding(_130) + this.getBorderWidth(_130);
		},
		setBox : function(box, _132, _133) {
			var w = box.width, h = box.height;
			if ((_132 && !this.autoBoxAdjust) && !this.isBorderBox()) {
				w -= (this.getBorderWidth("lr") + this.getPadding("lr"));
				h -= (this.getBorderWidth("tb") + this.getPadding("tb"));
			}
			this.setBounds(box.x, box.y, w, h, this.preanim(arguments, 2));
			return this;
		},
		repaint : function() {
			var dom = this.dom;
			this.addClass("x-repaint");
			setTimeout(function() {
				Ext.get(dom).removeClass("x-repaint");
			}, 1);
			return this;
		},
		getMargins : function(side) {
			if (!side) {
				return {
					top : parseInt(this.getStyle("margin-top"), 10) || 0,
					left : parseInt(this.getStyle("margin-left"), 10) || 0,
					bottom : parseInt(this.getStyle("margin-bottom"), 10) || 0,
					right : parseInt(this.getStyle("margin-right"), 10) || 0
				};
			} else {
				return this.addStyles(side, El.margins);
			}
		},
		addStyles : function(_138, _139) {
			var val = 0;
			for ( var i = 0, len = _138.length; i < len; i++) {
				var w = parseInt(this.getStyle(_139[_138.charAt(i)]), 10);
				if (!isNaN(w)) {
					val += w;
				}
			}
			return val;
		},
		createProxy : function(_13e, _13f, _140) {
			if (_13f) {
				_13f = Ext.getDom(_13f);
			} else {
				_13f = document.body;
			}
			_13e = typeof _13e == "object" ? _13e : {
				tag : "div",
				cls : _13e
			};
			var _141 = Ext.DomHelper.append(_13f, _13e, true);
			if (_140) {
				_141.setBox(this.getBox());
			}
			return _141;
		},
		mask : function(msg, _143) {
			if (this.getStyle("position") == "static") {
				this.setStyle("position", "relative");
			}
			if (!this._mask) {
				this._mask = Ext.DomHelper.append(this.dom, {
					tag : "div",
					cls : "ext-el-mask"
				}, true);
			}
			this.addClass("x-masked");
			this._mask.setDisplayed(true);
			if (typeof msg == "string") {
				if (!this._maskMsg) {
					this._maskMsg = Ext.DomHelper.append(this.dom, {
						tag : "div",
						cls : "ext-el-mask-msg",
						cn : {
							tag : "div"
						}
					}, true);
				}
				var mm = this._maskMsg;
				mm.dom.className = _143 ? "ext-el-mask-msg " + _143
						: "ext-el-mask-msg";
				mm.dom.firstChild.innerHTML = msg;
				mm.setDisplayed(true);
				mm.center(this);
			}
			return this._mask;
		},
		unmask : function(_145) {
			if (this._mask) {
				if (_145 === true) {
					this._mask.remove();
					delete this._mask;
					if (this._maskMsg) {
						this._maskMsg.remove();
						delete this._maskMsg;
					}
				} else {
					this._mask.setDisplayed(false);
					if (this._maskMsg) {
						this._maskMsg.setDisplayed(false);
					}
				}
			}
			this.removeClass("x-masked");
		},
		isMasked : function() {
			return this._mask && this._mask.isVisible();
		},
		createShim : function() {
			var _146 = {
				tag : "iframe",
				frameBorder : "no",
				cls : "yiframe-shim",
				style : "position:absolute;visibility:hidden;left:0;top:0;overflow:hidden;",
				src : Ext.SSL_SECURE_URL
			};
			var shim = Ext.DomHelper.insertBefore(this.dom, _146, true);
			shim.setOpacity(0.01);
			shim.setBox(this.getBox());
			return shim;
		},
		remove : function() {
			if (this.dom.parentNode) {
				this.dom.parentNode.removeChild(this.dom);
			}
			delete El.cache[this.dom.id];
		},
		addClassOnOver : function(_148, _149) {
			this.on("mouseover", function() {
				Ext.fly(this, "_internal").addClass(_148);
			}, this.dom);
			var _14a = function(e) {
				if (_149 !== true || !e.within(this, true)) {
					Ext.fly(this, "_internal").removeClass(_148);
				}
			};
			this.on("mouseout", _14a, this.dom);
			return this;
		},
		addClassOnFocus : function(_14c) {
			this.on("focus", function() {
				Ext.fly(this, "_internal").addClass(_14c);
			}, this.dom);
			this.on("blur", function() {
				Ext.fly(this, "_internal").removeClass(_14c);
			}, this.dom);
			return this;
		},
		addClassOnClick : function(_14d) {
			var dom = this.dom;
			this.on("mousedown", function() {
				Ext.fly(dom, "_internal").addClass(_14d);
				var d = Ext.get(document);
				var fn = function() {
					Ext.fly(dom, "_internal").removeClass(_14d);
					d.removeListener("mouseup", fn);
				};
				d.on("mouseup", fn);
			});
			return this;
		},
		swallowEvent : function(_151, _152) {
			var fn = function(e) {
				e.stopPropagation();
				if (_152) {
					e.preventDefault();
				}
			};
			if (_151 instanceof Array) {
				for ( var i = 0, len = _151.length; i < len; i++) {
					this.on(_151[i], fn);
				}
				return this;
			}
			this.on(_151, fn);
			return this;
		},
		fitToParent : function(_157, _158) {
			var p = Ext.get(_158 || this.dom.parentNode);
			this.setSize(p.getComputedWidth() - p.getFrameWidth("lr"), p
					.getComputedHeight()
					- p.getFrameWidth("tb"));
			if (_157 === true) {
				Ext.EventManager.onWindowResize(this.fitToParent
						.createDelegate(this, []));
			}
			return this;
		},
		getNextSibling : function() {
			var n = this.dom.nextSibling;
			while (n && n.nodeType != 1) {
				n = n.nextSibling;
			}
			return n;
		},
		getPrevSibling : function() {
			var n = this.dom.previousSibling;
			while (n && n.nodeType != 1) {
				n = n.previousSibling;
			}
			return n;
		},
		appendChild : function(el) {
			el = Ext.get(el);
			el.appendTo(this);
			return this;
		},
		createChild : function(_15d, _15e, _15f) {
			_15d = _15d || {
				tag : "div"
			};
			if (_15e) {
				return Ext.DomHelper.insertBefore(_15e, _15d, _15f !== true);
			}
			return Ext.DomHelper.append(this.dom, _15d, _15f !== true);
		},
		appendTo : function(el) {
			el = Ext.getDom(el);
			el.appendChild(this.dom);
			return this;
		},
		insertBefore : function(el) {
			el = Ext.getDom(el);
			el.parentNode.insertBefore(this.dom, el);
			return this;
		},
		insertAfter : function(el) {
			el = Ext.getDom(el);
			el.parentNode.insertBefore(this.dom, el.nextSibling);
			return this;
		},
		insertFirst : function(el, _164) {
			el = el || {};
			if (typeof el == "object" && !el.nodeType) {
				return this.createChild(el, this.dom.firstChild, _164);
			} else {
				el = Ext.getDom(el);
				this.dom.insertBefore(el, this.dom.firstChild);
				return !_164 ? Ext.get(el) : el;
			}
		},
		insertSibling : function(el, _166, _167) {
			_166 = _166 ? _166.toLowerCase() : "before";
			el = el || {};
			var rt, _169 = _166 == "before" ? this.dom : this.dom.nextSibling;
			if (typeof el == "object" && !el.nodeType) {
				if (_166 == "after" && !this.dom.nextSibling) {
					rt = Ext.DomHelper.append(this.dom.parentNode, el, !_167);
				} else {
					rt = Ext.DomHelper[_166 == "after" ? "insertAfter"
							: "insertBefore"](this.dom, el, !_167);
				}
			} else {
				rt = this.dom.parentNode.insertBefore(Ext.getDom(el),
						_166 == "before" ? this.dom : this.dom.nextSibling);
				if (!_167) {
					rt = Ext.get(rt);
				}
			}
			return rt;
		},
		wrap : function(_16a, _16b) {
			if (!_16a) {
				_16a = {
					tag : "div"
				};
			}
			var _16c = Ext.DomHelper.insertBefore(this.dom, _16a, !_16b);
			_16c.dom ? _16c.dom.appendChild(this.dom) : _16c
					.appendChild(this.dom);
			return _16c;
		},
		replace : function(el) {
			el = Ext.get(el);
			this.insertBefore(el);
			el.remove();
			return this;
		},
		insertHtml : function(_16e, html) {
			return Ext.DomHelper.insertHtml(_16e, this.dom, html);
		},
		set : function(o, _171) {
			var el = this.dom;
			_171 = typeof _171 == "undefined" ? (el.setAttribute ? true : false)
					: _171;
			for ( var attr in o) {
				if (attr == "style" || typeof o[attr] == "function") {
					continue;
				}
				if (attr == "cls") {
					el.className = o["cls"];
				} else {
					if (_171) {
						el.setAttribute(attr, o[attr]);
					} else {
						el[attr] = o[attr];
					}
				}
			}
			Ext.DomHelper.applyStyles(el, o.style);
			return this;
		},
		addKeyListener : function(key, fn, _176) {
			var _177;
			if (typeof key != "object" || key instanceof Array) {
				_177 = {
					key : key,
					fn : fn,
					scope : _176
				};
			} else {
				_177 = {
					key : key.key,
					shift : key.shift,
					ctrl : key.ctrl,
					alt : key.alt,
					fn : fn,
					scope : _176
				};
			}
			return new Ext.KeyMap(this, _177);
		},
		addKeyMap : function(_178) {
			return new Ext.KeyMap(this, _178);
		},
		isScrollable : function() {
			var dom = this.dom;
			return dom.scrollHeight > dom.clientHeight
					|| dom.scrollWidth > dom.clientWidth;
		},
		scrollTo : function(side, _17b, _17c) {
			var prop = side.toLowerCase() == "left" ? "scrollLeft"
					: "scrollTop";
			if (!_17c || !A) {
				this.dom[prop] = _17b;
			} else {
				var to = prop == "scrollLeft" ? [ _17b, this.dom.scrollTop ]
						: [ this.dom.scrollLeft, _17b ];
				this.anim( {
					scroll : {
						"to" : to
					}
				}, this.preanim(arguments, 2), "scroll");
			}
			return this;
		},
		scroll : function(_17f, _180, _181) {
			if (!this.isScrollable()) {
				return;
			}
			var el = this.dom;
			var l = el.scrollLeft, t = el.scrollTop;
			var w = el.scrollWidth, h = el.scrollHeight;
			var cw = el.clientWidth, ch = el.clientHeight;
			_17f = _17f.toLowerCase();
			var _189 = false;
			var a = this.preanim(arguments, 2);
			switch (_17f) {
			case "l":
			case "left":
				if (w - l > cw) {
					var v = Math.min(l + _180, w - cw);
					this.scrollTo("left", v, a);
					_189 = true;
				}
				break;
			case "r":
			case "right":
				if (l > 0) {
					var v = Math.max(l - _180, 0);
					this.scrollTo("left", v, a);
					_189 = true;
				}
				break;
			case "t":
			case "top":
			case "up":
				if (t > 0) {
					var v = Math.max(t - _180, 0);
					this.scrollTo("top", v, a);
					_189 = true;
				}
				break;
			case "b":
			case "bottom":
			case "down":
				if (h - t > ch) {
					var v = Math.min(t + _180, h - ch);
					this.scrollTo("top", v, a);
					_189 = true;
				}
				break;
			}
			return _189;
		},
		translatePoints : function(x, y) {
			if (typeof x == "object" || x instanceof Array) {
				y = x[1];
				x = x[0];
			}
			var p = this.getStyle("position");
			var o = this.getXY();
			var l = parseInt(this.getStyle("left"), 10);
			var t = parseInt(this.getStyle("top"), 10);
			if (isNaN(l)) {
				l = (p == "relative") ? 0 : this.dom.offsetLeft;
			}
			if (isNaN(t)) {
				t = (p == "relative") ? 0 : this.dom.offsetTop;
			}
			return {
				left : (x - o[0] + l),
				top : (y - o[1] + t)
			};
		},
		getScroll : function() {
			var d = this.dom, doc = document;
			if (d == doc || d == doc.body) {
				var l = window.pageXOffset || doc.documentElement.scrollLeft
						|| doc.body.scrollLeft || 0;
				var t = window.pageYOffset || doc.documentElement.scrollTop
						|| doc.body.scrollTop || 0;
				return {
					left : l,
					top : t
				};
			} else {
				return {
					left : d.scrollLeft,
					top : d.scrollTop
				};
			}
		},
		getColor : function(attr, _197, _198) {
			var v = this.getStyle(attr);
			if (!v || v == "transparent" || v == "inherit") {
				return _197;
			}
			var _19a = typeof _198 == "undefined" ? "#" : _198;
			if (v.substr(0, 4) == "rgb(") {
				var rvs = v.slice(4, v.length - 1).split(",");
				for ( var i = 0; i < 3; i++) {
					var h = parseInt(rvs[i]).toString(16);
					if (h < 16) {
						h = "0" + h;
					}
					_19a += h;
				}
			} else {
				if (v.substr(0, 1) == "#") {
					if (v.length == 4) {
						for ( var i = 1; i < 4; i++) {
							var c = v.charAt(i);
							_19a += c + c;
						}
					} else {
						if (v.length == 7) {
							_19a += v.substr(1);
						}
					}
				}
			}
			return (_19a.length > 5 ? _19a.toLowerCase() : _197);
		},
		boxWrap : function(cls) {
			cls = cls || "x-box";
			var el = Ext
					.get(this
							.insertHtml(
									"beforeBegin",
									String
											.format(
													"<div class=\"{0}\"><div class=\"{0}-tl\"><div class=\"{0}-tr\"><div class=\"{0}-tc\"></div></div></div><div class=\"{0}-ml\"><div class=\"{0}-mr\"><div class=\"{0}-mc\"></div></div></div><div class=\"{0}-bl\"><div class=\"{0}-br\"><div class=\"{0}-bc\"></div></div></div></div>",
													cls)));
			el.child("." + cls + "-mc").dom.appendChild(this.dom);
			return el;
		},
		getAttributeNS : Ext.isIE ? function(ns, name) {
			var d = this.dom;
			var type = typeof d[ns + ":" + name];
			if (type != "undefined" && type != "unknown") {
				return d[ns + ":" + name];
			}
			return d[name];
		} : function(ns, name) {
			var d = this.dom;
			return d.getAttributeNS(ns, name)
					|| d.getAttribute(ns + ":" + name) || d.getAttribute(name)
					|| d[name];
		}
	};
	var ep = El.prototype;
	ep.on = ep.addListener;
	ep.mon = ep.addListener;
	ep.un = ep.removeListener;
	ep.autoBoxAdjust = true;
	ep.autoDisplayMode = true;
	El.unitPattern = /\d+(px|em|%|en|ex|pt|in|cm|mm|pc)$/i;
	El.addUnits = function(v, _1aa) {
		if (v === "" || v == "auto") {
			return v;
		}
		if (v === undefined) {
			return "";
		}
		if (typeof v == "number" || !El.unitPattern.test(v)) {
			return v + (_1aa || "px");
		}
		return v;
	};
	El.VISIBILITY = 1;
	El.DISPLAY = 2;
	El.borders = {
		l : "border-left-width",
		r : "border-right-width",
		t : "border-top-width",
		b : "border-bottom-width"
	};
	El.paddings = {
		l : "padding-left",
		r : "padding-right",
		t : "padding-top",
		b : "padding-bottom"
	};
	El.margins = {
		l : "margin-left",
		r : "margin-right",
		t : "margin-top",
		b : "margin-bottom"
	};
	El.cache = {};
	var _1ab;
	El.get = function(el) {
		var ex, elm, id;
		if (!el) {
			return null;
		}
		if (typeof el == "string") {
			if (!(elm = document.getElementById(el))) {
				return null;
			}
			if (ex = El.cache[el]) {
				ex.dom = elm;
			} else {
				ex = El.cache[el] = new El(elm);
			}
			return ex;
		} else {
			if (el.tagName) {
				if (!(id = el.id)) {
					id = Ext.id(el);
				}
				if (ex = El.cache[id]) {
					ex.dom = el;
				} else {
					ex = El.cache[id] = new El(el);
				}
				return ex;
			} else {
				if (el instanceof El) {
					if (el != _1ab) {
						el.dom = document.getElementById(el.id) || el.dom;
						El.cache[el.id] = el;
					}
					return el;
				} else {
					if (el.isComposite) {
						return el;
					} else {
						if (el instanceof Array) {
							return El.select(el);
						} else {
							if (el == document) {
								if (!_1ab) {
									var f = function() {
									};
									f.prototype = El.prototype;
									_1ab = new f();
									_1ab.dom = document;
								}
								return _1ab;
							}
						}
					}
				}
			}
		}
		return null;
	};
	El.Flyweight = function(dom) {
		this.dom = dom;
	};
	El.Flyweight.prototype = El.prototype;
	El._flyweights = {};
	El.fly = function(el, _1b3) {
		_1b3 = _1b3 || "_global";
		el = Ext.getDom(el);
		if (!el) {
			return null;
		}
		if (!El._flyweights[_1b3]) {
			El._flyweights[_1b3] = new El.Flyweight();
		}
		El._flyweights[_1b3].dom = el;
		return El._flyweights[_1b3];
	};
	Ext.get = El.get;
	Ext.fly = El.fly;
	var _122 = Ext.isStrict ? {
		select : 1
	} : {
		input : 1,
		select : 1,
		textarea : 1
	};
	if (Ext.isIE || Ext.isGecko) {
		_122["button"] = 1;
	}
})();

Ext.enableFx = true;
Ext.Fx = {
	slideIn : function(_1, o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			_1 = _1 || "t";
			this.fixDisplay();
			var r = this.getFxRestore();
			var b = this.getBox();
			this.setSize(b);
			var _6 = this.fxWrap(r.pos, o, "hidden");
			var st = this.dom.style;
			st.visibility = "visible";
			st.position = "absolute";
			var _8 = function() {
				el.fxUnwrap(_6, r.pos, o);
				st.width = r.width;
				st.height = r.height;
				el.afterFx(o);
			};
			var a, pt = {
				to : [ b.x, b.y ]
			}, bw = {
				to : b.width
			}, bh = {
				to : b.height
			};
			switch (_1.toLowerCase()) {
			case "t":
				_6.setSize(b.width, 0);
				st.left = st.bottom = "0";
				a = {
					height : bh
				};
				break;
			case "l":
				_6.setSize(0, b.height);
				st.right = st.top = "0";
				a = {
					width : bw
				};
				break;
			case "r":
				_6.setSize(0, b.height);
				_6.setX(b.right);
				st.left = st.top = "0";
				a = {
					width : bw,
					points : pt
				};
				break;
			case "b":
				_6.setSize(b.width, 0);
				_6.setY(b.bottom);
				st.left = st.top = "0";
				a = {
					height : bh,
					points : pt
				};
				break;
			case "tl":
				_6.setSize(0, 0);
				st.right = st.bottom = "0";
				a = {
					width : bw,
					height : bh
				};
				break;
			case "bl":
				_6.setSize(0, 0);
				_6.setY(b.y + b.height);
				st.right = st.top = "0";
				a = {
					width : bw,
					height : bh,
					points : pt
				};
				break;
			case "br":
				_6.setSize(0, 0);
				_6.setXY( [ b.right, b.bottom ]);
				st.left = st.top = "0";
				a = {
					width : bw,
					height : bh,
					points : pt
				};
				break;
			case "tr":
				_6.setSize(0, 0);
				_6.setX(b.x + b.width);
				st.left = st.bottom = "0";
				a = {
					width : bw,
					height : bh,
					points : pt
				};
				break;
			}
			this.dom.style.visibility = "visible";
			_6.show();
			arguments.callee.anim = _6.fxanim(a, o, "motion", 0.5, "easeOut",
					_8);
		});
		return this;
	},
	slideOut : function(_d, o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			_d = _d || "t";
			var r = this.getFxRestore();
			var b = this.getBox();
			this.setSize(b);
			var _12 = this.fxWrap(r.pos, o, "visible");
			var st = this.dom.style;
			st.visibility = "visible";
			st.position = "absolute";
			_12.setSize(b);
			var _14 = function() {
				if (o.useDisplay) {
					el.setDisplayed(false);
				} else {
					el.hide();
				}
				el.fxUnwrap(_12, r.pos, o);
				st.width = r.width;
				st.height = r.height;
				el.afterFx(o);
			};
			var a, _16 = {
				to : 0
			};
			switch (_d.toLowerCase()) {
			case "t":
				st.left = st.bottom = "0";
				a = {
					height : _16
				};
				break;
			case "l":
				st.right = st.top = "0";
				a = {
					width : _16
				};
				break;
			case "r":
				st.left = st.top = "0";
				a = {
					width : _16,
					points : {
						to : [ b.right, b.y ]
					}
				};
				break;
			case "b":
				st.left = st.top = "0";
				a = {
					height : _16,
					points : {
						to : [ b.x, b.bottom ]
					}
				};
				break;
			case "tl":
				st.right = st.bottom = "0";
				a = {
					width : _16,
					height : _16
				};
				break;
			case "bl":
				st.right = st.top = "0";
				a = {
					width : _16,
					height : _16,
					points : {
						to : [ b.x, b.bottom ]
					}
				};
				break;
			case "br":
				st.left = st.top = "0";
				a = {
					width : _16,
					height : _16,
					points : {
						to : [ b.x + b.width, b.bottom ]
					}
				};
				break;
			case "tr":
				st.left = st.bottom = "0";
				a = {
					width : _16,
					height : _16,
					points : {
						to : [ b.right, b.y ]
					}
				};
				break;
			}
			arguments.callee.anim = _12.fxanim(a, o, "motion", 0.5, "easeOut",
					_14);
		});
		return this;
	},
	puff : function(o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			this.clearOpacity();
			this.show();
			var r = this.getFxRestore();
			var st = this.dom.style;
			var _1b = function() {
				if (o.useDisplay) {
					el.setDisplayed(false);
				} else {
					el.hide();
				}
				el.clearOpacity();
				el.setPositioning(r.pos);
				st.width = r.width;
				st.height = r.height;
				st.fontSize = "";
				el.afterFx(o);
			};
			var _1c = this.getWidth();
			var _1d = this.getHeight();
			arguments.callee.anim = this.fxanim( {
				width : {
					to : this.adjustWidth(_1c * 2)
				},
				height : {
					to : this.adjustHeight(_1d * 2)
				},
				points : {
					by : [ -(_1c * 0.5), -(_1d * 0.5) ]
				},
				opacity : {
					to : 0
				},
				fontSize : {
					to : 200,
					unit : "%"
				}
			}, o, "motion", 0.5, "easeOut", _1b);
		});
		return this;
	},
	switchOff : function(o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			this.clearOpacity();
			this.clip();
			var r = this.getFxRestore();
			var st = this.dom.style;
			var _22 = function() {
				if (o.useDisplay) {
					el.setDisplayed(false);
				} else {
					el.hide();
				}
				el.clearOpacity();
				el.setPositioning(r.pos);
				st.width = r.width;
				st.height = r.height;
				el.afterFx(o);
			};
			this.fxanim( {
				opacity : {
					to : 0.3
				}
			}, null, null, 0.1, null, function() {
				this.clearOpacity();
				(function() {
					this.fxanim( {
						height : {
							to : 1
						},
						points : {
							by : [ 0, this.getHeight() * 0.5 ]
						}
					}, o, "motion", 0.3, "easeIn", _22);
				}).defer(100, this);
			});
		});
		return this;
	},
	highlight : function(_23, o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			_23 = _23 || "ffff9c";
			attr = o.attr || "backgroundColor";
			this.clearOpacity();
			this.show();
			var _26 = this.getColor(attr);
			var _27 = this.dom.style[attr];
			endColor = (o.endColor || _26) || "ffffff";
			var _28 = function() {
				el.dom.style[attr] = _27;
				el.afterFx(o);
			};
			var a = {};
			a[attr] = {
				from : _23,
				to : endColor
			};
			arguments.callee.anim = this
					.fxanim(a, o, "color", 1, "easeIn", _28);
		});
		return this;
	},
	frame : function(_2a, _2b, o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			_2a = _2a || "#C3DAF9";
			if (_2a.length == 6) {
				_2a = "#" + _2a;
			}
			_2b = _2b || 1;
			duration = o.duration || 1;
			this.show();
			var b = this.getBox();
			var _2f = function() {
				var _30 = this.createProxy( {
					tag : "div",
					style : {
						visbility : "hidden",
						position : "absolute",
						"z-index" : "35000",
						border : "0px solid " + _2a
					}
				});
				var _31 = Ext.isBorderBox ? 2 : 1;
				_30.animate( {
					top : {
						from : b.y,
						to : b.y - 20
					},
					left : {
						from : b.x,
						to : b.x - 20
					},
					borderWidth : {
						from : 0,
						to : 10
					},
					opacity : {
						from : 1,
						to : 0
					},
					height : {
						from : b.height,
						to : (b.height + (20 * _31))
					},
					width : {
						from : b.width,
						to : (b.width + (20 * _31))
					}
				}, duration, function() {
					_30.remove();
				});
				if (--_2b > 0) {
					_2f.defer((duration / 2) * 1000, this);
				} else {
					el.afterFx(o);
				}
			};
			_2f.call(this);
		});
		return this;
	},
	pause : function(_32) {
		var el = this.getFxEl();
		var o = {};
		el.queueFx(o, function() {
			setTimeout(function() {
				el.afterFx(o);
			}, _32 * 1000);
		});
		return this;
	},
	fadeIn : function(o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			this.setOpacity(0);
			this.fixDisplay();
			this.dom.style.visibility = "visible";
			var to = o.endOpacity || 1;
			arguments.callee.anim = this.fxanim( {
				opacity : {
					to : to
				}
			}, o, null, 0.5, "easeOut", function() {
				if (to == 1) {
					this.clearOpacity();
				}
				el.afterFx(o);
			});
		});
		return this;
	},
	fadeOut : function(o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			arguments.callee.anim = this.fxanim( {
				opacity : {
					to : o.endOpacity || 0
				}
			}, o, null, 0.5, "easeOut",
					function() {
						if (this.visibilityMode == Ext.Element.DISPLAY
								|| o.useDisplay) {
							this.dom.style.display = "none";
						} else {
							this.dom.style.visibility = "hidden";
						}
						this.clearOpacity();
						el.afterFx(o);
					});
		});
		return this;
	},
	scale : function(w, h, o) {
		this.shift(Ext.apply( {}, o, {
			width : w,
			height : h
		}));
		return this;
	},
	shift : function(o) {
		var el = this.getFxEl();
		o = o || {};
		el
				.queueFx(
						o,
						function() {
							var a = {}, w = o.width, h = o.height, x = o.x, y = o.y, op = o.opacity;
							if (w !== undefined) {
								a.width = {
									to : this.adjustWidth(w)
								};
							}
							if (h !== undefined) {
								a.height = {
									to : this.adjustHeight(h)
								};
							}
							if (x !== undefined || y !== undefined) {
								a.points = {
									to : [ x !== undefined ? x : this.getX(),
											y !== undefined ? y : this.getY() ]
								};
							}
							if (op !== undefined) {
								a.opacity = {
									to : op
								};
							}
							if (o.xy !== undefined) {
								a.points = {
									to : o.xy
								};
							}
							arguments.callee.anim = this.fxanim(a, o, "motion",
									0.35, "easeOut", function() {
										el.afterFx(o);
									});
						});
		return this;
	},
	ghost : function(_45, o) {
		var el = this.getFxEl();
		o = o || {};
		el.queueFx(o, function() {
			_45 = _45 || "b";
			var r = this.getFxRestore();
			var w = this.getWidth(), h = this.getHeight();
			var st = this.dom.style;
			var _4c = function() {
				if (o.useDisplay) {
					el.setDisplayed(false);
				} else {
					el.hide();
				}
				el.clearOpacity();
				el.setPositioning(r.pos);
				st.width = r.width;
				st.height = r.height;
				el.afterFx(o);
			};
			var a = {
				opacity : {
					to : 0
				},
				points : {}
			}, pt = a.points;
			switch (_45.toLowerCase()) {
			case "t":
				pt.by = [ 0, -h ];
				break;
			case "l":
				pt.by = [ -w, 0 ];
				break;
			case "r":
				pt.by = [ w, 0 ];
				break;
			case "b":
				pt.by = [ 0, h ];
				break;
			case "tl":
				pt.by = [ -w, -h ];
				break;
			case "bl":
				pt.by = [ -w, h ];
				break;
			case "br":
				pt.by = [ w, h ];
				break;
			case "tr":
				pt.by = [ w, -h ];
				break;
			}
			arguments.callee.anim = this.fxanim(a, o, "motion", 0.5, "easeOut",
					_4c);
		});
		return this;
	},
	syncFx : function() {
		this.fxDefaults = Ext.apply(this.fxDefaults || {}, {
			block : false,
			concurrent : true,
			stopFx : false
		});
		return this;
	},
	sequenceFx : function() {
		this.fxDefaults = Ext.apply(this.fxDefaults || {}, {
			block : false,
			concurrent : false,
			stopFx : false
		});
		return this;
	},
	nextFx : function() {
		var ef = this.fxQueue[0];
		if (ef) {
			ef.call(this);
		}
	},
	hasActiveFx : function() {
		return this.fxQueue && this.fxQueue[0];
	},
	stopFx : function() {
		if (this.hasActiveFx()) {
			var cur = this.fxQueue[0];
			if (cur && cur.anim && cur.anim.isAnimated()) {
				this.fxQueue = [ cur ];
				cur.anim.stop(true);
			}
		}
		return this;
	},
	beforeFx : function(o) {
		if (this.hasActiveFx() && !o.concurrent) {
			if (o.stopFx) {
				this.stopFx();
				return true;
			}
			return false;
		}
		return true;
	},
	hasFxBlock : function() {
		var q = this.fxQueue;
		return q && q[0] && q[0].block;
	},
	queueFx : function(o, fn) {
		if (!this.fxQueue) {
			this.fxQueue = [];
		}
		if (!this.hasFxBlock()) {
			Ext.applyIf(o, this.fxDefaults);
			if (!o.concurrent) {
				var run = this.beforeFx(o);
				fn.block = o.block;
				this.fxQueue.push(fn);
				if (run) {
					this.nextFx();
				}
			} else {
				fn.call(this);
			}
		}
		return this;
	},
	fxWrap : function(pos, o, vis) {
		var _59;
		if (!o.wrap || !(_59 = Ext.get(o.wrap))) {
			var _5a;
			if (o.fixPosition) {
				_5a = this.getXY();
			}
			var div = document.createElement("div");
			div.style.visibility = vis;
			_59 = Ext.get(this.dom.parentNode.insertBefore(div, this.dom));
			_59.setPositioning(pos);
			if (_59.getStyle("position") == "static") {
				_59.position("relative");
			}
			this.clearPositioning("auto");
			_59.clip();
			_59.dom.appendChild(this.dom);
			if (_5a) {
				_59.setXY(_5a);
			}
		}
		return _59;
	},
	fxUnwrap : function(_5c, pos, o) {
		this.clearPositioning();
		this.setPositioning(pos);
		if (!o.wrap) {
			_5c.dom.parentNode.insertBefore(this.dom, _5c.dom);
			_5c.remove();
		}
	},
	getFxRestore : function() {
		var st = this.dom.style;
		return {
			pos : this.getPositioning(),
			width : st.width,
			height : st.height
		};
	},
	afterFx : function(o) {
		if (o.afterStyle) {
			this.applyStyles(o.afterStyle);
		}
		if (o.remove === true) {
			this.remove();
		}
		Ext.callback(o.callback, o.scope, [ this ]);
		if (!o.concurrent) {
			this.fxQueue.shift();
			this.nextFx();
		}
	},
	getFxEl : function() {
		return Ext.get(this.dom);
	},
	fxanim : function(_61, opt, _63, _64, _65, cb) {
		_63 = _63 || "run";
		opt = opt || {};
		var _67 = Ext.lib.Anim[_63](this.dom, _61,
				(opt.duration || _64) || 0.35,
				(opt.easing || _65) || "easeOut", function() {
					Ext.callback(cb, this);
				}, this);
		opt.anim = _67;
		return _67;
	}
};
Ext.Fx.resize = Ext.Fx.scale;
Ext.apply(Ext.Element.prototype, Ext.Fx);

Ext.CompositeElement = function(_1) {
	this.elements = [];
	this.addElements(_1);
};
Ext.CompositeElement.prototype = {
	isComposite : true,
	addElements : function(_2) {
		if (!_2) {
			return this;
		}
		if (typeof _2 == "string") {
			_2 = Ext.Element.selectorFunction(_2);
		}
		var _3 = this.elements;
		var _4 = _3.length - 1;
		for ( var i = 0, _6 = _2.length; i < _6; i++) {
			_3[++_4] = Ext.get(_2[i], true);
		}
		return this;
	},
	invoke : function(fn, _8) {
		var _9 = this.elements;
		for ( var i = 0, _b = _9.length; i < _b; i++) {
			Ext.Element.prototype[fn].apply(_9[i], _8);
		}
		return this;
	},
	add : function(_c) {
		if (typeof _c == "string") {
			this.addElements(Ext.Element.selectorFunction(_c));
		} else {
			if (_c.length !== undefined) {
				this.addElements(_c);
			} else {
				this.addElements( [ _c ]);
			}
		}
		return this;
	},
	each : function(fn, _e) {
		var _f = this.elements;
		for ( var i = 0, len = _f.length; i < len; i++) {
			if (fn.call(_e || _f[i], _f[i], this, i) === false) {
				break;
			}
		}
		return this;
	},
	item : function(_12) {
		return this.elements[_12];
	}
};
(function() {
	Ext.CompositeElement.createCall = function(_13, _14) {
		if (!_13[_14]) {
			_13[_14] = function() {
				return this.invoke(_14, arguments);
			};
		}
	};
	for ( var _15 in Ext.Element.prototype) {
		if (typeof Ext.Element.prototype[_15] == "function") {
			Ext.CompositeElement
					.createCall(Ext.CompositeElement.prototype, _15);
		}
	}
})();
Ext.CompositeElementLite = function(els) {
	Ext.CompositeElementLite.superclass.constructor.call(this, els);
	var _17 = function() {
	};
	_17.prototype = Ext.Element.prototype;
	this.el = new Ext.Element.Flyweight();
};
Ext.extend(Ext.CompositeElementLite, Ext.CompositeElement, {
	addElements : function(els) {
		if (els) {
			if (els instanceof Array) {
				this.elements = this.elements.concat(els);
			} else {
				var _19 = this.elements;
				var _1a = _19.length - 1;
				for ( var i = 0, len = els.length; i < len; i++) {
					_19[++_1a] = els[i];
				}
			}
		}
		return this;
	},
	invoke : function(fn, _1e) {
		var els = this.elements;
		var el = this.el;
		for ( var i = 0, len = els.length; i < len; i++) {
			el.dom = els[i];
			Ext.Element.prototype[fn].apply(el, _1e);
		}
		return this;
	},
	item : function(_23) {
		this.el.dom = this.elements[_23];
		return this.el;
	},
	addListener : function(_24, _25, _26, opt) {
		var els = this.elements;
		for ( var i = 0, len = els.length; i < len; i++) {
			Ext.EventManager.on(els[i], _24, _25, _26 || els[i], opt);
		}
		return this;
	},
	each : function(fn, _2c) {
		var els = this.elements;
		var el = this.el;
		for ( var i = 0, len = els.length; i < len; i++) {
			el.dom = els[i];
			if (fn.call(_2c || el, el, this, i) === false) {
				break;
			}
		}
		return this;
	}
});
Ext.CompositeElementLite.prototype.on = Ext.CompositeElementLite.prototype.addListener;
if (Ext.DomQuery) {
	Ext.Element.selectorFunction = Ext.DomQuery.select;
}
Ext.Element.select = function(_31, _32) {
	var els;
	if (typeof _31 == "string") {
		els = Ext.Element.selectorFunction(_31);
	} else {
		if (_31.length !== undefined) {
			els = _31;
		} else {
			throw "Invalid selector";
		}
	}
	if (_32 === true) {
		return new Ext.CompositeElement(els);
	} else {
		return new Ext.CompositeElementLite(els);
	}
};
Ext.select = Ext.Element.select;

Ext.UpdateManager = function(el, _2) {
	el = Ext.get(el);
	if (!_2 && el.updateManager) {
		return el.updateManager;
	}
	this.el = el;
	this.defaultUrl = null;
	this.events = {
		"beforeupdate" : true,
		"update" : true,
		"failure" : true
	};
	var d = Ext.UpdateManager.defaults;
	this.sslBlankUrl = d.sslBlankUrl;
	this.disableCaching = d.disableCaching;
	this.indicatorText = d.indicatorText;
	this.showLoadIndicator = d.showLoadIndicator;
	this.timeout = d.timeout;
	this.loadScripts = d.loadScripts;
	this.transaction = null;
	this.autoRefreshProcId = null;
	this.refreshDelegate = this.refresh.createDelegate(this);
	this.updateDelegate = this.update.createDelegate(this);
	this.formUpdateDelegate = this.formUpdate.createDelegate(this);
	this.successDelegate = this.processSuccess.createDelegate(this);
	this.failureDelegate = this.processFailure.createDelegate(this);
	this.renderer = new Ext.UpdateManager.BasicRenderer();
	Ext.UpdateManager.superclass.constructor.call(this);
};
Ext.extend(Ext.UpdateManager, Ext.util.Observable, {
	getEl : function() {
		return this.el;
	},
	update : function(_4, _5, _6, _7) {
		if (this.fireEvent("beforeupdate", this.el, _4, _5) !== false) {
			var _8 = this.method;
			if (typeof _4 == "object") {
				var _9 = _4;
				_4 = _9.url;
				_5 = _5 || _9.params;
				_6 = _6 || _9.callback;
				_7 = _7 || _9.discardUrl;
				if (_6 && _9.scope) {
					_6 = _6.createDelegate(_9.scope);
				}
				if (typeof _9.method != "undefined") {
					_8 = _9.method;
				}
				if (typeof _9.nocache != "undefined") {
					this.disableCaching = _9.nocache;
				}
				if (typeof _9.text != "undefined") {
					this.indicatorText = "<div class=\"loading-indicator\">"
							+ _9.text + "</div>";
				}
				if (typeof _9.scripts != "undefined") {
					this.loadScripts = _9.scripts;
				}
				if (typeof _9.timeout != "undefined") {
					this.timeout = _9.timeout;
				}
			}
			this.showLoading();
			if (!_7) {
				this.defaultUrl = _4;
			}
			if (typeof _4 == "function") {
				_4 = _4.call(this);
			}
			if (typeof _5 == "function") {
				_5 = _5();
			}
			if (_5 && typeof _5 != "string") {
				var _a = [];
				for ( var _b in _5) {
					if (typeof _5[_b] != "function") {
						_a.push(encodeURIComponent(_b), "=",
								encodeURIComponent(_5[_b]), "&");
					}
				}
				delete _a[_a.length - 1];
				_5 = _a.join("");
			}
			var cb = {
				success : this.successDelegate,
				failure : this.failureDelegate,
				timeout : (this.timeout * 1000),
				argument : {
					"url" : _4,
					"form" : null,
					"callback" : _6,
					"params" : _5
				}
			};
			_8 = _8 || (_5 ? "POST" : "GET");
			if (_8 == "GET") {
				_4 = this.prepareUrl(_4);
			}
			this.transaction = Ext.lib.Ajax.request(_8, _4, cb, _5);
		}
	},
	formUpdate : function(_d, _e, _f, _10) {
		if (this.fireEvent("beforeupdate", this.el, _d, _e) !== false) {
			formEl = Ext.getDom(_d);
			if (typeof _e == "function") {
				_e = _e.call(this);
			}
			if (typeof params == "function") {
				params = params();
			}
			_e = _e || formEl.action;
			var cb = {
				success : this.successDelegate,
				failure : this.failureDelegate,
				timeout : (this.timeout * 1000),
				argument : {
					"url" : _e,
					"form" : formEl,
					"callback" : _10,
					"reset" : _f
				}
			};
			var _12 = false;
			var _13 = formEl.getAttribute("enctype");
			if (_13 && _13.toLowerCase() == "multipart/form-data") {
				_12 = true;
				cb.upload = this.successDelegate;
			}
			this.transaction = Ext.lib.Ajax.formRequest(formEl, _e, cb, null,
					_12, this.sslBlankUrl);
			this.showLoading.defer(1, this);
		}
	},
	refresh : function(_14) {
		if (this.defaultUrl == null) {
			return;
		}
		this.update(this.defaultUrl, null, _14, true);
	},
	startAutoRefresh : function(_15, url, _17, _18, _19) {
		if (_19) {
			this.update(url || this.defaultUrl, _17, _18, true);
		}
		if (this.autoRefreshProcId) {
			clearInterval(this.autoRefreshProcId);
		}
		this.autoRefreshProcId = setInterval(this.update.createDelegate(this, [
				url || this.defaultUrl, _17, _18, true ]), _15 * 1000);
	},
	stopAutoRefresh : function() {
		if (this.autoRefreshProcId) {
			clearInterval(this.autoRefreshProcId);
			delete this.autoRefreshProcId;
		}
	},
	isAutoRefreshing : function() {
		return this.autoRefreshProcId ? true : false;
	},
	showLoading : function() {
		if (this.showLoadIndicator) {
			this.el.update(this.indicatorText);
		}
	},
	prepareUrl : function(url) {
		if (this.disableCaching) {
			var _1b = "_dc=" + (new Date().getTime());
			if (url.indexOf("?") !== -1) {
				url += "&" + _1b;
			} else {
				url += "?" + _1b;
			}
		}
		return url;
	},
	processSuccess : function(_1c) {
		this.transaction = null;
		if (_1c.argument.form && _1c.argument.reset) {
			try {
				_1c.argument.form.reset();
			} catch (e) {
			}
		}
		if (this.loadScripts) {
			this.renderer.render(this.el, _1c, this, this.updateComplete
					.createDelegate(this, [ _1c ]));
		} else {
			this.renderer.render(this.el, _1c, this);
			this.updateComplete(_1c);
		}
	},
	updateComplete : function(_1d) {
		this.fireEvent("update", this.el, _1d);
		if (typeof _1d.argument.callback == "function") {
			_1d.argument.callback(this.el, true, _1d);
		}
	},
	processFailure : function(_1e) {
		this.transaction = null;
		this.fireEvent("failure", this.el, _1e);
		if (typeof _1e.argument.callback == "function") {
			_1e.argument.callback(this.el, false, _1e);
		}
	},
	setRenderer : function(_1f) {
		this.renderer = _1f;
	},
	getRenderer : function() {
		return this.renderer;
	},
	setDefaultUrl : function(_20) {
		this.defaultUrl = _20;
	},
	abort : function() {
		if (this.transaction) {
			Ext.lib.Ajax.abort(this.transaction);
		}
	},
	isUpdating : function() {
		if (this.transaction) {
			return Ext.lib.Ajax.isCallInProgress(this.transaction);
		}
		return false;
	}
});
Ext.UpdateManager.defaults = {
	timeout : 30,
	loadScripts : false,
	sslBlankUrl : (Ext.SSL_SECURE_URL || "javascript:false"),
	disableCaching : false,
	showLoadIndicator : true,
	indicatorText : "<div class=\"loading-indicator\">Loading...</div>"
};
Ext.UpdateManager.updateElement = function(el, url, _23, _24) {
	var um = Ext.get(el, true).getUpdateManager();
	Ext.apply(um, _24);
	um.update(url, _23, _24 ? _24.callback : null);
};
Ext.UpdateManager.update = Ext.UpdateManager.updateElement;
Ext.UpdateManager.BasicRenderer = function() {
};
Ext.UpdateManager.BasicRenderer.prototype = {
	render : function(el, _27, _28, _29) {
		el.update(_27.responseText, _28.loadScripts, _29);
	}
};

Date.parseFunctions = {
	count : 0
};
Date.parseRegexes = [];
Date.formatFunctions = {
	count : 0
};
Date.prototype.dateFormat = function(_1) {
	if (Date.formatFunctions[_1] == null) {
		Date.createNewFormat(_1);
	}
	var _2 = Date.formatFunctions[_1];
	return this[_2]();
};
Date.prototype.format = Date.prototype.dateFormat;
Date.createNewFormat = function(_3) {
	var _4 = "format" + Date.formatFunctions.count++;
	Date.formatFunctions[_3] = _4;
	var _5 = "Date.prototype." + _4 + " = function(){return ";
	var _6 = false;
	var ch = "";
	for ( var i = 0; i < _3.length; ++i) {
		ch = _3.charAt(i);
		if (!_6 && ch == "\\") {
			_6 = true;
		} else {
			if (_6) {
				_6 = false;
				_5 += "'" + String.escape(ch) + "' + ";
			} else {
				_5 += Date.getFormatCode(ch);
			}
		}
	}
	eval(_5.substring(0, _5.length - 3) + ";}");
};
Date.getFormatCode = function(_9) {
	switch (_9) {
	case "d":
		return "String.leftPad(this.getDate(), 2, '0') + ";
	case "D":
		return "Date.dayNames[this.getDay()].substring(0, 3) + ";
	case "j":
		return "this.getDate() + ";
	case "l":
		return "Date.dayNames[this.getDay()] + ";
	case "S":
		return "this.getSuffix() + ";
	case "w":
		return "this.getDay() + ";
	case "z":
		return "this.getDayOfYear() + ";
	case "W":
		return "this.getWeekOfYear() + ";
	case "F":
		return "Date.monthNames[this.getMonth()] + ";
	case "m":
		return "String.leftPad(this.getMonth() + 1, 2, '0') + ";
	case "M":
		return "Date.monthNames[this.getMonth()].substring(0, 3) + ";
	case "n":
		return "(this.getMonth() + 1) + ";
	case "t":
		return "this.getDaysInMonth() + ";
	case "L":
		return "(this.isLeapYear() ? 1 : 0) + ";
	case "Y":
		return "this.getFullYear() + ";
	case "y":
		return "('' + this.getFullYear()).substring(2, 4) + ";
	case "a":
		return "(this.getHours() < 12 ? 'am' : 'pm') + ";
	case "A":
		return "(this.getHours() < 12 ? 'AM' : 'PM') + ";
	case "g":
		return "((this.getHours() %12) ? this.getHours() % 12 : 12) + ";
	case "G":
		return "this.getHours() + ";
	case "h":
		return "String.leftPad((this.getHours() %12) ? this.getHours() % 12 : 12, 2, '0') + ";
	case "H":
		return "String.leftPad(this.getHours(), 2, '0') + ";
	case "i":
		return "String.leftPad(this.getMinutes(), 2, '0') + ";
	case "s":
		return "String.leftPad(this.getSeconds(), 2, '0') + ";
	case "O":
		return "this.getGMTOffset() + ";
	case "T":
		return "this.getTimezone() + ";
	case "Z":
		return "(this.getTimezoneOffset() * -60) + ";
	default:
		return "'" + String.escape(_9) + "' + ";
	}
};
Date.parseDate = function(_a, _b) {
	if (Date.parseFunctions[_b] == null) {
		Date.createParser(_b);
	}
	var _c = Date.parseFunctions[_b];
	return Date[_c](_a);
};
Date.createParser = function(_d) {
	var _e = "parse" + Date.parseFunctions.count++;
	var _f = Date.parseRegexes.length;
	var _10 = 1;
	Date.parseFunctions[_d] = _e;
	var _11 = "Date." + _e + " = function(input){\n"
			+ "var y = -1, m = -1, d = -1, h = -1, i = -1, s = -1;\n"
			+ "var d = new Date();\n" + "y = d.getFullYear();\n"
			+ "m = d.getMonth();\n" + "d = d.getDate();\n"
			+ "var results = input.match(Date.parseRegexes[" + _f + "]);\n"
			+ "if (results && results.length > 0) {";
	var _12 = "";
	var _13 = false;
	var ch = "";
	for ( var i = 0; i < _d.length; ++i) {
		ch = _d.charAt(i);
		if (!_13 && ch == "\\") {
			_13 = true;
		} else {
			if (_13) {
				_13 = false;
				_12 += String.escape(ch);
			} else {
				var obj = Date.formatCodeToRegex(ch, _10);
				_10 += obj.g;
				_12 += obj.s;
				if (obj.g && obj.c) {
					_11 += obj.c;
				}
			}
		}
	}
	_11 += "if (y > 0 && m >= 0 && d > 0 && h >= 0 && i >= 0 && s >= 0)\n"
			+ "{return new Date(y, m, d, h, i, s);}\n"
			+ "else if (y > 0 && m >= 0 && d > 0 && h >= 0 && i >= 0)\n"
			+ "{return new Date(y, m, d, h, i);}\n"
			+ "else if (y > 0 && m >= 0 && d > 0 && h >= 0)\n"
			+ "{return new Date(y, m, d, h);}\n"
			+ "else if (y > 0 && m >= 0 && d > 0)\n"
			+ "{return new Date(y, m, d);}\n" + "else if (y > 0 && m >= 0)\n"
			+ "{return new Date(y, m);}\n" + "else if (y > 0)\n"
			+ "{return new Date(y);}\n" + "}return null;}";
	Date.parseRegexes[_f] = new RegExp("^" + _12 + "$");
	eval(_11);
};
Date.formatCodeToRegex = function(_17, _18) {
	switch (_17) {
	case "D":
		return {
			g : 0,
			c : null,
			s : "(?:Sun|Mon|Tue|Wed|Thu|Fri|Sat)"
		};
	case "j":
	case "d":
		return {
			g : 1,
			c : "d = parseInt(results[" + _18 + "], 10);\n",
			s : "(\\d{1,2})"
		};
	case "l":
		return {
			g : 0,
			c : null,
			s : "(?:" + Date.dayNames.join("|") + ")"
		};
	case "S":
		return {
			g : 0,
			c : null,
			s : "(?:st|nd|rd|th)"
		};
	case "w":
		return {
			g : 0,
			c : null,
			s : "\\d"
		};
	case "z":
		return {
			g : 0,
			c : null,
			s : "(?:\\d{1,3})"
		};
	case "W":
		return {
			g : 0,
			c : null,
			s : "(?:\\d{2})"
		};
	case "F":
		return {
			g : 1,
			c : "m = parseInt(Date.monthNumbers[results[" + _18
					+ "].substring(0, 3)], 10);\n",
			s : "(" + Date.monthNames.join("|") + ")"
		};
	case "M":
		return {
			g : 1,
			c : "m = parseInt(Date.monthNumbers[results[" + _18 + "]], 10);\n",
			s : "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)"
		};
	case "n":
	case "m":
		return {
			g : 1,
			c : "m = parseInt(results[" + _18 + "], 10) - 1;\n",
			s : "(\\d{1,2})"
		};
	case "t":
		return {
			g : 0,
			c : null,
			s : "\\d{1,2}"
		};
	case "L":
		return {
			g : 0,
			c : null,
			s : "(?:1|0)"
		};
	case "Y":
		return {
			g : 1,
			c : "y = parseInt(results[" + _18 + "], 10);\n",
			s : "(\\d{4})"
		};
	case "y":
		return {
			g : 1,
			c : "var ty = parseInt(results[" + _18 + "], 10);\n"
					+ "y = ty > Date.y2kYear ? 1900 + ty : 2000 + ty;\n",
			s : "(\\d{1,2})"
		};
	case "a":
		return {
			g : 1,
			c : "if (results[" + _18 + "] == 'am') {\n"
					+ "if (h == 12) { h = 0; }\n"
					+ "} else { if (h < 12) { h += 12; }}",
			s : "(am|pm)"
		};
	case "A":
		return {
			g : 1,
			c : "if (results[" + _18 + "] == 'AM') {\n"
					+ "if (h == 12) { h = 0; }\n"
					+ "} else { if (h < 12) { h += 12; }}",
			s : "(AM|PM)"
		};
	case "g":
	case "G":
	case "h":
	case "H":
		return {
			g : 1,
			c : "h = parseInt(results[" + _18 + "], 10);\n",
			s : "(\\d{1,2})"
		};
	case "i":
		return {
			g : 1,
			c : "i = parseInt(results[" + _18 + "], 10);\n",
			s : "(\\d{2})"
		};
	case "s":
		return {
			g : 1,
			c : "s = parseInt(results[" + _18 + "], 10);\n",
			s : "(\\d{2})"
		};
	case "O":
		return {
			g : 0,
			c : null,
			s : "[+-]\\d{4}"
		};
	case "T":
		return {
			g : 0,
			c : null,
			s : "[A-Z]{3}"
		};
	case "Z":
		return {
			g : 0,
			c : null,
			s : "[+-]\\d{1,5}"
		};
	default:
		return {
			g : 0,
			c : null,
			s : String.escape(_17)
		};
	}
};
Date.prototype.getTimezone = function() {
	return this.toString().replace(/^.*? ([A-Z]{3}) [0-9]{4}.*$/, "$1")
			.replace(/^.*?\(([A-Z])[a-z]+ ([A-Z])[a-z]+ ([A-Z])[a-z]+\)$/,
					"$1$2$3");
};
Date.prototype.getGMTOffset = function() {
	return (this.getTimezoneOffset() > 0 ? "-" : "+")
			+ String.leftPad(Math.floor(this.getTimezoneOffset() / 60), 2, "0")
			+ String.leftPad(this.getTimezoneOffset() % 60, 2, "0");
};
Date.prototype.getDayOfYear = function() {
	var num = 0;
	Date.daysInMonth[1] = this.isLeapYear() ? 29 : 28;
	for ( var i = 0; i < this.getMonth(); ++i) {
		num += Date.daysInMonth[i];
	}
	return num + this.getDate() - 1;
};
Date.prototype.getWeekOfYear = function() {
	var now = this.getDayOfYear() + (4 - this.getDay());
	var _1c = new Date(this.getFullYear(), 0, 1);
	var _1d = (7 - _1c.getDay() + 4);
	return String.leftPad(((now - _1d) / 7) + 1, 2, "0");
};
Date.prototype.isLeapYear = function() {
	var _1e = this.getFullYear();
	return ((_1e & 3) == 0 && (_1e % 100 || (_1e % 400 == 0 && _1e)));
};
Date.prototype.getFirstDayOfMonth = function() {
	var day = (this.getDay() - (this.getDate() - 1)) % 7;
	return (day < 0) ? (day + 7) : day;
};
Date.prototype.getLastDayOfMonth = function() {
	var day = (this.getDay() + (Date.daysInMonth[this.getMonth()] - this
			.getDate())) % 7;
	return (day < 0) ? (day + 7) : day;
};
Date.prototype.getFirstDateOfMonth = function() {
	return new Date(this.getFullYear(), this.getMonth(), 1);
};
Date.prototype.getLastDateOfMonth = function() {
	return new Date(this.getFullYear(), this.getMonth(), this.getDaysInMonth());
};
Date.prototype.getDaysInMonth = function() {
	Date.daysInMonth[1] = this.isLeapYear() ? 29 : 28;
	return Date.daysInMonth[this.getMonth()];
};
Date.prototype.getSuffix = function() {
	switch (this.getDate()) {
	case 1:
	case 21:
	case 31:
		return "st";
	case 2:
	case 22:
		return "nd";
	case 3:
	case 23:
		return "rd";
	default:
		return "th";
	}
};
Date.daysInMonth = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
Date.monthNames = [ "January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December" ];
Date.dayNames = [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
		"Friday", "Saturday" ];
Date.y2kYear = 50;
Date.monthNumbers = {
	Jan : 0,
	Feb : 1,
	Mar : 2,
	Apr : 3,
	May : 4,
	Jun : 5,
	Jul : 6,
	Aug : 7,
	Sep : 8,
	Oct : 9,
	Nov : 10,
	Dec : 11
};
Date.prototype.clone = function() {
	return new Date(this.getTime());
};
Date.prototype.clearTime = function(_21) {
	if (_21) {
		return this.clone().clearTime();
	}
	this.setHours(0);
	this.setMinutes(0);
	this.setSeconds(0);
	this.setMilliseconds(0);
	return this;
};
if (Ext.isSafari) {
	Date.brokenSetMonth = Date.prototype.setMonth;
	Date.prototype.setMonth = function(num) {
		if (num <= -1) {
			var n = Math.ceil(-num);
			var _24 = Math.ceil(n / 12);
			var _25 = (n % 12) ? 12 - n % 12 : 0;
			this.setFullYear(this.getFullYear() - _24);
			return Date.brokenSetMonth.call(this, _25);
		} else {
			return Date.brokenSetMonth.apply(this, arguments);
		}
	};
}
Date.MILLI = "ms";
Date.SECOND = "s";
Date.MINUTE = "mi";
Date.HOUR = "h";
Date.DAY = "d";
Date.MONTH = "mo";
Date.YEAR = "y";
Date.prototype.add = function(_26, _27) {
	var d = this.clone();
	if (!_26 || _27 === 0) {
		return d;
	}
	switch (_26.toLowerCase()) {
	case Date.MILLI:
		d.setMilliseconds(this.getMilliseconds() + _27);
		break;
	case Date.SECOND:
		d.setSeconds(this.getSeconds() + _27);
		break;
	case Date.MINUTE:
		d.setMinutes(this.getMinutes() + _27);
		break;
	case Date.HOUR:
		d.setHours(this.getHours() + _27);
		break;
	case Date.DAY:
		d.setDate(this.getDate() + _27);
		break;
	case Date.MONTH:
		var day = this.getDate();
		if (day > 28) {
			day = Math.min(day, this.getFirstDateOfMonth().add("mo", _27)
					.getLastDateOfMonth().getDate());
		}
		d.setDate(day);
		d.setMonth(this.getMonth() + _27);
		break;
	case Date.YEAR:
		d.setFullYear(this.getFullYear() + _27);
		break;
	}
	return d;
};

Ext.util.DelayedTask = function(fn, _2, _3) {
	var id = null, d, t;
	var _7 = function() {
		var _8 = new Date().getTime();
		if (_8 - t >= d) {
			clearInterval(id);
			id = null;
			fn.apply(_2, _3 || []);
		}
	};
	this.delay = function(_9, _a, _b, _c) {
		if (id && _9 != d) {
			this.cancel();
		}
		d = _9;
		t = new Date().getTime();
		fn = _a || fn;
		_2 = _b || _2;
		_3 = _c || _3;
		if (!id) {
			id = setInterval(_7, d);
		}
	};
	this.cancel = function() {
		if (id) {
			clearInterval(id);
			id = null;
		}
	};
};

Ext.util.TaskRunner = function(_1) {
	_1 = _1 || 10;
	var _2 = [], _3 = [];
	var id = 0;
	var _5 = false;
	var _6 = function() {
		_5 = false;
		clearInterval(id);
		id = 0;
	};
	var _7 = function() {
		if (!_5) {
			_5 = true;
			id = setInterval(_8, _1);
		}
	};
	var _9 = function(_a) {
		_3.push(_a);
		if (_a.onStop) {
			_a.onStop();
		}
	};
	var _8 = function() {
		if (_3.length > 0) {
			for ( var i = 0, _c = _3.length; i < _c; i++) {
				_2.remove(_3[i]);
			}
			_3 = [];
			if (_2.length < 1) {
				_6();
				return;
			}
		}
		var _d = new Date().getTime();
		for ( var i = 0, _c = _2.length; i < _c; ++i) {
			var t = _2[i];
			var _f = _d - t.taskRunTime;
			if (t.interval <= _f) {
				var rt = t.run.apply(t.scope || t, t.args
						|| [ ++t.taskRunCount ]);
				t.taskRunTime = _d;
				if (rt === false || t.taskRunCount === t.repeat) {
					_9(t);
					return;
				}
			}
			if (t.duration && t.duration <= (_d - t.taskStartTime)) {
				_9(t);
			}
		}
	};
	this.start = function(_11) {
		_2.push(_11);
		_11.taskStartTime = new Date().getTime();
		_11.taskRunTime = 0;
		_11.taskRunCount = 0;
		_7();
		return _11;
	};
	this.stop = function(_12) {
		_9(_12);
		return _12;
	};
	this.stopAll = function() {
		_6();
		for ( var i = 0, len = _2.length; i < len; i++) {
			if (_2[i].onStop) {
				_2[i].onStop();
			}
		}
		_2 = [];
		_3 = [];
	};
};
Ext.TaskMgr = new Ext.util.TaskRunner();

Ext.util.MixedCollection = function(_1, _2) {
	this.items = [];
	this.map = {};
	this.keys = [];
	this.length = 0;
	this.events = {
		"clear" : true,
		"add" : true,
		"replace" : true,
		"remove" : true,
		"sort" : true
	};
	this.allowFunctions = _1 === true;
	if (_2) {
		this.getKey = _2;
	}
	Ext.util.MixedCollection.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.util.MixedCollection,
				Ext.util.Observable,
				{
					allowFunctions : false,
					add : function(_3, o) {
						if (arguments.length == 1) {
							o = arguments[0];
							_3 = this.getKey(o);
						}
						if (typeof _3 == "undefined" || _3 === null) {
							this.length++;
							this.items.push(o);
							this.keys.push(null);
						} else {
							var _5 = this.map[_3];
							if (_5) {
								return this.replace(_3, o);
							}
							this.length++;
							this.items.push(o);
							this.map[_3] = o;
							this.keys.push(_3);
						}
						this.fireEvent("add", this.length - 1, o, _3);
						return o;
					},
					getKey : function(o) {
						return o.id;
					},
					replace : function(_7, o) {
						if (arguments.length == 1) {
							o = arguments[0];
							_7 = this.getKey(o);
						}
						var _9 = this.item(_7);
						if (typeof _7 == "undefined" || _7 === null
								|| typeof _9 == "undefined") {
							return this.add(_7, o);
						}
						var _a = this.indexOfKey(_7);
						this.items[_a] = o;
						this.map[_7] = o;
						this.fireEvent("replace", _7, _9, o);
						return o;
					},
					addAll : function(_b) {
						if (arguments.length > 1 || _b instanceof Array) {
							var _c = arguments.length > 1 ? arguments : _b;
							for ( var i = 0, _e = _c.length; i < _e; i++) {
								this.add(_c[i]);
							}
						} else {
							for ( var _f in _b) {
								if (this.allowFunctions
										|| typeof _b[_f] != "function") {
									this.add(_b[_f], _f);
								}
							}
						}
					},
					each : function(fn, _11) {
						var _12 = [].concat(this.items);
						for ( var i = 0, len = _12.length; i < len; i++) {
							if (fn.call(_11 || _12[i], _12[i], i, len) === false) {
								break;
							}
						}
					},
					eachKey : function(fn, _16) {
						for ( var i = 0, len = this.keys.length; i < len; i++) {
							fn.call(_16 || window, this.keys[i], this.items[i],
									i, len);
						}
					},
					find : function(fn, _1a) {
						for ( var i = 0, len = this.items.length; i < len; i++) {
							if (fn.call(_1a || window, this.items[i],
									this.keys[i])) {
								return this.items[i];
							}
						}
						return null;
					},
					insert : function(_1d, key, o) {
						if (arguments.length == 2) {
							o = arguments[1];
							key = this.getKey(o);
						}
						if (_1d >= this.length) {
							return this.add(key, o);
						}
						this.length++;
						this.items.splice(_1d, 0, o);
						if (typeof key != "undefined" && key != null) {
							this.map[key] = o;
						}
						this.keys.splice(_1d, 0, key);
						this.fireEvent("add", _1d, o, key);
						return o;
					},
					remove : function(o) {
						return this.removeAt(this.indexOf(o));
					},
					removeAt : function(_21) {
						if (_21 < this.length && _21 >= 0) {
							this.length--;
							var o = this.items[_21];
							this.items.splice(_21, 1);
							var key = this.keys[_21];
							if (typeof key != "undefined") {
								delete this.map[key];
							}
							this.keys.splice(_21, 1);
							this.fireEvent("remove", o, key);
						}
					},
					removeKey : function(key) {
						return this.removeAt(this.indexOfKey(key));
					},
					getCount : function() {
						return this.length;
					},
					indexOf : function(o) {
						if (!this.items.indexOf) {
							for ( var i = 0, len = this.items.length; i < len; i++) {
								if (this.items[i] == o) {
									return i;
								}
							}
							return -1;
						} else {
							return this.items.indexOf(o);
						}
					},
					indexOfKey : function(key) {
						if (!this.keys.indexOf) {
							for ( var i = 0, len = this.keys.length; i < len; i++) {
								if (this.keys[i] == key) {
									return i;
								}
							}
							return -1;
						} else {
							return this.keys.indexOf(key);
						}
					},
					item : function(key) {
						var _2c = typeof this.map[key] != "undefined" ? this.map[key]
								: this.items[key];
						return typeof _2c != "function" || this.allowFunctions ? _2c
								: null;
					},
					itemAt : function(_2d) {
						return this.items[_2d];
					},
					key : function(key) {
						return this.map[key];
					},
					contains : function(o) {
						return this.indexOf(o) != -1;
					},
					containsKey : function(key) {
						return typeof this.map[key] != "undefined";
					},
					clear : function() {
						this.length = 0;
						this.items = [];
						this.keys = [];
						this.map = {};
						this.fireEvent("clear");
					},
					first : function() {
						return this.items[0];
					},
					last : function() {
						return this.items[this.length - 1];
					},
					_sort : function(_31, dir, fn) {
						var dsc = String(dir).toUpperCase() == "DESC" ? -1 : 1;
						fn = fn || function(a, b) {
							return a - b;
						};
						var c = [], k = this.keys, _39 = this.items;
						for ( var i = 0, len = _39.length; i < len; i++) {
							c[c.length] = {
								key : k[i],
								value : _39[i],
								index : i
							};
						}
						c.sort(function(a, b) {
							var v = fn(a[_31], b[_31]) * dsc;
							if (v == 0) {
								v = (a.index < b.index ? -1 : 1);
							}
							return v;
						});
						for ( var i = 0, len = c.length; i < len; i++) {
							_39[i] = c[i].value;
							k[i] = c[i].key;
						}
						this.fireEvent("sort", this);
					},
					sort : function(dir, fn) {
						this._sort("value", dir, fn);
					},
					keySort : function(dir, fn) {
						this._sort("key", dir, fn
								|| function(a, b) {
									return String(a).toUpperCase()
											- String(b).toUpperCase();
								});
					},
					getRange : function(_45, end) {
						var _47 = this.items;
						if (_47.length < 1) {
							return [];
						}
						_45 = _45 || 0;
						end = Math.min(
								typeof end == "undefined" ? this.length - 1
										: end, this.length - 1);
						var r = [];
						if (_45 <= end) {
							for ( var i = _45; i <= end; i++) {
								r[r.length] = _47[i];
							}
						} else {
							for ( var i = _45; i >= end; i--) {
								r[r.length] = _47[i];
							}
						}
						return r;
					},
					filter : function(_4a, _4b) {
						if (!_4b.exec) {
							_4b = String(_4b);
							if (_4b.length == 0) {
								return this.clone();
							}
							_4b = new RegExp("^" + Ext.escapeRe(_4b), "i");
						}
						return this.filterBy(function(o) {
							return o && _4b.test(o[_4a]);
						});
					},
					filterBy : function(fn, _4e) {
						var r = new Ext.util.MixedCollection();
						r.getKey = this.getKey;
						var k = this.keys, it = this.items;
						for ( var i = 0, len = it.length; i < len; i++) {
							if (fn.call(_4e || this, it[i], k[i])) {
								r.add(k[i], it[i]);
							}
						}
						return r;
					},
					clone : function() {
						var r = new Ext.util.MixedCollection();
						var k = this.keys, it = this.items;
						for ( var i = 0, len = it.length; i < len; i++) {
							r.add(k[i], it[i]);
						}
						r.getKey = this.getKey;
						return r;
					}
				});
Ext.util.MixedCollection.prototype.get = Ext.util.MixedCollection.prototype.item;

Ext.util.JSON = new (function() {
	var _1 = {}.hasOwnProperty ? true : false;
	var _2 = function(n) {
		return n < 10 ? "0" + n : n;
	};
	var m = {
		"\b" : "\\b",
		"\t" : "\\t",
		"\n" : "\\n",
		"\f" : "\\f",
		"\r" : "\\r",
		"\"" : "\\\"",
		"\\" : "\\\\"
	};
	var _5 = function(s) {
		if (/["\\\x00-\x1f]/.test(s)) {
			return "\""
					+ s.replace(/([\x00-\x1f\\"])/g, function(a, b) {
						var c = m[b];
						if (c) {
							return c;
						}
						c = b.charCodeAt();
						return "\\u00" + Math.floor(c / 16).toString(16)
								+ (c % 16).toString(16);
					}) + "\"";
		}
		return "\"" + s + "\"";
	};
	var _a = function(o) {
		var a = [ "[" ], b, i, l = o.length, v;
		for (i = 0; i < l; i += 1) {
			v = o[i];
			switch (typeof v) {
			case "undefined":
			case "function":
			case "unknown":
				break;
			default:
				if (b) {
					a.push(",");
				}
				a.push(v === null ? "null" : Ext.util.JSON.encode(v));
				b = true;
			}
		}
		a.push("]");
		return a.join("");
	};
	var _11 = function(o) {
		return "\"" + o.getFullYear() + "-" + _2(o.getMonth() + 1) + "-"
				+ _2(o.getDate()) + "T" + _2(o.getHours()) + ":"
				+ _2(o.getMinutes()) + ":" + _2(o.getSeconds()) + "\"";
	};
	this.encode = function(o) {
		if (typeof o == "undefined" || o === null) {
			return "null";
		} else {
			if (o instanceof Array) {
				return _a(o);
			} else {
				if (o instanceof Date) {
					return _11(o);
				} else {
					if (typeof o == "string") {
						return _5(o);
					} else {
						if (typeof o == "number") {
							return isFinite(o) ? String(o) : "null";
						} else {
							if (typeof o == "boolean") {
								return String(o);
							} else {
								var a = [ "{" ], b, i, v;
								for (i in o) {
									if (!_1 || o.hasOwnProperty(i)) {
										v = o[i];
										switch (typeof v) {
										case "undefined":
										case "function":
										case "unknown":
											break;
										default:
											if (b) {
												a.push(",");
											}
											a.push(this.encode(i), ":",
													v === null ? "null" : this
															.encode(v));
											b = true;
										}
									}
								}
								a.push("}");
								return a.join("");
							}
						}
					}
				}
			}
		}
	};
	this.decode = function(_18) {
		return eval("(" + _18 + ")");
	};
})();
Ext.encode = Ext.util.JSON.encode;
Ext.decode = Ext.util.JSON.decode;

Ext.util.Format = function() {
	var _1 = /^\s+|\s+$/g;
	return {
		ellipsis : function(_2, _3) {
			if (_2 && _2.length > _3) {
				return _2.substr(0, _3 - 3) + "...";
			}
			return _2;
		},
		undef : function(_4) {
			return typeof _4 != "undefined" ? _4 : "";
		},
		htmlEncode : function(_5) {
			return !_5 ? _5 : String(_5).replace(/&/g, "&amp;").replace(/>/g,
					"&gt;").replace(/</g, "&lt;").replace(/"/g, "&quot;");
		},
		trim : function(_6) {
			return String(_6).replace(_1, "");
		},
		substr : function(_7, _8, _9) {
			return String(_7).substr(_8, _9);
		},
		lowercase : function(_a) {
			return String(_a).toLowerCase();
		},
		uppercase : function(_b) {
			return String(_b).toUpperCase();
		},
		capitalize : function(_c) {
			return !_c ? _c : _c.charAt(0).toUpperCase()
					+ _c.substr(1).toLowerCase();
		},
		call : function(_d, fn) {
			if (arguments.length > 2) {
				var _f = Array.prototype.slice.call(arguments, 2);
				_f.unshift(_d);
				return eval(fn).apply(window, _f);
			} else {
				return eval(fn).call(window, _d);
			}
		},
		usMoney : function(v) {
			v = (Math.round((v - 0) * 100)) / 100;
			v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math
					.floor(v * 10)) ? v + "0" : v);
			return "$" + v;
		},
		date : function(v, _12) {
			if (!v) {
				return "";
			}
			if (!(v instanceof Date)) {
				v = new Date(Date.parse(v));
			}
			return v.dateFormat(_12 || "m/d/Y");
		},
		dateRenderer : function(_13) {
			return function(v) {
				return Ext.util.Format.date(v, _13);
			};
		},
		stripTagsRE : /<\/?[^>]+>/gi,
		stripTags : function(v) {
			return !v ? v : String(v).replace(this.stripTagsRE, "");
		}
	};
}();

Ext.util.CSS = function() {
	var _1 = null;
	var _2 = document;
	var _3 = /(-[a-z])/gi;
	var _4 = function(m, a) {
		return a.charAt(1).toUpperCase();
	};
	return {
		createStyleSheet : function(_7) {
			var ss;
			if (Ext.isIE) {
				ss = _2.createStyleSheet();
				ss.cssText = _7;
			} else {
				var _9 = _2.getElementsByTagName("head")[0];
				var _a = _2.createElement("style");
				_a.setAttribute("type", "text/css");
				try {
					_a.appendChild(_2.createTextNode(_7));
				} catch (e) {
					_a.cssText = _7;
				}
				_9.appendChild(_a);
				ss = _a.styleSheet ? _a.styleSheet
						: (_a.sheet || _2.styleSheets[_2.styleSheets.length - 1]);
			}
			this.cacheStyleSheet(ss);
			return ss;
		},
		removeStyleSheet : function(id) {
			var _c = _2.getElementById(id);
			if (_c) {
				_c.parentNode.removeChild(_c);
			}
		},
		swapStyleSheet : function(id, _e) {
			this.removeStyleSheet(id);
			var ss = _2.createElement("link");
			ss.setAttribute("rel", "stylesheet");
			ss.setAttribute("type", "text/css");
			ss.setAttribute("id", id);
			ss.setAttribute("href", _e);
			_2.getElementsByTagName("head")[0].appendChild(ss);
		},
		refreshCache : function() {
			return this.getRules(true);
		},
		cacheStyleSheet : function(ss) {
			if (!_1) {
				_1 = {};
			}
			try {
				var _11 = ss.cssRules || ss.rules;
				for ( var j = _11.length - 1; j >= 0; --j) {
					_1[_11[j].selectorText] = _11[j];
				}
			} catch (e) {
			}
		},
		getRules : function(_13) {
			if (_1 == null || _13) {
				_1 = {};
				var ds = _2.styleSheets;
				for ( var i = 0, len = ds.length; i < len; i++) {
					try {
						this.cacheStyleSheet(ds[i]);
					} catch (e) {
					}
				}
			}
			return _1;
		},
		getRule : function(_17, _18) {
			var rs = this.getRules(_18);
			if (!(_17 instanceof Array)) {
				return rs[_17];
			}
			for ( var i = 0; i < _17.length; i++) {
				if (rs[_17[i]]) {
					return rs[_17[i]];
				}
			}
			return null;
		},
		updateRule : function(_1b, _1c, _1d) {
			if (!(_1b instanceof Array)) {
				var _1e = this.getRule(_1b);
				if (_1e) {
					_1e.style[_1c.replace(_3, _4)] = _1d;
					return true;
				}
			} else {
				for ( var i = 0; i < _1b.length; i++) {
					if (this.updateRule(_1b[i], _1c, _1d)) {
						return true;
					}
				}
			}
			return false;
		}
	};
}();

Ext.util.ClickRepeater = function(el, _2) {
	this.el = Ext.get(el);
	this.el.unselectable();
	Ext.apply(this, _2);
	this.events = {
		"mousedown" : true,
		"click" : true,
		"mouseup" : true
	};
	this.el.on("mousedown", this.handleMouseDown, this);
	if (this.preventDefault || this.stopDefault) {
		this.el.on("click", function(e) {
			if (this.preventDefault) {
				e.preventDefault();
			}
			if (this.stopDefault) {
				e.stopEvent();
			}
		}, this);
	}
	if (this.handler) {
		this.on("click", this.handler, this.scope || this);
	}
	Ext.util.ClickRepeater.superclass.constructor.call(this);
};
Ext.extend(Ext.util.ClickRepeater, Ext.util.Observable, {
	interval : 20,
	delay : 250,
	preventDefault : true,
	stopDefault : false,
	timer : 0,
	docEl : Ext.get(document),
	handleMouseDown : function() {
		clearTimeout(this.timer);
		this.el.blur();
		if (this.pressClass) {
			this.el.addClass(this.pressClass);
		}
		this.mousedownTime = new Date();
		this.docEl.on("mouseup", this.handleMouseUp, this);
		this.el.on("mouseout", this.handleMouseOut, this);
		this.fireEvent("mousedown", this);
		this.fireEvent("click", this);
		this.timer = this.click.defer(this.delay || this.interval, this);
	},
	click : function() {
		this.fireEvent("click", this);
		this.timer = this.click.defer(this.getInterval(), this);
	},
	getInterval : function() {
		if (!this.accelerate) {
			return this.interval;
		}
		var _4 = this.mousedownTime.getElapsed();
		if (_4 < 500) {
			return 400;
		} else {
			if (_4 < 1700) {
				return 320;
			} else {
				if (_4 < 2600) {
					return 250;
				} else {
					if (_4 < 3500) {
						return 180;
					} else {
						if (_4 < 4400) {
							return 140;
						} else {
							if (_4 < 5300) {
								return 80;
							} else {
								if (_4 < 6200) {
									return 50;
								} else {
									return 10;
								}
							}
						}
					}
				}
			}
		}
	},
	handleMouseOut : function() {
		clearTimeout(this.timer);
		if (this.pressClass) {
			this.el.removeClass(this.pressClass);
		}
		this.el.on("mouseover", this.handleMouseReturn, this);
	},
	handleMouseReturn : function() {
		this.el.un("mouseover", this.handleMouseReturn);
		if (this.pressClass) {
			this.el.addClass(this.pressClass);
		}
		this.click();
	},
	handleMouseUp : function() {
		clearTimeout(this.timer);
		this.el.un("mouseover", this.handleMouseReturn);
		this.el.un("mouseout", this.handleMouseOut);
		this.docEl.un("mouseup", this.handleMouseUp);
		this.el.removeClass(this.pressClass);
		this.fireEvent("mouseup", this);
	}
});

Ext.KeyNav = function(el, _2) {
	this.el = Ext.get(el);
	Ext.apply(this, _2);
	if (!this.disabled) {
		this.disabled = true;
		this.enable();
	}
};
Ext.KeyNav.prototype = {
	disabled : false,
	defaultEventAction : "stopEvent",
	prepareEvent : function(e) {
		var k = e.getKey();
		var h = this.keyToHandler[k];
		if (Ext.isSafari && h && k >= 37 && k <= 40) {
			e.stopEvent();
		}
	},
	relay : function(e) {
		var k = e.getKey();
		var h = this.keyToHandler[k];
		if (h && this[h]) {
			if (this.doRelay(e, this[h], h) !== true) {
				e[this.defaultEventAction]();
			}
		}
	},
	doRelay : function(e, h, _b) {
		return h.call(this.scope || this, e);
	},
	enter : false,
	left : false,
	right : false,
	up : false,
	down : false,
	tab : false,
	esc : false,
	pageUp : false,
	pageDown : false,
	del : false,
	home : false,
	end : false,
	keyToHandler : {
		37 : "left",
		39 : "right",
		38 : "up",
		40 : "down",
		33 : "pageUp",
		34 : "pageDown",
		46 : "del",
		36 : "home",
		35 : "end",
		13 : "enter",
		27 : "esc",
		9 : "tab"
	},
	enable : function() {
		if (this.disabled) {
			if (Ext.isIE) {
				this.el.on("keydown", this.relay, this);
			} else {
				this.el.on("keydown", this.prepareEvent, this);
				this.el.on("keypress", this.relay, this);
			}
			this.disabled = false;
		}
	},
	disable : function() {
		if (!this.disabled) {
			if (Ext.isIE) {
				this.el.un("keydown", this.relay);
			} else {
				this.el.un("keydown", this.prepareEvent);
				this.el.un("keypress", this.relay);
			}
			this.disabled = true;
		}
	}
};

Ext.KeyMap = function(el, _2, _3) {
	this.el = Ext.get(el);
	this.eventName = _3 || "keydown";
	this.bindings = [];
	if (_2 instanceof Array) {
		for ( var i = 0, _5 = _2.length; i < _5; i++) {
			this.addBinding(_2[i]);
		}
	} else {
		this.addBinding(_2);
	}
	this.keyDownDelegate = Ext.EventManager
			.wrap(this.handleKeyDown, this, true);
	this.enable();
};
Ext.KeyMap.prototype = {
	stopEvent : false,
	addBinding : function(_6) {
		var _7 = _6.key, _8 = _6.shift, _9 = _6.ctrl, _a = _6.alt, fn = _6.fn, _c = _6.scope;
		if (typeof _7 == "string") {
			var ks = [];
			var _e = _7.toUpperCase();
			for ( var j = 0, len = _e.length; j < len; j++) {
				ks.push(_e.charCodeAt(j));
			}
			_7 = ks;
		}
		var _11 = _7 instanceof Array;
		var _12 = function(e) {
			if ((!_8 || e.shiftKey) && (!_9 || e.ctrlKey) && (!_a || e.altKey)) {
				var k = e.getKey();
				if (_11) {
					for ( var i = 0, len = _7.length; i < len; i++) {
						if (_7[i] == k) {
							if (this.stopEvent) {
								e.stopEvent();
							}
							fn.call(_c || window, k, e);
							return;
						}
					}
				} else {
					if (k == _7) {
						if (this.stopEvent) {
							e.stopEvent();
						}
						fn.call(_c || window, k, e);
					}
				}
			}
		};
		this.bindings.push(_12);
	},
	handleKeyDown : function(e) {
		if (this.enabled) {
			var b = this.bindings;
			for ( var i = 0, len = b.length; i < len; i++) {
				b[i].call(this, e);
			}
		}
	},
	isEnabled : function() {
		return this.enabled;
	},
	enable : function() {
		if (!this.enabled) {
			this.el.on(this.eventName, this.keyDownDelegate);
			this.enabled = true;
		}
	},
	disable : function() {
		if (this.enabled) {
			this.el.removeListener(this.eventName, this.keyDownDelegate);
			this.enabled = false;
		}
	}
};

Ext.util.TextMetrics = function() {
	var _1;
	return {
		measure : function(el, _3, _4) {
			if (!_1) {
				_1 = Ext.util.TextMetrics.Instance(el, _4);
			}
			_1.bind(el);
			_1.setFixedWidth(_4 || "auto");
			return _1.getSize(_3);
		},
		createInstance : function(el, _6) {
			return Ext.util.TextMetrics.Instance(el, _6);
		}
	};
}();
Ext.util.TextMetrics.Instance = function(_7, _8) {
	var ml = new Ext.Element(document.createElement("div"));
	document.body.appendChild(ml.dom);
	ml.position("absolute");
	ml.setLeftTop(-1000, -1000);
	ml.hide();
	if (_8) {
		mi.setWidth(_8);
	}
	var _a = {
		getSize : function(_b) {
			ml.update(_b);
			var s = ml.getSize();
			ml.update("");
			return s;
		},
		bind : function(el) {
			ml.setStyle(Ext.fly(el).getStyles("font-size", "font-style",
					"font-weight", "font-family", "line-height"));
		},
		setFixedWidth : function(_e) {
			ml.setWidth(_e);
		},
		getWidth : function(_f) {
			ml.dom.style.width = "auto";
			return this.getSize(_f).width;
		},
		getHeight : function(_10) {
			return this.getSize(_10).height;
		}
	};
	_a.bind(_7);
	return _a;
};
Ext.Element.measureText = Ext.util.TextMetrics.measure;

Ext.state.Provider = function() {
	Ext.state.Provider.superclass.constructor.call(this);
	this.events = {
		"statechange" : true
	};
	this.state = {};
	Ext.state.Provider.superclass.constructor.call(this);
};
Ext.extend(Ext.state.Provider, Ext.util.Observable, {
	get : function(_1, _2) {
		return typeof this.state[_1] == "undefined" ? _2 : this.state[_1];
	},
	clear : function(_3) {
		delete this.state[_3];
		this.fireEvent("statechange", this, _3, null);
	},
	set : function(_4, _5) {
		this.state[_4] = _5;
		this.fireEvent("statechange", this, _4, _5);
	},
	decodeValue : function(_6) {
		var re = /^(a|n|d|b|s|o)\:(.*)$/;
		var _8 = re.exec(unescape(_6));
		if (!_8 || !_8[1]) {
			return;
		}
		var _9 = _8[1];
		var v = _8[2];
		switch (_9) {
		case "n":
			return parseFloat(v);
		case "d":
			return new Date(Date.parse(v));
		case "b":
			return (v == "1");
		case "a":
			var _b = [];
			var _c = v.split("^");
			for ( var i = 0, _e = _c.length; i < _e; i++) {
				_b.push(this.decodeValue(_c[i]));
			}
			return _b;
		case "o":
			var _b = {};
			var _c = v.split("^");
			for ( var i = 0, _e = _c.length; i < _e; i++) {
				var kv = _c[i].split("=");
				_b[kv[0]] = this.decodeValue(kv[1]);
			}
			return _b;
		default:
			return v;
		}
	},
	encodeValue : function(v) {
		var enc;
		if (typeof v == "number") {
			enc = "n:" + v;
		} else {
			if (typeof v == "boolean") {
				enc = "b:" + (v ? "1" : "0");
			} else {
				if (v instanceof Date) {
					enc = "d:" + v.toGMTString();
				} else {
					if (v instanceof Array) {
						var _12 = "";
						for ( var i = 0, len = v.length; i < len; i++) {
							_12 += this.encodeValue(v[i]);
							if (i != len - 1) {
								_12 += "^";
							}
						}
						enc = "a:" + _12;
					} else {
						if (typeof v == "object") {
							var _12 = "";
							for ( var key in v) {
								if (typeof v[key] != "function") {
									_12 += key + "=" + this.encodeValue(v[key])
											+ "^";
								}
							}
							enc = "o:" + _12.substring(0, _12.length - 1);
						} else {
							enc = "s:" + v;
						}
					}
				}
			}
		}
		return escape(enc);
	}
});
Ext.state.Manager = function() {
	var _16 = new Ext.state.Provider();
	return {
		setProvider : function(_17) {
			_16 = _17;
		},
		get : function(key, _19) {
			return _16.get(key, _19);
		},
		set : function(key, _1b) {
			_16.set(key, _1b);
		},
		clear : function(key) {
			_16.clear(key);
		},
		getProvider : function() {
			return _16;
		}
	};
}();
Ext.state.CookieProvider = function(_1d) {
	Ext.state.CookieProvider.superclass.constructor.call(this);
	this.path = "/";
	this.expires = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7));
	this.domain = null;
	this.secure = false;
	Ext.apply(this, _1d);
	this.state = this.readCookies();
};
Ext.extend(Ext.state.CookieProvider, Ext.state.Provider, {
	set : function(_1e, _1f) {
		if (typeof _1f == "undefined" || _1f === null) {
			this.clear(_1e);
			return;
		}
		this.setCookie(_1e, _1f);
		Ext.state.CookieProvider.superclass.set.call(this, _1e, _1f);
	},
	clear : function(_20) {
		this.clearCookie(_20);
		Ext.state.CookieProvider.superclass.clear.call(this, _20);
	},
	readCookies : function() {
		var _21 = {};
		var c = document.cookie + ";";
		var re = /\s?(.*?)=(.*?);/g;
		var _24;
		while ((_24 = re.exec(c)) != null) {
			var _25 = _24[1];
			var _26 = _24[2];
			if (_25 && _25.substring(0, 3) == "ys-") {
				_21[_25.substr(3)] = this.decodeValue(_26);
			}
		}
		return _21;
	},
	setCookie : function(_27, _28) {
		document.cookie = "ys-"
				+ _27
				+ "="
				+ this.encodeValue(_28)
				+ ((this.expires == null) ? "" : ("; expires=" + this.expires
						.toGMTString()))
				+ ((this.path == null) ? "" : ("; path=" + this.path))
				+ ((this.domain == null) ? "" : ("; domain=" + this.domain))
				+ ((this.secure == true) ? "; secure" : "");
	},
	clearCookie : function(_29) {
		document.cookie = "ys-" + _29
				+ "=null; expires=Thu, 01-Jan-70 00:00:01 GMT"
				+ ((this.path == null) ? "" : ("; path=" + this.path))
				+ ((this.domain == null) ? "" : ("; domain=" + this.domain))
				+ ((this.secure == true) ? "; secure" : "");
	}
});

(function() {
	var _1 = Ext.EventManager;
	var _2 = Ext.lib.Dom;
	Ext.dd.DragDrop = function(id, _4, _5) {
		if (id) {
			this.init(id, _4, _5);
		}
	};
	Ext.dd.DragDrop.prototype = {
		id : null,
		config : null,
		dragElId : null,
		handleElId : null,
		invalidHandleTypes : null,
		invalidHandleIds : null,
		invalidHandleClasses : null,
		startPageX : 0,
		startPageY : 0,
		groups : null,
		locked : false,
		lock : function() {
			this.locked = true;
		},
		unlock : function() {
			this.locked = false;
		},
		isTarget : true,
		padding : null,
		_domRef : null,
		__ygDragDrop : true,
		constrainX : false,
		constrainY : false,
		minX : 0,
		maxX : 0,
		minY : 0,
		maxY : 0,
		maintainOffset : false,
		xTicks : null,
		yTicks : null,
		primaryButtonOnly : true,
		available : false,
		hasOuterHandles : false,
		b4StartDrag : function(x, y) {
		},
		startDrag : function(x, y) {
		},
		b4Drag : function(e) {
		},
		onDrag : function(e) {
		},
		onDragEnter : function(e, id) {
		},
		b4DragOver : function(e) {
		},
		onDragOver : function(e, id) {
		},
		b4DragOut : function(e) {
		},
		onDragOut : function(e, id) {
		},
		b4DragDrop : function(e) {
		},
		onDragDrop : function(e, id) {
		},
		onInvalidDrop : function(e) {
		},
		b4EndDrag : function(e) {
		},
		endDrag : function(e) {
		},
		b4MouseDown : function(e) {
		},
		onMouseDown : function(e) {
		},
		onMouseUp : function(e) {
		},
		onAvailable : function() {
		},
		defaultPadding : {
			left : 0,
			right : 0,
			top : 0,
			bottom : 0
		},
		constrainTo : function(_1d, pad, _1f) {
			if (typeof pad == "number") {
				pad = {
					left : pad,
					right : pad,
					top : pad,
					bottom : pad
				};
			}
			pad = pad || this.defaultPadding;
			var b = Ext.get(this.getEl()).getBox();
			var ce = Ext.get(_1d);
			var c = ce.dom == document.body ? {
				x : 0,
				y : 0,
				width : Ext.lib.Dom.getViewWidth(),
				height : Ext.lib.Dom.getViewHeight()
			} : ce.getBox(_1f || false);
			var _23 = b.y - c.y;
			var _24 = b.x - c.x;
			this.resetConstraints();
			this.setXConstraint(_24 - (pad.left || 0), c.width - _24 - b.width
					- (pad.right || 0));
			this.setYConstraint(_23 - (pad.top || 0), c.height - _23 - b.height
					- (pad.bottom || 0));
		},
		getEl : function() {
			if (!this._domRef) {
				this._domRef = Ext.getDom(this.id);
			}
			return this._domRef;
		},
		getDragEl : function() {
			return Ext.getDom(this.dragElId);
		},
		init : function(id, _26, _27) {
			this.initTarget(id, _26, _27);
			_1.on(this.id, "mousedown", this.handleMouseDown, this);
		},
		initTarget : function(id, _29, _2a) {
			this.config = _2a || {};
			this.DDM = Ext.dd.DDM;
			this.groups = {};
			if (typeof id !== "string") {
				id = Ext.id(id);
			}
			this.id = id;
			this.addToGroup((_29) ? _29 : "default");
			this.handleElId = id;
			this.setDragElId(id);
			this.invalidHandleTypes = {
				A : "A"
			};
			this.invalidHandleIds = {};
			this.invalidHandleClasses = [];
			this.applyConfig();
			this.handleOnAvailable();
		},
		applyConfig : function() {
			this.padding = this.config.padding || [ 0, 0, 0, 0 ];
			this.isTarget = (this.config.isTarget !== false);
			this.maintainOffset = (this.config.maintainOffset);
			this.primaryButtonOnly = (this.config.primaryButtonOnly !== false);
		},
		handleOnAvailable : function() {
			this.available = true;
			this.resetConstraints();
			this.onAvailable();
		},
		setPadding : function(_2b, _2c, _2d, _2e) {
			if (!_2c && 0 !== _2c) {
				this.padding = [ _2b, _2b, _2b, _2b ];
			} else {
				if (!_2d && 0 !== _2d) {
					this.padding = [ _2b, _2c, _2b, _2c ];
				} else {
					this.padding = [ _2b, _2c, _2d, _2e ];
				}
			}
		},
		setInitPosition : function(_2f, _30) {
			var el = this.getEl();
			if (!this.DDM.verifyEl(el)) {
				return;
			}
			var dx = _2f || 0;
			var dy = _30 || 0;
			var p = _2.getXY(el);
			this.initPageX = p[0] - dx;
			this.initPageY = p[1] - dy;
			this.lastPageX = p[0];
			this.lastPageY = p[1];
			this.setStartPosition(p);
		},
		setStartPosition : function(pos) {
			var p = pos || _2.getXY(this.getEl());
			this.deltaSetXY = null;
			this.startPageX = p[0];
			this.startPageY = p[1];
		},
		addToGroup : function(_37) {
			this.groups[_37] = true;
			this.DDM.regDragDrop(this, _37);
		},
		removeFromGroup : function(_38) {
			if (this.groups[_38]) {
				delete this.groups[_38];
			}
			this.DDM.removeDDFromGroup(this, _38);
		},
		setDragElId : function(id) {
			this.dragElId = id;
		},
		setHandleElId : function(id) {
			if (typeof id !== "string") {
				id = Ext.id(id);
			}
			this.handleElId = id;
			this.DDM.regHandle(this.id, id);
		},
		setOuterHandleElId : function(id) {
			if (typeof id !== "string") {
				id = Ext.id(id);
			}
			_1.on(id, "mousedown", this.handleMouseDown, this);
			this.setHandleElId(id);
			this.hasOuterHandles = true;
		},
		unreg : function() {
			_1.un(this.id, "mousedown", this.handleMouseDown);
			this._domRef = null;
			this.DDM._remove(this);
		},
		isLocked : function() {
			return (this.DDM.isLocked() || this.locked);
		},
		handleMouseDown : function(e, oDD) {
			if (this.primaryButtonOnly && e.button != 0) {
				return;
			}
			if (this.isLocked()) {
				return;
			}
			this.DDM.refreshCache(this.groups);
			var pt = new Ext.lib.Point(Ext.lib.Event.getPageX(e), Ext.lib.Event
					.getPageY(e));
			if (!this.hasOuterHandles && !this.DDM.isOverTarget(pt, this)) {
			} else {
				if (this.clickValidator(e)) {
					this.setStartPosition();
					this.b4MouseDown(e);
					this.onMouseDown(e);
					this.DDM.handleMouseDown(e, this);
					this.DDM.stopEvent(e);
				} else {
				}
			}
		},
		clickValidator : function(e) {
			var _40 = Ext.lib.Event.getTarget(e);
			return (this.isValidHandleChild(_40) && (this.id == this.handleElId || this.DDM
					.handleWasClicked(_40, this.id)));
		},
		addInvalidHandleType : function(_41) {
			var _42 = _41.toUpperCase();
			this.invalidHandleTypes[_42] = _42;
		},
		addInvalidHandleId : function(id) {
			if (typeof id !== "string") {
				id = Ext.id(id);
			}
			this.invalidHandleIds[id] = id;
		},
		addInvalidHandleClass : function(_44) {
			this.invalidHandleClasses.push(_44);
		},
		removeInvalidHandleType : function(_45) {
			var _46 = _45.toUpperCase();
			delete this.invalidHandleTypes[_46];
		},
		removeInvalidHandleId : function(id) {
			if (typeof id !== "string") {
				id = Ext.id(id);
			}
			delete this.invalidHandleIds[id];
		},
		removeInvalidHandleClass : function(_48) {
			for ( var i = 0, len = this.invalidHandleClasses.length; i < len; ++i) {
				if (this.invalidHandleClasses[i] == _48) {
					delete this.invalidHandleClasses[i];
				}
			}
		},
		isValidHandleChild : function(_4b) {
			var _4c = true;
			var _4d;
			try {
				_4d = _4b.nodeName.toUpperCase();
			} catch (e) {
				_4d = _4b.nodeName;
			}
			_4c = _4c && !this.invalidHandleTypes[_4d];
			_4c = _4c && !this.invalidHandleIds[_4b.id];
			for ( var i = 0, len = this.invalidHandleClasses.length; _4c
					&& i < len; ++i) {
				_4c = !_2.hasClass(_4b, this.invalidHandleClasses[i]);
			}
			return _4c;
		},
		setXTicks : function(_50, _51) {
			this.xTicks = [];
			this.xTickSize = _51;
			var _52 = {};
			for ( var i = this.initPageX; i >= this.minX; i = i - _51) {
				if (!_52[i]) {
					this.xTicks[this.xTicks.length] = i;
					_52[i] = true;
				}
			}
			for (i = this.initPageX; i <= this.maxX; i = i + _51) {
				if (!_52[i]) {
					this.xTicks[this.xTicks.length] = i;
					_52[i] = true;
				}
			}
			this.xTicks.sort(this.DDM.numericSort);
		},
		setYTicks : function(_54, _55) {
			this.yTicks = [];
			this.yTickSize = _55;
			var _56 = {};
			for ( var i = this.initPageY; i >= this.minY; i = i - _55) {
				if (!_56[i]) {
					this.yTicks[this.yTicks.length] = i;
					_56[i] = true;
				}
			}
			for (i = this.initPageY; i <= this.maxY; i = i + _55) {
				if (!_56[i]) {
					this.yTicks[this.yTicks.length] = i;
					_56[i] = true;
				}
			}
			this.yTicks.sort(this.DDM.numericSort);
		},
		setXConstraint : function(_58, _59, _5a) {
			this.leftConstraint = _58;
			this.rightConstraint = _59;
			this.minX = this.initPageX - _58;
			this.maxX = this.initPageX + _59;
			if (_5a) {
				this.setXTicks(this.initPageX, _5a);
			}
			this.constrainX = true;
		},
		clearConstraints : function() {
			this.constrainX = false;
			this.constrainY = false;
			this.clearTicks();
		},
		clearTicks : function() {
			this.xTicks = null;
			this.yTicks = null;
			this.xTickSize = 0;
			this.yTickSize = 0;
		},
		setYConstraint : function(iUp, _5c, _5d) {
			this.topConstraint = iUp;
			this.bottomConstraint = _5c;
			this.minY = this.initPageY - iUp;
			this.maxY = this.initPageY + _5c;
			if (_5d) {
				this.setYTicks(this.initPageY, _5d);
			}
			this.constrainY = true;
		},
		resetConstraints : function() {
			if (this.initPageX || this.initPageX === 0) {
				var dx = (this.maintainOffset) ? this.lastPageX
						- this.initPageX : 0;
				var dy = (this.maintainOffset) ? this.lastPageY
						- this.initPageY : 0;
				this.setInitPosition(dx, dy);
			} else {
				this.setInitPosition();
			}
			if (this.constrainX) {
				this.setXConstraint(this.leftConstraint, this.rightConstraint,
						this.xTickSize);
			}
			if (this.constrainY) {
				this.setYConstraint(this.topConstraint, this.bottomConstraint,
						this.yTickSize);
			}
		},
		getTick : function(val, _61) {
			if (!_61) {
				return val;
			} else {
				if (_61[0] >= val) {
					return _61[0];
				} else {
					for ( var i = 0, len = _61.length; i < len; ++i) {
						var _64 = i + 1;
						if (_61[_64] && _61[_64] >= val) {
							var _65 = val - _61[i];
							var _66 = _61[_64] - val;
							return (_66 > _65) ? _61[i] : _61[_64];
						}
					}
					return _61[_61.length - 1];
				}
			}
		},
		toString : function() {
			return ("DragDrop " + this.id);
		}
	};
})();
if (!Ext.dd.DragDropMgr) {
	Ext.dd.DragDropMgr = function() {
		var _67 = Ext.EventManager;
		return {
			ids : {},
			handleIds : {},
			dragCurrent : null,
			dragOvers : {},
			deltaX : 0,
			deltaY : 0,
			preventDefault : true,
			stopPropagation : true,
			initalized : false,
			locked : false,
			init : function() {
				this.initialized = true;
			},
			POINT : 0,
			INTERSECT : 1,
			mode : 0,
			_execOnAll : function(_68, _69) {
				for ( var i in this.ids) {
					for ( var j in this.ids[i]) {
						var oDD = this.ids[i][j];
						if (!this.isTypeOfDD(oDD)) {
							continue;
						}
						oDD[_68].apply(oDD, _69);
					}
				}
			},
			_onLoad : function() {
				this.init();
				_67.on(document, "mouseup", this.handleMouseUp, this, true);
				_67.on(document, "mousemove", this.handleMouseMove, this, true);
				_67.on(window, "unload", this._onUnload, this, true);
				_67.on(window, "resize", this._onResize, this, true);
			},
			_onResize : function(e) {
				this._execOnAll("resetConstraints", []);
			},
			lock : function() {
				this.locked = true;
			},
			unlock : function() {
				this.locked = false;
			},
			isLocked : function() {
				return this.locked;
			},
			locationCache : {},
			useCache : true,
			clickPixelThresh : 3,
			clickTimeThresh : 350,
			dragThreshMet : false,
			clickTimeout : null,
			startX : 0,
			startY : 0,
			regDragDrop : function(oDD, _6f) {
				if (!this.initialized) {
					this.init();
				}
				if (!this.ids[_6f]) {
					this.ids[_6f] = {};
				}
				this.ids[_6f][oDD.id] = oDD;
			},
			removeDDFromGroup : function(oDD, _71) {
				if (!this.ids[_71]) {
					this.ids[_71] = {};
				}
				var obj = this.ids[_71];
				if (obj && obj[oDD.id]) {
					delete obj[oDD.id];
				}
			},
			_remove : function(oDD) {
				for ( var g in oDD.groups) {
					if (g && this.ids[g][oDD.id]) {
						delete this.ids[g][oDD.id];
					}
				}
				delete this.handleIds[oDD.id];
			},
			regHandle : function(_75, _76) {
				if (!this.handleIds[_75]) {
					this.handleIds[_75] = {};
				}
				this.handleIds[_75][_76] = _76;
			},
			isDragDrop : function(id) {
				return (this.getDDById(id)) ? true : false;
			},
			getRelated : function(_78, _79) {
				var _7a = [];
				for ( var i in _78.groups) {
					for (j in this.ids[i]) {
						var dd = this.ids[i][j];
						if (!this.isTypeOfDD(dd)) {
							continue;
						}
						if (!_79 || dd.isTarget) {
							_7a[_7a.length] = dd;
						}
					}
				}
				return _7a;
			},
			isLegalTarget : function(oDD, _7e) {
				var _7f = this.getRelated(oDD, true);
				for ( var i = 0, len = _7f.length; i < len; ++i) {
					if (_7f[i].id == _7e.id) {
						return true;
					}
				}
				return false;
			},
			isTypeOfDD : function(oDD) {
				return (oDD && oDD.__ygDragDrop);
			},
			isHandle : function(_83, _84) {
				return (this.handleIds[_83] && this.handleIds[_83][_84]);
			},
			getDDById : function(id) {
				for ( var i in this.ids) {
					if (this.ids[i][id]) {
						return this.ids[i][id];
					}
				}
				return null;
			},
			handleMouseDown : function(e, oDD) {
				this.currentTarget = Ext.lib.Event.getTarget(e);
				this.dragCurrent = oDD;
				var el = oDD.getEl();
				this.startX = Ext.lib.Event.getPageX(e);
				this.startY = Ext.lib.Event.getPageY(e);
				this.deltaX = this.startX - el.offsetLeft;
				this.deltaY = this.startY - el.offsetTop;
				this.dragThreshMet = false;
				this.clickTimeout = setTimeout(function() {
					var DDM = Ext.dd.DDM;
					DDM.startDrag(DDM.startX, DDM.startY);
				}, this.clickTimeThresh);
			},
			startDrag : function(x, y) {
				clearTimeout(this.clickTimeout);
				if (this.dragCurrent) {
					this.dragCurrent.b4StartDrag(x, y);
					this.dragCurrent.startDrag(x, y);
				}
				this.dragThreshMet = true;
			},
			handleMouseUp : function(e) {
				if (!this.dragCurrent) {
					return;
				}
				clearTimeout(this.clickTimeout);
				if (this.dragThreshMet) {
					this.fireEvents(e, true);
				} else {
				}
				this.stopDrag(e);
				this.stopEvent(e);
			},
			stopEvent : function(e) {
				if (this.stopPropagation) {
					e.stopPropagation();
				}
				if (this.preventDefault) {
					e.preventDefault();
				}
			},
			stopDrag : function(e) {
				if (this.dragCurrent) {
					if (this.dragThreshMet) {
						this.dragCurrent.b4EndDrag(e);
						this.dragCurrent.endDrag(e);
					}
					this.dragCurrent.onMouseUp(e);
				}
				this.dragCurrent = null;
				this.dragOvers = {};
			},
			handleMouseMove : function(e) {
				if (!this.dragCurrent) {
					return true;
				}
				if (Ext.isIE
						&& (e.button !== 0 && e.button !== 1 && e.button !== 2)) {
					this.stopEvent(e);
					return this.handleMouseUp(e);
				}
				if (!this.dragThreshMet) {
					var _91 = Math.abs(this.startX - Ext.lib.Event.getPageX(e));
					var _92 = Math.abs(this.startY - Ext.lib.Event.getPageY(e));
					if (_91 > this.clickPixelThresh
							|| _92 > this.clickPixelThresh) {
						this.startDrag(this.startX, this.startY);
					}
				}
				if (this.dragThreshMet) {
					this.dragCurrent.b4Drag(e);
					this.dragCurrent.onDrag(e);
					this.fireEvents(e, false);
				}
				this.stopEvent(e);
				return true;
			},
			fireEvents : function(e, _94) {
				var dc = this.dragCurrent;
				if (!dc || dc.isLocked()) {
					return;
				}
				var x = Ext.lib.Event.getPageX(e);
				var y = Ext.lib.Event.getPageY(e);
				var pt = new Ext.lib.Point(x, y);
				var _99 = [];
				var _9a = [];
				var _9b = [];
				var _9c = [];
				var _9d = [];
				for ( var i in this.dragOvers) {
					var ddo = this.dragOvers[i];
					if (!this.isTypeOfDD(ddo)) {
						continue;
					}
					if (!this.isOverTarget(pt, ddo, this.mode)) {
						_9a.push(ddo);
					}
					_99[i] = true;
					delete this.dragOvers[i];
				}
				for ( var _a0 in dc.groups) {
					if ("string" != typeof _a0) {
						continue;
					}
					for (i in this.ids[_a0]) {
						var oDD = this.ids[_a0][i];
						if (!this.isTypeOfDD(oDD)) {
							continue;
						}
						if (oDD.isTarget && !oDD.isLocked() && oDD != dc) {
							if (this.isOverTarget(pt, oDD, this.mode)) {
								if (_94) {
									_9c.push(oDD);
								} else {
									if (!_99[oDD.id]) {
										_9d.push(oDD);
									} else {
										_9b.push(oDD);
									}
									this.dragOvers[oDD.id] = oDD;
								}
							}
						}
					}
				}
				if (this.mode) {
					if (_9a.length) {
						dc.b4DragOut(e, _9a);
						dc.onDragOut(e, _9a);
					}
					if (_9d.length) {
						dc.onDragEnter(e, _9d);
					}
					if (_9b.length) {
						dc.b4DragOver(e, _9b);
						dc.onDragOver(e, _9b);
					}
					if (_9c.length) {
						dc.b4DragDrop(e, _9c);
						dc.onDragDrop(e, _9c);
					}
				} else {
					var len = 0;
					for (i = 0, len = _9a.length; i < len; ++i) {
						dc.b4DragOut(e, _9a[i].id);
						dc.onDragOut(e, _9a[i].id);
					}
					for (i = 0, len = _9d.length; i < len; ++i) {
						dc.onDragEnter(e, _9d[i].id);
					}
					for (i = 0, len = _9b.length; i < len; ++i) {
						dc.b4DragOver(e, _9b[i].id);
						dc.onDragOver(e, _9b[i].id);
					}
					for (i = 0, len = _9c.length; i < len; ++i) {
						dc.b4DragDrop(e, _9c[i].id);
						dc.onDragDrop(e, _9c[i].id);
					}
				}
				if (_94 && !_9c.length) {
					dc.onInvalidDrop(e);
				}
			},
			getBestMatch : function(dds) {
				var _a4 = null;
				var len = dds.length;
				if (len == 1) {
					_a4 = dds[0];
				} else {
					for ( var i = 0; i < len; ++i) {
						var dd = dds[i];
						if (dd.cursorIsOver) {
							_a4 = dd;
							break;
						} else {
							if (!_a4
									|| _a4.overlap.getArea() < dd.overlap
											.getArea()) {
								_a4 = dd;
							}
						}
					}
				}
				return _a4;
			},
			refreshCache : function(_a8) {
				for ( var _a9 in _a8) {
					if ("string" != typeof _a9) {
						continue;
					}
					for ( var i in this.ids[_a9]) {
						var oDD = this.ids[_a9][i];
						if (this.isTypeOfDD(oDD)) {
							var loc = this.getLocation(oDD);
							if (loc) {
								this.locationCache[oDD.id] = loc;
							} else {
								delete this.locationCache[oDD.id];
							}
						}
					}
				}
			},
			verifyEl : function(el) {
				try {
					if (el) {
						var _ae = el.offsetParent;
						if (_ae) {
							return true;
						}
					}
				} catch (e) {
				}
				return false;
			},
			getLocation : function(oDD) {
				if (!this.isTypeOfDD(oDD)) {
					return null;
				}
				var el = oDD.getEl(), pos, x1, x2, y1, y2, t, r, b, l;
				try {
					pos = Ext.lib.Dom.getXY(el);
				} catch (e) {
				}
				if (!pos) {
					return null;
				}
				x1 = pos[0];
				x2 = x1 + el.offsetWidth;
				y1 = pos[1];
				y2 = y1 + el.offsetHeight;
				t = y1 - oDD.padding[0];
				r = x2 + oDD.padding[1];
				b = y2 + oDD.padding[2];
				l = x1 - oDD.padding[3];
				return new Ext.lib.Region(t, r, b, l);
			},
			isOverTarget : function(pt, _bb, _bc) {
				var loc = this.locationCache[_bb.id];
				if (!loc || !this.useCache) {
					loc = this.getLocation(_bb);
					this.locationCache[_bb.id] = loc;
				}
				if (!loc) {
					return false;
				}
				_bb.cursorIsOver = loc.contains(pt);
				var dc = this.dragCurrent;
				if (!dc || !dc.getTargetCoord
						|| (!_bc && !dc.constrainX && !dc.constrainY)) {
					return _bb.cursorIsOver;
				}
				_bb.overlap = null;
				var pos = dc.getTargetCoord(pt.x, pt.y);
				var el = dc.getDragEl();
				var _c1 = new Ext.lib.Region(pos.y, pos.x + el.offsetWidth,
						pos.y + el.offsetHeight, pos.x);
				var _c2 = _c1.intersect(loc);
				if (_c2) {
					_bb.overlap = _c2;
					return (_bc) ? true : _bb.cursorIsOver;
				} else {
					return false;
				}
			},
			_onUnload : function(e, me) {
				Ext.dd.DragDropMgr.unregAll();
			},
			unregAll : function() {
				if (this.dragCurrent) {
					this.stopDrag();
					this.dragCurrent = null;
				}
				this._execOnAll("unreg", []);
				for (i in this.elementCache) {
					delete this.elementCache[i];
				}
				this.elementCache = {};
				this.ids = {};
			},
			elementCache : {},
			getElWrapper : function(id) {
				var _c6 = this.elementCache[id];
				if (!_c6 || !_c6.el) {
					_c6 = this.elementCache[id] = new this.ElementWrapper(Ext
							.getDom(id));
				}
				return _c6;
			},
			getElement : function(id) {
				return Ext.getDom(id);
			},
			getCss : function(id) {
				var el = Ext.getDom(id);
				return (el) ? el.style : null;
			},
			ElementWrapper : function(el) {
				this.el = el || null;
				this.id = this.el && el.id;
				this.css = this.el && el.style;
			},
			getPosX : function(el) {
				return Ext.lib.Dom.getX(el);
			},
			getPosY : function(el) {
				return Ext.lib.Dom.getY(el);
			},
			swapNode : function(n1, n2) {
				if (n1.swapNode) {
					n1.swapNode(n2);
				} else {
					var p = n2.parentNode;
					var s = n2.nextSibling;
					if (s == n1) {
						p.insertBefore(n1, n2);
					} else {
						if (n2 == n1.nextSibling) {
							p.insertBefore(n2, n1);
						} else {
							n1.parentNode.replaceChild(n2, n1);
							p.insertBefore(n1, s);
						}
					}
				}
			},
			getScroll : function() {
				var t, l, dde = document.documentElement, db = document.body;
				if (dde && (dde.scrollTop || dde.scrollLeft)) {
					t = dde.scrollTop;
					l = dde.scrollLeft;
				} else {
					if (db) {
						t = db.scrollTop;
						l = db.scrollLeft;
					} else {
					}
				}
				return {
					top : t,
					left : l
				};
			},
			getStyle : function(el, _d6) {
				return Ext.fly(el).getStyle(_d6);
			},
			getScrollTop : function() {
				return this.getScroll().top;
			},
			getScrollLeft : function() {
				return this.getScroll().left;
			},
			moveToEl : function(_d7, _d8) {
				var _d9 = Ext.lib.Dom.getXY(_d8);
				Ext.lib.Dom.setXY(_d7, _d9);
			},
			numericSort : function(a, b) {
				return (a - b);
			},
			_timeoutCount : 0,
			_addListeners : function() {
				var DDM = Ext.dd.DDM;
				if (Ext.lib.Event && document) {
					DDM._onLoad();
				} else {
					if (DDM._timeoutCount > 2000) {
					} else {
						setTimeout(DDM._addListeners, 10);
						if (document && document.body) {
							DDM._timeoutCount += 1;
						}
					}
				}
			},
			handleWasClicked : function(_dd, id) {
				if (this.isHandle(id, _dd.id)) {
					return true;
				} else {
					var p = _dd.parentNode;
					while (p) {
						if (this.isHandle(id, p.id)) {
							return true;
						} else {
							p = p.parentNode;
						}
					}
				}
				return false;
			}
		};
	}();
	Ext.dd.DDM = Ext.dd.DragDropMgr;
	Ext.dd.DDM._addListeners();
}
Ext.dd.DD = function(id, _e1, _e2) {
	if (id) {
		this.init(id, _e1, _e2);
	}
};
Ext.extend(Ext.dd.DD, Ext.dd.DragDrop,
		{
			scroll : true,
			autoOffset : function(_e3, _e4) {
				var x = _e3 - this.startPageX;
				var y = _e4 - this.startPageY;
				this.setDelta(x, y);
			},
			setDelta : function(_e7, _e8) {
				this.deltaX = _e7;
				this.deltaY = _e8;
			},
			setDragElPos : function(_e9, _ea) {
				var el = this.getDragEl();
				this.alignElWithMouse(el, _e9, _ea);
			},
			alignElWithMouse : function(el, _ed, _ee) {
				var _ef = this.getTargetCoord(_ed, _ee);
				var fly = Ext.fly(el);
				if (!this.deltaSetXY) {
					var _f1 = [ _ef.x, _ef.y ];
					fly.setXY(_f1);
					var _f2 = fly.getLeft(true);
					var _f3 = fly.getTop(true);
					this.deltaSetXY = [ _f2 - _ef.x, _f3 - _ef.y ];
				} else {
					fly.setLeftTop(_ef.x + this.deltaSetXY[0], _ef.y
							+ this.deltaSetXY[1]);
				}
				this.cachePosition(_ef.x, _ef.y);
				this.autoScroll(_ef.x, _ef.y, el.offsetHeight, el.offsetWidth);
			},
			cachePosition : function(_f4, _f5) {
				if (_f4) {
					this.lastPageX = _f4;
					this.lastPageY = _f5;
				} else {
					var _f6 = Ext.lib.Dom.getXY(this.getEl());
					this.lastPageX = _f6[0];
					this.lastPageY = _f6[1];
				}
			},
			autoScroll : function(x, y, h, w) {
				if (this.scroll) {
					var _fb = Ext.lib.Dom.getViewWidth();
					var _fc = Ext.lib.Dom.getViewHeight();
					var st = this.DDM.getScrollTop();
					var sl = this.DDM.getScrollLeft();
					var bot = h + y;
					var _100 = w + x;
					var _101 = (_fb + st - y - this.deltaY);
					var _102 = (_fc + sl - x - this.deltaX);
					var _103 = 40;
					var _104 = (document.all) ? 80 : 30;
					if (bot > _fb && _101 < _103) {
						window.scrollTo(sl, st + _104);
					}
					if (y < st && st > 0 && y - st < _103) {
						window.scrollTo(sl, st - _104);
					}
					if (_100 > _fc && _102 < _103) {
						window.scrollTo(sl + _104, st);
					}
					if (x < sl && sl > 0 && x - sl < _103) {
						window.scrollTo(sl - _104, st);
					}
				}
			},
			getTargetCoord : function(_105, _106) {
				var x = _105 - this.deltaX;
				var y = _106 - this.deltaY;
				if (this.constrainX) {
					if (x < this.minX) {
						x = this.minX;
					}
					if (x > this.maxX) {
						x = this.maxX;
					}
				}
				if (this.constrainY) {
					if (y < this.minY) {
						y = this.minY;
					}
					if (y > this.maxY) {
						y = this.maxY;
					}
				}
				x = this.getTick(x, this.xTicks);
				y = this.getTick(y, this.yTicks);
				return {
					x : x,
					y : y
				};
			},
			applyConfig : function() {
				Ext.dd.DD.superclass.applyConfig.call(this);
				this.scroll = (this.config.scroll !== false);
			},
			b4MouseDown : function(e) {
				this.autoOffset(Ext.lib.Event.getPageX(e), Ext.lib.Event
						.getPageY(e));
			},
			b4Drag : function(e) {
				this.setDragElPos(Ext.lib.Event.getPageX(e), Ext.lib.Event
						.getPageY(e));
			},
			toString : function() {
				return ("DD " + this.id);
			}
		});
Ext.dd.DDProxy = function(id, _10c, _10d) {
	if (id) {
		this.init(id, _10c, _10d);
		this.initFrame();
	}
};
Ext.dd.DDProxy.dragElId = "ygddfdiv";
Ext.extend(Ext.dd.DDProxy, Ext.dd.DD, {
	resizeFrame : true,
	centerFrame : false,
	createFrame : function() {
		var self = this;
		var body = document.body;
		if (!body || !body.firstChild) {
			setTimeout(function() {
				self.createFrame();
			}, 50);
			return;
		}
		var div = this.getDragEl();
		if (!div) {
			div = document.createElement("div");
			div.id = this.dragElId;
			var s = div.style;
			s.position = "absolute";
			s.visibility = "hidden";
			s.cursor = "move";
			s.border = "2px solid #aaa";
			s.zIndex = 999;
			body.insertBefore(div, body.firstChild);
		}
	},
	initFrame : function() {
		this.createFrame();
	},
	applyConfig : function() {
		Ext.dd.DDProxy.superclass.applyConfig.call(this);
		this.resizeFrame = (this.config.resizeFrame !== false);
		this.centerFrame = (this.config.centerFrame);
		this.setDragElId(this.config.dragElId || Ext.dd.DDProxy.dragElId);
	},
	showFrame : function(_112, _113) {
		var el = this.getEl();
		var _115 = this.getDragEl();
		var s = _115.style;
		this._resizeProxy();
		if (this.centerFrame) {
			this.setDelta(Math.round(parseInt(s.width, 10) / 2), Math
					.round(parseInt(s.height, 10) / 2));
		}
		this.setDragElPos(_112, _113);
		Ext.fly(_115).show();
	},
	_resizeProxy : function() {
		if (this.resizeFrame) {
			var el = this.getEl();
			Ext.fly(this.getDragEl()).setSize(el.offsetWidth, el.offsetHeight);
		}
	},
	b4MouseDown : function(e) {
		var x = Ext.lib.Event.getPageX(e);
		var y = Ext.lib.Event.getPageY(e);
		this.autoOffset(x, y);
		this.setDragElPos(x, y);
	},
	b4StartDrag : function(x, y) {
		this.showFrame(x, y);
	},
	b4EndDrag : function(e) {
		Ext.fly(this.getDragEl()).hide();
	},
	endDrag : function(e) {
		var lel = this.getEl();
		var del = this.getDragEl();
		del.style.visibility = "";
		lel.style.visibility = "hidden";
		Ext.dd.DDM.moveToEl(lel, del);
		del.style.visibility = "hidden";
		lel.style.visibility = "";
	},
	toString : function() {
		return ("DDProxy " + this.id);
	}
});
Ext.dd.DDTarget = function(id, _122, _123) {
	if (id) {
		this.initTarget(id, _122, _123);
	}
};
Ext.extend(Ext.dd.DDTarget, Ext.dd.DragDrop, {
	toString : function() {
		return ("DDTarget " + this.id);
	}
});

Ext.dd.ScrollManager = function() {
	var _1 = Ext.dd.DragDropMgr;
	var _2 = {};
	var _3 = null;
	var _4 = {};
	var _5 = function(e) {
		_3 = null;
		_7();
	};
	var _8 = function() {
		if (_1.dragCurrent) {
			_1.refreshCache(_1.dragCurrent.groups);
		}
	};
	var _9 = function() {
		if (_1.dragCurrent) {
			var _a = Ext.dd.ScrollManager;
			if (!_a.animate) {
				if (_4.el.scroll(_4.dir, _a.increment)) {
					_8();
				}
			} else {
				_4.el.scroll(_4.dir, _a.increment, true, _a.animDuration, _8);
			}
		}
	};
	var _7 = function() {
		if (_4.id) {
			clearInterval(_4.id);
		}
		_4.id = 0;
		_4.el = null;
		_4.dir = "";
	};
	var _b = function(el, _d) {
		_7();
		_4.el = el;
		_4.dir = _d;
		_4.id = setInterval(_9, Ext.dd.ScrollManager.frequency);
	};
	var _e = function(e, _10) {
		if (_10 || !_1.dragCurrent) {
			return;
		}
		var dds = Ext.dd.ScrollManager;
		if (!_3 || _3 != _1.dragCurrent) {
			_3 = _1.dragCurrent;
			dds.refreshCache();
		}
		var xy = Ext.lib.Event.getXY(e);
		var pt = new Ext.lib.Point(xy[0], xy[1]);
		for ( var id in _2) {
			var el = _2[id], r = el._region;
			if (r.contains(pt) && el.isScrollable()) {
				if (r.bottom - pt.y <= dds.thresh) {
					if (_4.el != el) {
						_b(el, "down");
					}
					return;
				} else {
					if (r.right - pt.x <= dds.thresh) {
						if (_4.el != el) {
							_b(el, "left");
						}
						return;
					} else {
						if (pt.y - r.top <= dds.thresh) {
							if (_4.el != el) {
								_b(el, "up");
							}
							return;
						} else {
							if (pt.x - r.left <= dds.thresh) {
								if (_4.el != el) {
									_b(el, "right");
								}
								return;
							}
						}
					}
				}
			}
		}
		_7();
	};
	_1.fireEvents = _1.fireEvents.createSequence(_e, _1);
	_1.stopDrag = _1.stopDrag.createSequence(_5, _1);
	return {
		register : function(el) {
			if (el instanceof Array) {
				for ( var i = 0, len = el.length; i < len; i++) {
					this.register(el[i]);
				}
			} else {
				el = Ext.get(el);
				_2[el.id] = el;
			}
		},
		unregister : function(el) {
			if (el instanceof Array) {
				for ( var i = 0, len = el.length; i < len; i++) {
					this.unregister(el[i]);
				}
			} else {
				el = Ext.get(el);
				delete _2[el.id];
			}
		},
		thresh : 25,
		increment : 100,
		frequency : 500,
		animate : true,
		animDuration : 0.4,
		refreshCache : function() {
			for ( var id in _2) {
				if (typeof _2[id] == "object") {
					_2[id]._region = _2[id].getRegion();
				}
			}
		}
	};
}();

Ext.dd.Registry = function() {
	var _1 = {};
	var _2 = {};
	var _3 = 0;
	var _4 = function(el, _6) {
		if (typeof el == "string") {
			return el;
		}
		var id = el.id;
		if (!id && _6 !== false) {
			id = "yddgen-" + (++_3);
			el.id = id;
		}
		return id;
	};
	return {
		register : function(el, _9) {
			_9 = _9 || {};
			if (typeof el == "string") {
				el = document.getElementById(el);
			}
			_9.ddel = el;
			_1[_4(el)] = _9;
			if (_9.isHandle !== false) {
				_2[_9.ddel.id] = _9;
			}
			if (_9.handles) {
				var hs = _9.handles;
				for ( var i = 0, _c = hs.length; i < _c; i++) {
					_2[_4(hs[i])] = _9;
				}
			}
		},
		unregister : function(el) {
			var id = _4(el, false);
			var _f = _1[id];
			if (_f) {
				delete _1[id];
				if (_f.handles) {
					var hs = _f.handles;
					for ( var i = 0, len = hs.length; i < len; i++) {
						delete _2[_4(hs[i], false)];
					}
				}
			}
		},
		getHandle : function(id) {
			if (typeof id != "string") {
				id = id.id;
			}
			return _2[id];
		},
		getHandleFromEvent : function(e) {
			var t = Ext.lib.Event.getTarget(e);
			return t ? _2[t.id] : null;
		},
		getTarget : function(id) {
			if (typeof id != "string") {
				id = id.id;
			}
			return _1[id];
		},
		getTargetFromEvent : function(e) {
			var t = Ext.lib.Event.getTarget(e);
			return t ? _1[t.id] || _2[t.id] : null;
		}
	};
}();

Ext.dd.StatusProxy = function(_1) {
	Ext.apply(this, _1);
	this.id = this.id || Ext.id();
	this.el = new Ext.Layer( {
		dh : {
			id : this.id,
			tag : "div",
			cls : "x-dd-drag-proxy " + this.dropNotAllowed,
			children : [ {
				tag : "div",
				cls : "x-dd-drop-icon"
			}, {
				tag : "div",
				cls : "x-dd-drag-ghost"
			} ]
		},
		shadow : !_1 || _1.shadow !== false
	});
	this.ghost = Ext.get(this.el.dom.childNodes[1]);
	this.dropStatus = this.dropNotAllowed;
};
Ext.dd.StatusProxy.prototype = {
	dropAllowed : "x-dd-drop-ok",
	dropNotAllowed : "x-dd-drop-nodrop",
	setStatus : function(_2) {
		_2 = _2 || this.dropNotAllowed;
		if (this.dropStatus != _2) {
			this.el.replaceClass(this.dropStatus, _2);
			this.dropStatus = _2;
		}
	},
	reset : function(_3) {
		this.el.dom.className = "x-dd-drag-proxy " + this.dropNotAllowed;
		this.dropStatus = this.dropNotAllowed;
		if (_3) {
			this.ghost.update("");
		}
	},
	update : function(_4) {
		if (typeof _4 == "string") {
			this.ghost.update(_4);
		} else {
			this.ghost.update("");
			_4.style.margin = "0";
			this.ghost.dom.appendChild(_4);
		}
	},
	getEl : function() {
		return this.el;
	},
	getGhost : function() {
		return this.ghost;
	},
	hide : function(_5) {
		this.el.hide();
		if (_5) {
			this.reset(true);
		}
	},
	stop : function() {
		if (this.anim && this.anim.isAnimated && this.anim.isAnimated()) {
			this.anim.stop();
		}
	},
	show : function() {
		this.el.show();
	},
	sync : function() {
		this.el.sync();
	},
	repair : function(xy, _7, _8) {
		this.callback = _7;
		this.scope = _8;
		if (xy && this.animRepair !== false) {
			this.el.addClass("x-dd-drag-repair");
			this.el.hideUnders(true);
			this.anim = this.el.shift( {
				duration : this.repairDuration || 0.5,
				easing : "easeOut",
				xy : xy,
				stopFx : true,
				callback : this.afterRepair,
				scope : this
			});
		} else {
			this.afterRepair();
		}
	},
	afterRepair : function() {
		this.hide(true);
		if (typeof this.callback == "function") {
			this.callback.call(this.scope || this);
		}
		this.callback == null;
		this.scope == null;
	}
};

Ext.dd.DragSource = function(el, _2) {
	this.el = Ext.get(el);
	this.dragData = {};
	Ext.apply(this, _2);
	if (!this.proxy) {
		this.proxy = new Ext.dd.StatusProxy();
	}
	this.el.on("mouseup", this.handleMouseUp);
	Ext.dd.DragSource.superclass.constructor.call(this, this.el.dom,
			this.ddGroup || this.group, {
				dragElId : this.proxy.id,
				resizeFrame : false,
				isTarget : false,
				scroll : this.scroll === true
			});
	this.dragging = false;
};
Ext
		.extend(
				Ext.dd.DragSource,
				Ext.dd.DDProxy,
				{
					dropAllowed : "x-dd-drop-ok",
					dropNotAllowed : "x-dd-drop-nodrop",
					getDragData : function(e) {
						return this.dragData;
					},
					onDragEnter : function(e, id) {
						var _6 = Ext.dd.DragDropMgr.getDDById(id);
						this.cachedTarget = _6;
						if (this.beforeDragEnter(_6, e, id) !== false) {
							if (_6.isNotifyTarget) {
								var _7 = _6.notifyEnter(this, e, this.dragData);
								this.proxy.setStatus(_7);
							} else {
								this.proxy.setStatus(this.dropAllowed);
							}
							if (this.afterDragEnter) {
								this.afterDragEnter(_6, e, id);
							}
						}
					},
					beforeDragEnter : function(_8, e, id) {
						return true;
					},
					alignElWithMouse : function() {
						Ext.dd.DragSource.superclass.alignElWithMouse.apply(
								this, arguments);
						this.proxy.sync();
					},
					onDragOver : function(e, id) {
						var _d = this.cachedTarget
								|| Ext.dd.DragDropMgr.getDDById(id);
						if (this.beforeDragOver(_d, e, id) !== false) {
							if (_d.isNotifyTarget) {
								var _e = _d.notifyOver(this, e, this.dragData);
								this.proxy.setStatus(_e);
							}
							if (this.afterDragOver) {
								this.afterDragOver(_d, e, id);
							}
						}
					},
					beforeDragOver : function(_f, e, id) {
						return true;
					},
					onDragOut : function(e, id) {
						var _14 = this.cachedTarget
								|| Ext.dd.DragDropMgr.getDDById(id);
						if (this.beforeDragOut(_14, e, id) !== false) {
							if (_14.isNotifyTarget) {
								_14.notifyOut(this, e, this.dragData);
							}
							this.proxy.reset();
							if (this.afterDragOut) {
								this.afterDragOut(_14, e, id);
							}
						}
						this.cachedTarget = null;
					},
					beforeDragOut : function(_15, e, id) {
						return true;
					},
					onDragDrop : function(e, id) {
						var _1a = this.cachedTarget
								|| Ext.dd.DragDropMgr.getDDById(id);
						if (this.beforeDragDrop(_1a, e, id) !== false) {
							if (_1a.isNotifyTarget) {
								if (_1a.notifyDrop(this, e, this.dragData)) {
									this.onValidDrop(_1a, e, id);
								} else {
									this.onInvalidDrop(_1a, e, id);
								}
							} else {
								this.onValidDrop(_1a, e, id);
							}
							if (this.afterDragDrop) {
								this.afterDragDrop(_1a, e, id);
							}
						}
					},
					beforeDragDrop : function(_1b, e, id) {
						return true;
					},
					onValidDrop : function(_1e, e, id) {
						this.hideProxy();
					},
					getRepairXY : function(e, _22) {
						return this.el.getXY();
					},
					onInvalidDrop : function(_23, e, id) {
						this.beforeInvalidDrop(_23, e, id);
						if (this.cachedTarget) {
							if (this.cachedTarget.isNotifyTarget) {
								this.cachedTarget.notifyOut(this, e,
										this.dragData);
							}
							this.cacheTarget = null;
						}
						this.proxy.repair(this.getRepairXY(e, this.dragData),
								this.afterRepair, this);
						if (this.afterInvalidDrop) {
							this.afterInvalidDrop(e, id);
						}
					},
					afterRepair : function() {
						if (Ext.enableFx) {
							this.el.highlight(this.hlColor || "c3daf9");
						}
						this.dragging = false;
					},
					beforeInvalidDrop : function(_26, e, id) {
						return true;
					},
					handleMouseDown : function(e) {
						if (this.dragging) {
							return;
						}
						if (Ext.QuickTips) {
							Ext.QuickTips.disable();
						}
						var _2a = this.getDragData(e);
						if (_2a && this.onBeforeDrag(_2a, e) !== false) {
							this.dragData = _2a;
							this.proxy.stop();
							Ext.dd.DragSource.superclass.handleMouseDown.apply(
									this, arguments);
						}
					},
					handleMouseUp : function(e) {
						if (Ext.QuickTips) {
							Ext.QuickTips.enable();
						}
					},
					onBeforeDrag : function(_2c, e) {
						return true;
					},
					onStartDrag : Ext.emptyFn,
					startDrag : function(e) {
						this.proxy.reset();
						this.dragging = true;
						this.proxy.update("");
						this.onInitDrag(e);
						this.proxy.show();
					},
					onInitDrag : function(e) {
						var _30 = this.el.dom.cloneNode(true);
						_30.id = Ext.id();
						this.proxy.update(_30);
						this.onStartDrag(e);
						return true;
					},
					getProxy : function() {
						return this.proxy;
					},
					hideProxy : function() {
						this.proxy.hide();
						this.proxy.reset(true);
						this.dragging = false;
					},
					triggerCacheRefresh : function() {
						Ext.dd.DDM.refreshCache(this.groups);
					},
					b4EndDrag : function(e) {
					},
					endDrag : function(e) {
						this.onEndDrag(this.dragData, e);
					},
					onEndDrag : function(_33, e) {
					},
					autoOffset : function(x, y) {
						this.setDelta(-12, -20);
					}
				});

Ext.dd.DropTarget = function(el, _2) {
	this.el = Ext.get(el);
	Ext.apply(this, _2);
	if (this.containerScroll) {
		Ext.dd.ScrollManager.register(this.el);
	}
	Ext.dd.DropTarget.superclass.constructor.call(this, this.el.dom,
			this.ddGroup || this.group, {
				isTarget : true
			});
};
Ext.extend(Ext.dd.DropTarget, Ext.dd.DDTarget, {
	dropAllowed : "x-dd-drop-ok",
	dropNotAllowed : "x-dd-drop-nodrop",
	isTarget : true,
	isNotifyTarget : true,
	notifyEnter : function(dd, e, _5) {
		if (this.overClass) {
			this.el.addClass(this.overClass);
		}
		return this.dropAllowed;
	},
	notifyOver : function(dd, e, _8) {
		return this.dropAllowed;
	},
	notifyOut : function(dd, e, _b) {
		if (this.overClass) {
			this.el.removeClass(this.overClass);
		}
	},
	notifyDrop : function(dd, e, _e) {
		return false;
	}
});

Ext.dd.DragZone = function(el, _2) {
	Ext.dd.DragZone.superclass.constructor.call(this, el, _2);
	if (this.containerScroll) {
		Ext.dd.ScrollManager.register(this.el);
	}
};
Ext.extend(Ext.dd.DragZone, Ext.dd.DragSource, {
	getDragData : function(e) {
		return Ext.dd.Registry.getHandleFromEvent(e);
	},
	onInitDrag : function(e) {
		this.proxy.update(this.dragData.ddel.cloneNode(true));
		this.onStartDrag(e);
		return true;
	},
	afterRepair : function() {
		if (Ext.enableFx) {
			Ext.Element.fly(this.dragData.ddel).highlight(
					this.hlColor || "c3daf9");
		}
		this.dragging = false;
	},
	getRepairXY : function(e) {
		return Ext.Element.fly(this.dragData.ddel).getXY();
	}
});

Ext.dd.DropZone = function(el, _2) {
	Ext.dd.DropZone.superclass.constructor.call(this, el, _2);
};
Ext.extend(Ext.dd.DropZone, Ext.dd.DropTarget, {
	getTargetFromEvent : function(e) {
		return Ext.dd.Registry.getTargetFromEvent(e);
	},
	onNodeEnter : function(n, dd, e, _7) {
	},
	onNodeOver : function(n, dd, e, _b) {
		return this.dropAllowed;
	},
	onNodeOut : function(n, dd, e, _f) {
	},
	onNodeDrop : function(n, dd, e, _13) {
		return false;
	},
	onContainerOver : function(dd, e, _16) {
		return this.dropNotAllowed;
	},
	onContainerDrop : function(dd, e, _19) {
		return false;
	},
	notifyEnter : function(dd, e, _1c) {
		return this.dropNotAllowed;
	},
	notifyOver : function(dd, e, _1f) {
		var n = this.getTargetFromEvent(e);
		if (!n) {
			if (this.lastOverNode) {
				this.onNodeOut(this.lastOverNode, dd, e, _1f);
				this.lastOverNode = null;
			}
			return this.onContainerOver(dd, e, _1f);
		}
		if (this.lastOverNode != n) {
			if (this.lastOverNode) {
				this.onNodeOut(this.lastOverNode, dd, e, _1f);
			}
			this.onNodeEnter(n, dd, e, _1f);
			this.lastOverNode = n;
		}
		return this.onNodeOver(n, dd, e, _1f);
	},
	notifyOut : function(dd, e, _23) {
		if (this.lastOverNode) {
			this.onNodeOut(this.lastOverNode, dd, e, _23);
			this.lastOverNode = null;
		}
	},
	notifyDrop : function(dd, e, _26) {
		if (this.lastOverNode) {
			this.onNodeOut(this.lastOverNode, dd, e, _26);
			this.lastOverNode = null;
		}
		var n = this.getTargetFromEvent(e);
		return n ? this.onNodeDrop(n, dd, e, _26) : this.onContainerDrop(dd, e,
				_26);
	},
	triggerCacheRefresh : function() {
		Ext.dd.DDM.refreshCache(this.groups);
	}
});

Ext.data.SortTypes = {
	none : function(s) {
		return s;
	},
	stripTagsRE : /<\/?[^>]+>/gi,
	asText : function(s) {
		return String(s).replace(this.stripTagsRE, "");
	},
	asUCText : function(s) {
		return String(s).toUpperCase().replace(this.stripTagsRE, "");
	},
	asUCString : function(s) {
		return String(s).toUpperCase();
	},
	asDate : function(s) {
		if (!s) {
			return 0;
		}
		if (s instanceof Date) {
			return s.getTime();
		}
		return Date.parse(String(s));
	},
	asFloat : function(s) {
		var _7 = parseFloat(String(s).replace(/,/g, ""));
		if (isNaN(_7)) {
			_7 = 0;
		}
		return _7;
	},
	asInt : function(s) {
		var _9 = parseInt(String(s).replace(/,/g, ""));
		if (isNaN(_9)) {
			_9 = 0;
		}
		return _9;
	}
};

Ext.data.Record = function(_1, id) {
	this.id = (id || id === 0) ? id : ++Ext.data.Record.AUTO_ID;
	this.data = _1;
};
Ext.data.Record.create = function(o) {
	var f = function() {
		f.superclass.constructor.apply(this, arguments);
	};
	Ext.extend(f, Ext.data.Record);
	var p = f.prototype;
	p.fields = new Ext.util.MixedCollection(false, function(_6) {
		return _6.name;
	});
	for ( var i = 0, _8 = o.length; i < _8; i++) {
		p.fields.add(new Ext.data.Field(o[i]));
	}
	f.getField = function(_9) {
		return p.fields.get(_9);
	};
	return f;
};
Ext.data.Record.AUTO_ID = 1000;
Ext.data.Record.EDIT = "edit";
Ext.data.Record.REJECT = "reject";
Ext.data.Record.COMMIT = "commit";
Ext.data.Record.prototype = {
	dirty : false,
	editing : false,
	error : null,
	modified : null,
	join : function(_a) {
		this.store = _a;
	},
	set : function(_b, _c) {
		if (this.data[_b] == _c) {
			return;
		}
		this.dirty = true;
		if (!this.modified) {
			this.modified = {};
		}
		if (typeof this.modified[_b] == "undefined") {
			this.modified[_b] = this.data[_b];
		}
		this.data[_b] = _c;
		if (!this.editing) {
			this.store.afterEdit(this);
		}
	},
	get : function(_d) {
		return this.data[_d];
	},
	beginEdit : function() {
		this.editing = true;
		this.modified = {};
	},
	cancelEdit : function() {
		this.editing = false;
		delete this.modified;
	},
	endEdit : function() {
		this.editing = false;
		if (this.dirty && this.store) {
			this.store.afterEdit(this);
		}
	},
	reject : function() {
		var m = this.modified;
		for ( var n in m) {
			if (typeof m[n] != "function") {
				this.data[n] = m[n];
			}
		}
		this.dirty = false;
		delete this.modified;
		this.editing = false;
		if (this.store) {
			this.store.afterReject(this);
		}
	},
	commit : function() {
		this.dirty = false;
		delete this.modified;
		this.editing = false;
		if (this.store) {
			this.store.afterCommit(this);
		}
	},
	hasError : function() {
		return this.error != null;
	},
	clearError : function() {
		this.error = null;
	}
};

Ext.data.Store = function(_1) {
	this.data = new Ext.util.MixedCollection(false);
	this.data.getKey = function(o) {
		return o.id;
	};
	this.baseParams = {};
	this.paramNames = {
		"start" : "start",
		"limit" : "limit",
		"sort" : "sort",
		"dir" : "dir"
	};
	Ext.apply(this, _1);
	if (this.reader && !this.recordType) {
		this.recordType = this.reader.recordType;
	}
	this.fields = this.recordType.prototype.fields;
	this.modified = [];
	this.events = {
		datachanged : true,
		add : true,
		remove : true,
		update : true,
		clear : true,
		beforeload : true,
		load : true,
		loadexception : true
	};
	if (this.proxy) {
		this.relayEvents(this.proxy, [ "loadexception" ]);
	}
	this.sortToggle = {};
	Ext.data.Store.superclass.constructor.call(this);
};
Ext.extend(Ext.data.Store, Ext.util.Observable, {
	remoteSort : false,
	lastOptions : null,
	add : function(_3) {
		_3 = [].concat(_3);
		for ( var i = 0, _5 = _3.length; i < _5; i++) {
			_3[i].join(this);
		}
		var _6 = this.data.length;
		this.data.addAll(_3);
		this.fireEvent("add", this, _3, _6);
	},
	remove : function(_7) {
		var _8 = this.data.indexOf(_7);
		this.data.removeAt(_8);
		this.fireEvent("remove", this, _7, _8);
	},
	removeAll : function() {
		this.data.clear();
		this.fireEvent("clear", this);
	},
	insert : function(_9, _a) {
		_a = [].concat(_a);
		for ( var i = 0, _c = _a.length; i < _c; i++) {
			this.data.insert(_9, _a[i]);
			_a[i].join(this);
		}
		this.fireEvent("add", this, _a, _9);
	},
	indexOf : function(_d) {
		return this.data.indexOf(_d);
	},
	indexOfId : function(id) {
		return this.data.indexOfKey(id);
	},
	getById : function(id) {
		return this.data.key(id);
	},
	getAt : function(_10) {
		return this.data.itemAt(_10);
	},
	getRange : function(_11, end) {
		return this.data.getRange(_11, end);
	},
	storeOptions : function(o) {
		o = Ext.apply( {}, o);
		delete o.callback;
		delete o.scope;
		this.lastOptions = o;
	},
	load : function(_14) {
		_14 = _14 || {};
		if (this.fireEvent("beforeload", this, _14) !== false) {
			this.storeOptions(_14);
			var p = Ext.apply(_14.params || {}, this.baseParams);
			if (this.sortInfo && this.remoteSort) {
				var pn = this.paramNames;
				p[pn["sort"]] = this.sortInfo.field;
				p[pn["dir"]] = this.sortInfo.direction;
			}
			this.proxy.load(p, this.reader, this.loadRecords, this, _14);
		}
	},
	reload : function(_17) {
		this.load(Ext.applyIf(_17 || {}, this.lastOptions));
	},
	loadRecords : function(o, _19, _1a) {
		if (!o || _1a === false) {
			if (_1a !== false) {
				this.fireEvent("load", this, [], _19);
			}
			if (_19.callback) {
				_19.callback.call(_19.scope || this, [], _19, false);
			}
			return;
		}
		var r = o.records, t = o.totalRecords || r.length;
		for ( var i = 0, len = r.length; i < len; i++) {
			r[i].join(this);
		}
		if (!_19 || _19.add !== true) {
			this.data.clear();
			this.data.addAll(r);
			this.totalLength = t;
			this.applySort();
			this.fireEvent("datachanged", this);
		} else {
			this.totalLength = Math.max(t, this.data.length + r.length);
			this.data.addAll(r);
		}
		this.fireEvent("load", this, r, _19);
		if (_19.callback) {
			_19.callback.call(_19.scope || this, r, _19, true);
		}
	},
	loadData : function(o, _20) {
		var r = this.reader.readRecords(o);
		this.loadRecords(r, {
			add : _20
		}, true);
	},
	getCount : function() {
		return this.data.length || 0;
	},
	getTotalCount : function() {
		return this.totalLength || 0;
	},
	getSortState : function() {
		return this.sortInfo;
	},
	applySort : function() {
		if (this.sortInfo && !this.remoteSort) {
			var s = this.sortInfo, f = s.field;
			var st = this.fields.get(f).sortType;
			var fn = function(r1, r2) {
				var v1 = st(r1.data[f]), v2 = st(r2.data[f]);
				return v1 > v2 ? 1 : (v1 < v2 ? -1 : 0);
			};
			this.data.sort(s.direction, fn);
			if (this.snapshot && this.snapshot != this.data) {
				this.snapshot.sort(s.direction, fn);
			}
		}
	},
	setDefaultSort : function(_2a, dir) {
		this.sortInfo = {
			field : _2a,
			direction : dir ? dir.toUpperCase() : "ASC"
		};
	},
	sort : function(_2c, dir) {
		var f = this.fields.get(_2c);
		if (!dir) {
			if (this.sortInfo && this.sortInfo.field == f.name) {
				dir = (this.sortToggle[f.name] || "ASC").toggle("ASC", "DESC");
			} else {
				dir = f.sortDir;
			}
		}
		this.sortToggle[f.name] = dir;
		this.sortInfo = {
			field : f.name,
			direction : dir
		};
		if (!this.remoteSort) {
			this.applySort();
			this.fireEvent("datachanged", this);
		} else {
			this.load(this.lastOptions);
		}
	},
	each : function(fn, _30) {
		this.data.each(fn, _30);
	},
	getModifiedRecords : function() {
		return this.modified;
	},
	filter : function(_31, _32) {
		if (!_32.exec) {
			_32 = String(_32);
			if (_32.length == 0) {
				return this.clearFilter();
			}
			_32 = new RegExp("^" + Ext.escapeRe(_32), "i");
		}
		this.filterBy(function(r) {
			return _32.test(r.data[_31]);
		});
	},
	filterBy : function(fn, _35) {
		var _36 = this.snapshot || this.data;
		this.snapshot = _36;
		this.data = _36.filterBy(fn, _35);
		this.fireEvent("datachanged", this);
	},
	clearFilter : function() {
		if (this.snapshot && this.snapshot != this.data) {
			this.data = this.snapshot;
			delete this.snapshot;
			this.fireEvent("datachanged", this);
		}
	},
	afterEdit : function(_37) {
		if (this.modified.indexOf(_37) == -1) {
			this.modified.push(_37);
		}
		this.fireEvent("update", this, _37, Ext.data.Record.EDIT);
	},
	afterReject : function(_38) {
		this.modified.remove(_38);
		this.fireEvent("update", this, _38, Ext.data.Record.REJECT);
	},
	afterCommit : function(_39) {
		this.modified.remove(_39);
		this.fireEvent("update", this, _39, Ext.data.Record.COMMIT);
	},
	commitChanges : function() {
		var m = this.modified.slice(0);
		this.modified = [];
		for ( var i = 0, len = m.length; i < len; i++) {
			m[i].commit();
		}
	},
	rejectChanges : function() {
		var m = this.modified.slice(0);
		this.modified = [];
		for ( var i = 0, len = m.length; i < len; i++) {
			m[i].reject();
		}
	}
});

Ext.data.SimpleStore = function(_1) {
	Ext.data.SimpleStore.superclass.constructor.call(this, {
		reader : new Ext.data.ArrayReader( {
			id : _1.id
		}, Ext.data.Record.create(_1.fields)),
		proxy : new Ext.data.MemoryProxy(_1.data)
	});
	this.load();
};
Ext.extend(Ext.data.SimpleStore, Ext.data.Store);

Ext.data.Connection = function(_1) {
	Ext.apply(this, _1);
	this.events = {
		"beforerequest" : true,
		"requestcomplete" : true,
		"requestexception" : true
	};
	Ext.data.Connection.superclass.constructor.call(this);
};
Ext.extend(Ext.data.Connection, Ext.util.Observable, {
	timeout : 30000,
	request : function(_2) {
		if (this.fireEvent("beforerequest", this, _2) !== false) {
			var p = _2.params;
			if (typeof p == "object") {
				p = Ext.urlEncode(Ext.apply(_2.params, this.extraParams));
			}
			var cb = {
				success : this.handleResponse,
				failure : this.handleFailure,
				scope : this,
				argument : {
					options : _2
				},
				timeout : this.timeout
			};
			var _5 = _2.method || this.method || (p ? "POST" : "GET");
			var _6 = _2.url || this.url;
			if (this.autoAbort !== false) {
				this.abort();
			}
			if (_5 == "GET" && p) {
				_6 += (_6.indexOf("?") != -1 ? "&" : "?") + p;
				p = "";
			}
			this.transId = Ext.lib.Ajax.request(_5, _6, cb, p);
		} else {
			if (typeof _2.callback == "function") {
				_2.callback.call(_2.scope || window, _2, null, null);
			}
		}
	},
	isLoading : function() {
		return this.transId ? true : false;
	},
	abort : function() {
		if (this.isLoading()) {
			Ext.lib.Ajax.abort(this.transId);
		}
	},
	handleResponse : function(_7) {
		this.transId = false;
		var _8 = _7.argument.options;
		this.fireEvent("requestcomplete", this, _7, _8);
		if (typeof _8.callback == "function") {
			_8.callback.call(_8.scope || window, _8, true, _7);
		}
	},
	handleFailure : function(_9, e) {
		this.transId = false;
		var _b = _9.argument.options;
		this.fireEvent("requestexception", this, _9, _b, e);
		if (typeof _b.callback == "function") {
			_b.callback.call(_b.scope || window, _b, false, _9);
		}
	}
});

Ext.data.Field = function(_1) {
	if (typeof _1 == "string") {
		_1 = {
			name : _1
		};
	}
	Ext.apply(this, _1);
	if (!this.type) {
		this.type = "auto";
	}
	var st = Ext.data.SortTypes;
	if (typeof this.sortType == "string") {
		this.sortType = st[this.sortType];
	}
	if (!this.sortType) {
		switch (this.type) {
		case "string":
			this.sortType = st.asUCString;
			break;
		case "date":
			this.sortType = st.asDate;
			break;
		default:
			this.sortType = st.none;
		}
	}
	var _3 = /[\$,%]/g;
	if (!this.convert) {
		var cv, _5 = this.dateFormat;
		switch (this.type) {
		case "":
		case "auto":
		case undefined:
			cv = function(v) {
				return v;
			};
			break;
		case "string":
			cv = function(v) {
				return String(v);
			};
			break;
		case "int":
			cv = function(v) {
				return v !== undefined && v !== null && v !== "" ? parseInt(
						String(v).replace(_3, ""), 10) : "";
			};
			break;
		case "float":
			cv = function(v) {
				return v !== undefined && v !== null && v !== "" ? parseFloat(
						String(v).replace(_3, ""), 10) : "";
			};
			break;
		case "bool":
		case "boolean":
			cv = function(v) {
				return v === true || v === "true" || v == 1;
			};
			break;
		case "date":
			cv = function(v) {
				if (!v) {
					return "";
				}
				if (v instanceof Date) {
					return v;
				}
				if (_5) {
					if (_5 == "timestamp") {
						return new Date(v * 1000);
					}
					return Date.parseDate(v, _5);
				}
				var _c = Date.parse(v);
				return _c ? new Date(_c) : null;
			};
			break;
		}
		this.convert = cv;
	}
};
Ext.data.Field.prototype = {
	dateFormat : null,
	defaultValue : "",
	mapping : null,
	sortType : null,
	sortDir : "ASC"
};

Ext.data.DataReader = function(_1, _2) {
	this.meta = _1;
	this.recordType = _2 instanceof Array ? Ext.data.Record.create(_2) : _2;
};
Ext.data.DataReader.prototype = {};

Ext.data.DataProxy = function() {
	this.events = {
		beforeload : true,
		load : true,
		loadexception : true
	};
	Ext.data.DataProxy.superclass.constructor.call(this);
};
Ext.extend(Ext.data.DataProxy, Ext.util.Observable);

Ext.data.MemoryProxy = function(_1) {
	Ext.data.MemoryProxy.superclass.constructor.call(this);
	this.data = _1;
};
Ext.extend(Ext.data.MemoryProxy, Ext.data.DataProxy, {
	load : function(_2, _3, _4, _5, _6) {
		_2 = _2 || {};
		var _7;
		try {
			_7 = _3.readRecords(this.data);
		} catch (e) {
			this.fireEvent("loadexception", this, _6, null, e);
			_4.call(_5, null, _6, false);
			return;
		}
		_4.call(_5, _7, _6, true);
	},
	update : function(_8, _9) {
	}
});

Ext.data.HttpProxy = function(_1) {
	Ext.data.HttpProxy.superclass.constructor.call(this);
	this.conn = _1.events ? _1 : new Ext.data.Connection(_1);
};
Ext.extend(Ext.data.HttpProxy, Ext.data.DataProxy, {
	getConnection : function() {
		return this.conn;
	},
	load : function(_2, _3, _4, _5, _6) {
		if (this.fireEvent("beforeload", this, _2) !== false) {
			this.conn.request( {
				params : _2 || {},
				request : {
					callback : _4,
					scope : _5,
					arg : _6
				},
				reader : _3,
				callback : this.loadResponse,
				scope : this
			});
		} else {
			_4.call(_5 || this, null, _6, false);
		}
	},
	loadResponse : function(o, _8, _9) {
		if (!_8) {
			this.fireEvent("loadexception", this, o, _9);
			o.request.callback
					.call(o.request.scope, null, o.request.arg, false);
			return;
		}
		var _a;
		try {
			_a = o.reader.read(_9);
		} catch (e) {
			this.fireEvent("loadexception", this, o, _9, e);
			o.request.callback
					.call(o.request.scope, null, o.request.arg, false);
			return;
		}
		this.fireEvent("load", this, o, o.request.arg);
		o.request.callback.call(o.request.scope, _a, o.request.arg, true);
	},
	update : function(_b) {
	},
	updateResponse : function(_c) {
	}
});

Ext.data.ScriptTagProxy = function(_1) {
	Ext.data.ScriptTagProxy.superclass.constructor.call(this);
	Ext.apply(this, _1);
	this.head = document.getElementsByTagName("head")[0];
};
Ext.data.ScriptTagProxy.TRANS_ID = 1000;
Ext.extend(Ext.data.ScriptTagProxy, Ext.data.DataProxy,
		{
			timeout : 30000,
			callbackParam : "callback",
			nocache : true,
			load : function(_2, _3, _4, _5, _6) {
				if (this.fireEvent("beforeload", this, _2) !== false) {
					var p = Ext.urlEncode(Ext.apply(_2, this.extraParams));
					var _8 = this.url;
					_8 += (_8.indexOf("?") != -1 ? "&" : "?") + p;
					if (this.nocache) {
						_8 += "&_dc=" + (new Date().getTime());
					}
					var _9 = ++Ext.data.ScriptTagProxy.TRANS_ID;
					var _a = {
						id : _9,
						cb : "stcCallback" + _9,
						scriptId : "stcScript" + _9,
						params : _2,
						arg : _6,
						url : _8,
						callback : _4,
						scope : _5,
						reader : _3
					};
					var _b = this;
					window[_a.cb] = function(o) {
						_b.handleResponse(o, _a);
					};
					_8 += String.format("&{0}={1}", this.callbackParam, _a.cb);
					if (this.autoAbort !== false) {
						this.abort();
					}
					_a.timeoutId = this.handleFailure.defer(this.timeout, this,
							[ _a ]);
					var _d = document.createElement("script");
					_d.setAttribute("src", _8);
					_d.setAttribute("type", "text/javascript");
					_d.setAttribute("id", _a.scriptId);
					this.head.appendChild(_d);
					this.trans = _a;
				} else {
					_4.call(_5 || this, null, _6, false);
				}
			},
			isLoading : function() {
				return this.trans ? true : false;
			},
			abort : function() {
				if (this.isLoading()) {
					this.destroyTrans(this.trans);
				}
			},
			destroyTrans : function(_e, _f) {
				this.head.removeChild(document.getElementById(_e.scriptId));
				clearTimeout(_e.timeoutId);
				if (_f) {
					window[_e.cb] = undefined;
					try {
						delete window[_e.cb];
					} catch (e) {
					}
				} else {
					window[_e.cb] = function() {
						window[_e.cb] = undefined;
						try {
							delete window[_e.cb];
						} catch (e) {
						}
					};
				}
			},
			handleResponse : function(o, _11) {
				this.trans = false;
				this.destroyTrans(_11, true);
				var _12;
				try {
					_12 = _11.reader.readRecords(o);
				} catch (e) {
					this.fireEvent("loadexception", this, o, _11.arg, e);
					_11.callback
							.call(_11.scope || window, null, _11.arg, false);
					return;
				}
				this.fireEvent("load", this, o, _11.arg);
				_11.callback.call(_11.scope || window, _12, _11.arg, true);
			},
			handleFailure : function(_13) {
				this.trans = false;
				this.destroyTrans(_13, false);
				this.fireEvent("loadexception", this, null, _13.arg);
				_13.callback.call(_13.scope || window, null, _13.arg, false);
			}
		});

Ext.data.JsonReader = function(_1, _2) {
	Ext.data.JsonReader.superclass.constructor.call(this, _1, _2);
};
Ext
		.extend(
				Ext.data.JsonReader,
				Ext.data.DataReader,
				{
					read : function(_3) {
						var _4 = _3.responseText;
						var o = eval("(" + _4 + ")");
						if (!o) {
							throw {
								message : "JsonReader.read: Json object not found"
							};
						}
						return this.readRecords(o);
					},
					simpleAccess : function(_6, _7) {
						return _6[_7];
					},
					getJsonAccessor : function() {
						var re = /[\[\.]/;
						return function(_9) {
							try {
								return (re.test(_9)) ? new Function("obj",
										"return obj." + _9) : function(_a) {
									return _a[_9];
								};
							} catch (e) {
							}
							return Ext.emptyFn;
						};
					}(),
					readRecords : function(o) {
						this.jsonData = o;
						var s = this.meta, _d = this.recordType, f = _d.prototype.fields, fi = f.items, fl = f.length;
						if (!this.ef) {
							if (s.totalProperty) {
								this.getTotal = this
										.getJsonAccessor(s.totalProperty);
							}
							if (s.successProperty) {
								this.getSuccess = this
										.getJsonAccessor(s.successProperty);
							}
							this.getRoot = s.root ? this
									.getJsonAccessor(s.root) : function(p) {
								return p;
							};
							if (s.id) {
								var g = this.getJsonAccessor(s.id);
								this.getId = function(rec) {
									var r = g(rec);
									return (r === undefined || r === "") ? null
											: r;
								};
							} else {
								this.getId = function() {
									return null;
								};
							}
							this.ef = [];
							for ( var i = 0; i < fl; i++) {
								f = fi[i];
								var map = (f.mapping !== undefined && f.mapping !== null) ? f.mapping
										: f.name;
								this.ef[i] = this.getJsonAccessor(map);
							}
						}
						var _17 = this.getRoot(o), c = _17.length, _19 = c, _1a = true;
						if (s.totalProperty) {
							var v = parseInt(this.getTotal(o), 10);
							if (!isNaN(v)) {
								_19 = v;
							}
						}
						if (s.successProperty) {
							var v = this.getSuccess(o);
							if (v === false || v === "false") {
								_1a = false;
							}
						}
						var _1c = [];
						for ( var i = 0; i < c; i++) {
							var n = _17[i];
							var _1e = {};
							var id = this.getId(n);
							for ( var j = 0; j < fl; j++) {
								f = fi[j];
								var v = this.ef[j](n);
								_1e[f.name] = f.convert((v !== undefined) ? v
										: f.defaultValue);
							}
							var _21 = new _d(_1e, id);
							_21.json = n;
							_1c[i] = _21;
						}
						return {
							success : _1a,
							records : _1c,
							totalRecords : _19
						};
					}
				});

Ext.data.XmlReader = function(_1, _2) {
	Ext.data.XmlReader.superclass.constructor.call(this, _1, _2);
};
Ext.extend(Ext.data.XmlReader, Ext.data.DataReader, {
	read : function(_3) {
		var _4 = _3.responseXML;
		if (!_4) {
			throw {
				message : "XmlReader.read: XML Document not available"
			};
		}
		return this.readRecords(_4);
	},
	readRecords : function(_5) {
		this.xmlData = _5;
		var _6 = _5.documentElement || _5;
		var q = Ext.DomQuery;
		var _8 = this.recordType, _9 = _8.prototype.fields;
		var _a = this.meta.id;
		var _b = 0, _c = true;
		if (this.meta.totalRecords) {
			_b = q.selectNumber(this.meta.totalRecords, _6, 0);
		}
		if (this.meta.success) {
			var sv = q.selectValue(this.meta.success, _6, true);
			_c = sv !== false && sv !== "false";
		}
		var _e = [];
		var ns = q.select(this.meta.record, _6);
		for ( var i = 0, len = ns.length; i < len; i++) {
			var n = ns[i];
			var _13 = {};
			var id = _a ? q.selectValue(_a, n) : undefined;
			for ( var j = 0, _16 = _9.length; j < _16; j++) {
				var f = _9.items[j];
				var v = q.selectValue(f.mapping || f.name, n, f.defaultValue);
				v = f.convert(v);
				_13[f.name] = v;
			}
			var _19 = new _8(_13, id);
			_19.node = n;
			_e[_e.length] = _19;
		}
		return {
			success : _c,
			records : _e,
			totalRecords : _b || _e.length
		};
	}
});

Ext.data.ArrayReader = function(_1, _2) {
	Ext.data.ArrayReader.superclass.constructor.call(this, _1, _2);
};
Ext
		.extend(Ext.data.ArrayReader, Ext.data.JsonReader,
				{
					readRecords : function(o) {
						var _4 = this.meta ? this.meta.id : null;
						var _5 = this.recordType, _6 = _5.prototype.fields;
						var _7 = [];
						var _8 = o;
						for ( var i = 0; i < _8.length; i++) {
							var n = _8[i];
							var _b = {};
							var id = ((_4 || _4 === 0) && n[_4] !== undefined
									&& n[_4] !== "" ? n[_4] : null);
							for ( var j = 0, _e = _6.length; j < _e; j++) {
								var f = _6.items[j];
								var k = f.mapping !== undefined
										&& f.mapping !== null ? f.mapping : j;
								var v = n[k] !== undefined ? n[k]
										: f.defaultValue;
								v = f.convert(v);
								_b[f.name] = v;
							}
							var _12 = new _5(_b, id);
							_12.json = n;
							_7[_7.length] = _12;
						}
						return {
							records : _7,
							totalRecords : _7.length
						};
					}
				});

Ext.data.Tree = function(_1) {
	this.nodeHash = {};
	this.root = null;
	if (_1) {
		this.setRootNode(_1);
	}
	this.events = {
		"append" : true,
		"remove" : true,
		"move" : true,
		"insert" : true,
		"beforeappend" : true,
		"beforeremove" : true,
		"beforemove" : true,
		"beforeinsert" : true
	};
	Ext.data.Tree.superclass.constructor.call(this);
};
Ext.extend(Ext.data.Tree, Ext.util.Observable, {
	pathSeparator : "/",
	getRootNode : function() {
		return this.root;
	},
	setRootNode : function(_2) {
		this.root = _2;
		_2.ownerTree = this;
		_2.isRoot = true;
		this.registerNode(_2);
		return _2;
	},
	getNodeById : function(id) {
		return this.nodeHash[id];
	},
	registerNode : function(_4) {
		this.nodeHash[_4.id] = _4;
	},
	unregisterNode : function(_5) {
		delete this.nodeHash[_5.id];
	},
	toString : function() {
		return "[Tree" + (this.id ? " " + this.id : "") + "]";
	}
});
Ext.data.Node = function(_6) {
	this.attributes = _6 || {};
	this.leaf = this.attributes.leaf;
	this.blocked = this.attributes.blocked;
	this.id = this.attributes.id;
	if (!this.id) {
		this.id = Ext.id(null, "ynode-");
		this.attributes.id = this.id;
	}
	this.childNodes = [];
	if (!this.childNodes.indexOf) {
		this.childNodes.indexOf = function(o) {
			for ( var i = 0, _9 = this.length; i < _9; i++) {
				if (this[i] == o) {
					return i;
				}
			}
			return -1;
		};
	}
	this.parentNode = null;
	this.firstChild = null;
	this.lastChild = null;
	this.previousSibling = null;
	this.nextSibling = null;
	this.events = {
		"append" : true,
		"remove" : true,
		"move" : true,
		"insert" : true,
		"beforeappend" : true,
		"beforeremove" : true,
		"beforemove" : true,
		"beforeinsert" : true
	};
	this.listeners = this.attributes.listeners;
	Ext.data.Node.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.data.Node,
				Ext.util.Observable,
				{
					fireEvent : function(_a) {
						if (Ext.data.Node.superclass.fireEvent.apply(this,
								arguments) === false) {
							return false;
						}
						var ot = this.getOwnerTree();
						if (ot) {
							if (ot.fireEvent.apply(this.ownerTree, arguments) === false) {
								return false;
							}
						}
						return true;
					},
					isLeaf : function() {
						return this.leaf === true;
					},
					isBlocked : function() {
						return this.blocked === true;
					},
					setFirstChild : function(_c) {
						this.firstChild = _c;
					},
					setLastChild : function(_d) {
						this.lastChild = _d;
					},
					isLast : function() {
						return (!this.parentNode ? true
								: this.parentNode.lastChild == this);
					},
					isFirst : function() {
						return (!this.parentNode ? true
								: this.parentNode.firstChild == this);
					},
					hasChildNodes : function() {
						return !this.isLeaf() && this.childNodes.length > 0;
					},
					appendChild : function(_e) {
						var _f = false;
						if (_e instanceof Array) {
							_f = _e;
						} else {
							if (arguments.length > 1) {
								_f = arguments;
							}
						}
						if (_f) {
							for ( var i = 0, len = _f.length; i < len; i++) {
								this.appendChild(_f[i]);
							}
						} else {
							if (this.fireEvent("beforeappend", this.ownerTree,
									this, _e) === false) {
								return false;
							}
							var _12 = this.childNodes.length;
							var _13 = _e.parentNode;
							if (_13) {
								if (_e.fireEvent("beforemove", _e
										.getOwnerTree(), _e, _13, this, _12) === false) {
									return false;
								}
								_13.removeChild(_e);
							}
							_12 = this.childNodes.length;
							if (_12 == 0) {
								this.setFirstChild(_e);
							}
							this.childNodes.push(_e);
							_e.parentNode = this;
							var ps = this.childNodes[_12 - 1];
							if (ps) {
								_e.previousSibling = ps;
								ps.nextSibling = _e;
							} else {
								_e.previousSibling = null;
							}
							_e.nextSibling = null;
							this.setLastChild(_e);
							_e.setOwnerTree(this.getOwnerTree());
							this.fireEvent("append", this.ownerTree, this, _e,
									_12);
							if (_13) {
								_e.fireEvent("move", this.ownerTree, _e, _13,
										this, _12);
							}
							return _e;
						}
					},
					removeChild : function(_15) {
						var _16 = this.childNodes.indexOf(_15);
						if (_16 == -1) {
							return false;
						}
						if (this.fireEvent("beforeremove", this.ownerTree,
								this, _15) === false) {
							return false;
						}
						this.childNodes.splice(_16, 1);
						if (_15.previousSibling) {
							_15.previousSibling.nextSibling = _15.nextSibling;
						}
						if (_15.nextSibling) {
							_15.nextSibling.previousSibling = _15.previousSibling;
						}
						if (this.firstChild == _15) {
							this.setFirstChild(_15.nextSibling);
						}
						if (this.lastChild == _15) {
							this.setLastChild(_15.previousSibling);
						}
						_15.setOwnerTree(null);
						_15.parentNode = null;
						_15.previousSibling = null;
						_15.nextSibling = null;
						this.fireEvent("remove", this.ownerTree, this, _15);
						return _15;
					},
					insertBefore : function(_17, _18) {
						if (!_18) {
							return this.appendChild(_17);
						}
						if (_17 == _18) {
							return false;
						}
						if (this.fireEvent("beforeinsert", this.ownerTree,
								this, _17, _18) === false) {
							return false;
						}
						var _19 = this.childNodes.indexOf(_18);
						var _1a = _17.parentNode;
						var _1b = _19;
						if (_1a == this && this.childNodes.indexOf(_17) < _19) {
							_1b--;
						}
						if (_1a) {
							if (_17.fireEvent("beforemove", _17.getOwnerTree(),
									_17, _1a, this, _19, _18) === false) {
								return false;
							}
							_1a.removeChild(_17);
						}
						if (_1b == 0) {
							this.setFirstChild(_17);
						}
						this.childNodes.splice(_1b, 0, _17);
						_17.parentNode = this;
						var ps = this.childNodes[_1b - 1];
						if (ps) {
							_17.previousSibling = ps;
							ps.nextSibling = _17;
						} else {
							_17.previousSibling = null;
						}
						_17.nextSibling = _18;
						_18.previousSibling = _17;
						_17.setOwnerTree(this.getOwnerTree());
						this
								.fireEvent("insert", this.ownerTree, this, _17,
										_18);
						if (_1a) {
							_17.fireEvent("move", this.ownerTree, _17, _1a,
									this, _1b, _18);
						}
						return _17;
					},
					item : function(_1d) {
						return this.childNodes[_1d];
					},
					replaceChild : function(_1e, _1f) {
						this.insertBefore(_1e, _1f);
						this.removeChild(_1f);
						return _1f;
					},
					indexOf : function(_20) {
						return this.childNodes.indexOf(_20);
					},
					getOwnerTree : function() {
						if (!this.ownerTree) {
							var p = this;
							while (p) {
								if (p.ownerTree) {
									this.ownerTree = p.ownerTree;
									break;
								}
								p = p.parentNode;
							}
						}
						return this.ownerTree;
					},
					getDepth : function() {
						var _22 = 0;
						var p = this;
						while (p.parentNode) {
							++_22;
							p = p.parentNode;
						}
						return _22;
					},
					setOwnerTree : function(_24) {
						if (_24 != this.ownerTree) {
							if (this.ownerTree) {
								this.ownerTree.unregisterNode(this);
							}
							this.ownerTree = _24;
							var cs = this.childNodes;
							for ( var i = 0, len = cs.length; i < len; i++) {
								cs[i].setOwnerTree(_24);
							}
							if (_24) {
								_24.registerNode(this);
							}
						}
					},
					getPath : function(_28) {
						_28 = _28 || "id";
						var p = this.parentNode;
						var b = [ this.attributes[_28] ];
						while (p) {
							b.unshift(p.attributes[_28]);
							p = p.parentNode;
						}
						var sep = this.getOwnerTree().pathSeparator;
						return sep + b.join(sep);
					},
					bubble : function(fn, _2d, _2e) {
						var p = this;
						while (p) {
							if (fn.call(_2d || p, _2e || p) === false) {
								break;
							}
							p = p.parentNode;
						}
					},
					cascade : function(fn, _31, _32) {
						if (fn.call(_31 || this, _32 || this) !== false) {
							var cs = this.childNodes;
							for ( var i = 0, len = cs.length; i < len; i++) {
								cs[i].cascade(fn, _31, _32);
							}
						}
					},
					eachChild : function(fn, _37, _38) {
						var cs = this.childNodes;
						for ( var i = 0, len = cs.length; i < len; i++) {
							if (fn.call(_37 || this, _38 || cs[i]) === false) {
								break;
							}
						}
					},
					findChild : function(_3c, _3d) {
						var cs = this.childNodes;
						for ( var i = 0, len = cs.length; i < len; i++) {
							if (cs[i].attributes[_3c] == _3d) {
								return cs[i];
							}
						}
						return null;
					},
					findChildBy : function(fn, _42) {
						var cs = this.childNodes;
						for ( var i = 0, len = cs.length; i < len; i++) {
							if (fn.call(_42 || cs[i], cs[i]) === true) {
								return cs[i];
							}
						}
						return null;
					},
					sort : function(fn, _47) {
						var cs = this.childNodes;
						var len = cs.length;
						if (len > 0) {
							var _4a = _47 ? function() {
								fn.apply(_47, arguments);
							} : fn;
							cs.sort(_4a);
							for ( var i = 0; i < len; i++) {
								var n = cs[i];
								n.previousSibling = cs[i - 1];
								n.nextSibling = cs[i + 1];
								if (i == 0) {
									this.setFirstChild(n);
								}
								if (i == len - 1) {
									this.setLastChild(n);
								}
							}
						}
					},
					contains : function(_4d) {
						return _4d.isAncestor(this);
					},
					isAncestor : function(_4e) {
						var p = this.parentNode;
						while (p) {
							if (p == _4e) {
								return true;
							}
							p = p.parentNode;
						}
						return false;
					},
					toString : function() {
						return "[Node" + (this.id ? " " + this.id : "") + "]";
					}
				});

Ext.ComponentMgr = function() {
	var _1 = new Ext.util.MixedCollection();
	return {
		register : function(c) {
			_1.add(c);
		},
		unregister : function(c) {
			_1.remove(c);
		},
		get : function(id) {
			return _1.get(id);
		},
		onAvailable : function(id, fn, _7) {
			_1.on("add", function(_8, o) {
				if (o.id == id) {
					fn.call(_7 || o, o);
					_1.un("add", fn, _7);
				}
			});
		}
	};
}();
Ext.Component = function(_a) {
	_a = _a || {};
	if (_a.tagName || _a.dom || typeof _a == "string") {
		_a = {
			el : _a,
			id : _a.id || _a
		};
	}
	Ext.apply(this, _a);
	this.addEvents( {
		disable : true,
		enable : true,
		beforeshow : true,
		show : true,
		beforehide : true,
		hide : true,
		beforerender : true,
		render : true,
		beforedestroy : true,
		destroy : true
	});
	if (!this.id) {
		this.id = "ext-comp-" + (++Ext.Component.AUTO_ID);
	}
	Ext.ComponentMgr.register(this);
	Ext.Component.superclass.constructor.call(this);
};
Ext.Component.AUTO_ID = 1000;
Ext.extend(Ext.Component, Ext.util.Observable, {
	hidden : false,
	disabled : false,
	disabledClass : "x-item-disabled",
	rendered : false,
	ctype : "Ext.Component",
	actionMode : "el",
	getActionEl : function() {
		return this[this.actionMode];
	},
	render : function(_b) {
		if (!this.rendered && this.fireEvent("beforerender", this) !== false) {
			this.container = Ext.get(_b);
			this.rendered = true;
			this.onRender(this.container);
			if (this.cls) {
				this.el.addClass(this.cls);
				delete this.cls;
			}
			this.fireEvent("render", this);
			if (this.hidden) {
				this.hide();
			}
			if (this.disabled) {
				this.disable();
			}
			this.afterRender(this.container);
		}
	},
	onRender : function(ct) {
		this.el = Ext.get(this.el);
		ct.dom.appendChild(this.el.dom);
	},
	getAutoCreate : function() {
		var _d = typeof this.autoCreate == "object" ? this.autoCreate : Ext
				.apply( {}, this.defaultAutoCreate);
		if (this.id && !_d.id) {
			_d.id = this.id;
		}
		return _d;
	},
	afterRender : Ext.emptyFn,
	destroy : function() {
		if (this.fireEvent("beforedestroy", this) !== false) {
			this.purgeListeners();
			if (this.rendered) {
				this.el.removeAllListeners();
				this.el.remove();
				if (this.actionMode == "container") {
					this.container.remove();
				}
			}
			this.onDestroy();
			Ext.ComponentMgr.unregister(this);
			this.fireEvent("destroy", this);
		}
	},
	onDestroy : function() {
	},
	getEl : function() {
		return this.el;
	},
	focus : function(_e) {
		if (this.rendered) {
			this.el.focus();
			if (_e === true) {
				this.el.dom.select();
			}
		}
	},
	blur : function() {
		if (this.rendered) {
			this.el.blur();
		}
	},
	disable : function() {
		if (this.rendered) {
			this.getActionEl().addClass(this.disabledClass);
			this.el.dom.disabled = true;
		}
		this.disabled = true;
		this.fireEvent("disable", this);
	},
	enable : function() {
		if (this.rendered) {
			this.getActionEl().removeClass(this.disabledClass);
			this.el.dom.disabled = false;
		}
		this.disabled = false;
		this.fireEvent("enable", this);
	},
	setDisabled : function(_f) {
		this[_f ? "disable" : "enable"]();
	},
	show : function() {
		if (this.fireEvent("beforeshow", this) !== false) {
			this.hidden = false;
			if (this.rendered) {
				this.onShow();
			}
			this.fireEvent("show", this);
		}
	},
	onShow : function() {
		var st = this.getActionEl().dom.style;
		st.display = "";
		st.visibility = "visible";
	},
	hide : function() {
		if (this.fireEvent("beforehide", this) !== false) {
			this.hidden = true;
			if (this.rendered) {
				this.onHide();
			}
			this.fireEvent("hide", this);
		}
	},
	onHide : function() {
		this.getActionEl().dom.style.display = "none";
	},
	setVisible : function(_11) {
		if (_11) {
			this.show();
		} else {
			this.hide();
		}
	}
});

(function() {
	Ext.Layer = function(_1, _2) {
		_1 = _1 || {};
		var dh = Ext.DomHelper;
		var cp = _1.parentEl, _5 = cp ? Ext.getDom(cp) : document.body;
		if (_2) {
			this.dom = Ext.getDom(_2);
		}
		if (!this.dom) {
			var o = _1.dh || {
				tag : "div",
				cls : "x-layer"
			};
			this.dom = dh.append(_5, o);
		}
		if (_1.cls) {
			this.addClass(_1.cls);
		}
		this.constrain = _1.constrain !== false;
		this.visibilityMode = Ext.Element.VISIBILITY;
		if (_1.id) {
			this.id = this.dom.id = _1.id;
		} else {
			this.id = Ext.id(this.dom);
		}
		var _7 = (_1.zindex || parseInt(this.getStyle("z-index"), 10)) || 11000;
		this.position("absolute", _7);
		if (_1.shadow) {
			this.shadowOffset = _1.shadowOffset || 4;
			this.shadow = new Ext.Shadow( {
				offset : this.shadowOffset,
				mode : _1.shadow
			});
		} else {
			this.shadowOffset = 0;
		}
		if (_1.shim !== false && Ext.useShims) {
			this.shim = this.createShim();
			this.shim.setOpacity(0);
			this.shim.position("absolute", _7 - 2);
		}
		this.useDisplay = _1.useDisplay;
		this.hide();
	};
	var _8 = Ext.Element.prototype;
	Ext
			.extend(
					Ext.Layer,
					Ext.Element,
					{
						sync : function(_9) {
							var sw = this.shadow, sh = this.shim;
							if (!this.updating && this.isVisible()
									&& (sw || sh)) {
								var w = this.getWidth(), h = this.getHeight();
								var l = this.getLeft(true), t = this
										.getTop(true);
								if (sw) {
									if (_9 && !sw.isVisible()) {
										sw.show(this);
									} else {
										sw.realign(l, t, w, h);
									}
									if (sh) {
										if (_9) {
											sh.show();
										}
										var a = sw.adjusts, s = sh.dom.style;
										s.left = (l + a.l) + "px";
										s.top = (t + a.t) + "px";
										s.width = (w + a.w) + "px";
										s.height = (h + a.h) + "px";
									}
								} else {
									if (sh) {
										if (_9) {
											sh.show();
										}
										sh.setSize(w, h);
										sh.setLeftTop(l, t);
									}
								}
							}
						},
						destroy : function() {
							if (this.shim) {
								this.shim.remove();
							}
							if (this.shadow) {
								this.shadow.hide();
							}
							this.removeAllListeners();
							this.remove();
						},
						beginUpdate : function() {
							this.updating = true;
						},
						endUpdate : function() {
							this.updating = false;
							this.sync(true);
						},
						hideUnders : function(_12) {
							if (this.shadow) {
								this.shadow.hide();
							}
							if (this.shim) {
								this.shim.hide();
								if (_12) {
									this.shim.setLeftTop(-10000, -10000);
								}
							}
						},
						constrainXY : function() {
							if (this.constrain) {
								var vw = Ext.lib.Dom.getViewWidth(), vh = Ext.lib.Dom
										.getViewHeight();
								var s = Ext.get(document).getScroll();
								xy = this.getXY();
								var x = xy[0], y = xy[1];
								var w = this.dom.offsetWidth
										+ this.shadowOffset, h = this.dom.offsetHeight
										+ this.shadowOffset;
								var _1a = false;
								if ((x + w) > vw + s.left) {
									x = vw - w - this.shadowOffset;
									_1a = true;
								}
								if ((y + h) > vh + s.top) {
									y = vh - h - this.shadowOffset;
									_1a = true;
								}
								if (x < s.left) {
									x = s.left;
									_1a = true;
								}
								if (y < s.top) {
									y = s.top;
									_1a = true;
								}
								if (_1a) {
									if (this.avoidY) {
										var ay = this.avoidY;
										if (y <= ay && (y + h) >= ay) {
											y = ay - h - 5;
										}
									}
									xy = [ x, y ];
									this.lastXY = xy;
									_8.setXY.call(this, xy);
									this.sync();
								}
							}
						},
						showAction : function() {
							if (this.useDisplay === true) {
								this.setDisplayed("");
							} else {
								if (this.lastXY) {
									_8.setXY.call(this, this.lastXY);
								}
							}
						},
						hideAction : function() {
							if (this.useDisplay === true) {
								this.setDisplayed(false);
							} else {
								this.setLeftTop(-10000, -10000);
							}
						},
						setVisible : function(v, a, d, c, e) {
							this.showAction();
							if (a && v) {
								var cb = function() {
									this.sync(true);
									if (c) {
										c();
									}
								}.createDelegate(this);
								_8.setVisible.call(this, true, true, d, cb, e);
							} else {
								if (!v) {
									this.hideUnders(true);
								}
								var cb = c;
								if (a) {
									cb = function() {
										this.hideAction();
										if (c) {
											c();
										}
									}.createDelegate(this);
								}
								_8.setVisible.call(this, v, a, d, cb, e);
								if (v) {
									this.sync(true);
								} else {
									if (!a) {
										this.hideAction();
									}
								}
							}
						},
						beforeFx : function() {
							this.beforeAction();
							return Ext.Layer.superclass.beforeFx.apply(this,
									arguments);
						},
						afterFx : function() {
							Ext.Layer.superclass.afterFx.apply(this, arguments);
							this.sync(this.isVisible());
						},
						beforeAction : function() {
							if (!this.updating && this.shadow) {
								this.shadow.hide();
							}
						},
						setXY : function(xy, a, d, c, e) {
							this.fixDisplay();
							this.beforeAction();
							this.lastXY = xy;
							var cb = this.createCB(c);
							_8.setXY.call(this, xy, a, d, cb, e);
							if (!a) {
								cb();
							}
						},
						createCB : function(c) {
							var el = this;
							return function() {
								el.constrainXY();
								el.sync(true);
								if (c) {
									c();
								}
							};
						},
						setX : function(x, a, d, c, e) {
							this.setXY( [ x, this.getY() ], a, d, c, e);
						},
						setY : function(y, a, d, c, e) {
							this.setXY( [ this.getX(), y ], a, d, c, e);
						},
						setSize : function(w, h, a, d, c, e) {
							this.beforeAction();
							var cb = this.createCB(c);
							_8.setSize.call(this, w, h, a, d, cb, e);
							if (!a) {
								cb();
							}
						},
						setWidth : function(w, a, d, c, e) {
							this.beforeAction();
							var cb = this.createCB(c);
							_8.setWidth.call(this, w, a, d, cb, e);
							if (!a) {
								cb();
							}
						},
						setHeight : function(h, a, d, c, e) {
							this.beforeAction();
							var cb = this.createCB(c);
							_8.setHeight.call(this, h, a, d, cb, e);
							if (!a) {
								cb();
							}
						},
						setBounds : function(x, y, w, h, a, d, c, e) {
							this.beforeAction();
							var cb = this.createCB(c);
							if (!a) {
								_8.setXY.call(this, [ x, y ]);
								_8.setSize.call(this, w, h, a, d, cb, e);
								cb();
							} else {
								_8.setBounds
										.call(this, x, y, w, h, a, d, cb, e);
							}
							return this;
						},
						setZIndex : function(_50) {
							this.setStyle("z-index", _50 + 2);
							if (this.shadow) {
								this.shadow.setZIndex(_50 + 1);
							}
							if (this.shim) {
								this.shim.setStyle("z-index", _50);
							}
						}
					});
})();

Ext.Shadow = function(_1) {
	Ext.apply(this, _1);
	if (typeof this.mode != "string") {
		this.mode = this.defaultMode;
	}
	var o = this.offset, a = {
		h : 0
	};
	switch (this.mode.toLowerCase()) {
	case "drop":
		a.w = 0;
		a.l = a.t = o;
		break;
	case "sides":
		a.w = (o * 2);
		a.l = -o;
		a.t = o;
		break;
	case "frame":
		a.w = a.h = (o * 2);
		a.l = a.t = -o;
		break;
	}
	this.adjusts = a;
};
Ext.Shadow.prototype = {
	offset : 4,
	defaultMode : "drop",
	show : function(_4) {
		_4 = Ext.get(_4);
		if (!this.el) {
			this.el = Ext.Shadow.Pool.pull();
			if (this.el.dom.nextSibling != _4.dom) {
				this.el.insertBefore(_4);
			}
		}
		this.el.setStyle("z-index", this.zIndex
				|| parseInt(_4.getStyle("z-index"), 10) - 1);
		this.realign(_4.getLeft(true), _4.getTop(true), _4.getWidth(), _4
				.getHeight());
		this.el.dom.style.display = "block";
	},
	isVisible : function() {
		return this.el ? true : false;
	},
	realign : function(l, t, w, h) {
		var a = this.adjusts, d = this.el.dom, s = d.style;
		s.left = (l + a.l) + "px";
		s.top = (t + a.t) + "px";
		var sw = (w + a.w), sh = (h + a.h), _e = sw + "px", _f = sh + "px";
		if (s.width != _e || s.height != _f) {
			s.width = _e;
			s.height = _f;
			var cn = d.childNodes;
			var sww = Math.max(0, (sw - 12)) + "px";
			cn[0].childNodes[1].style.width = sww;
			cn[1].childNodes[1].style.width = sww;
			cn[2].childNodes[1].style.width = sww;
			cn[1].style.height = Math.max(0, (sh - 12)) + "px";
		}
	},
	hide : function() {
		if (this.el) {
			this.el.dom.style.display = "none";
			Ext.Shadow.Pool.push(this.el);
			delete this.el;
		}
	},
	setZIndex : function(z) {
		this.zIndex = z;
		if (this.el) {
			this.el.setStyle("z-index", z);
		}
	}
};
Ext.Shadow.Pool = function() {
	var p = [];
	var _14 = "<div class=\"x-shadow\"><div class=\"xst\"><div class=\"xstl\"></div><div class=\"xstc\"></div><div class=\"xstr\"></div></div><div class=\"xsc\"><div class=\"xsml\"></div><div class=\"xsmc\"></div><div class=\"xsmr\"></div></div><div class=\"xsb\"><div class=\"xsbl\"></div><div class=\"xsbc\"></div><div class=\"xsbr\"></div></div></div>";
	return {
		pull : function() {
			var sh = p.shift();
			if (!sh) {
				sh = Ext.get(Ext.DomHelper.insertHtml("beforeBegin",
						document.body.firstChild, _14));
				if (Ext.isIE && !Ext.isIE7) {
					sh.setOpacity(0.3);
				}
			}
			return sh;
		},
		push : function(sh) {
			p.push(sh);
		}
	};
}();

Ext.View = function(_1, _2, _3) {
	this.el = Ext.get(_1, true);
	if (typeof _2 == "string") {
		_2 = new Ext.Template(_2);
	}
	_2.compile();
	this.tpl = _2;
	Ext.apply(this, _3);
	this.events = {
		"beforeclick" : true,
		"click" : true,
		"dblclick" : true,
		"contextmenu" : true,
		"selectionchange" : true,
		"beforeselect" : true
	};
	this.el.on( {
		"click" : this.onClick,
		"dblclick" : this.onDblClick,
		"contextmenu" : this.onContextMenu,
		scope : this
	});
	this.selections = [];
	this.nodes = [];
	this.cmp = new Ext.CompositeElementLite( []);
	if (this.store) {
		this.setStore(this.store, true);
	}
	Ext.View.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.View,
				Ext.util.Observable,
				{
					selectedClass : "x-view-selected",
					emptyText : "",
					getEl : function() {
						return this.el;
					},
					refresh : function() {
						var t = this.tpl;
						this.clearSelections();
						this.el.update("");
						var _5 = [];
						var _6 = this.store.getRange();
						if (_6.length < 1) {
							this.el.update(this.emptyText);
							return;
						}
						for ( var i = 0, _8 = _6.length; i < _8; i++) {
							var _9 = this.prepareData(_6[i].data, i, _6[i]);
							_5[_5.length] = t.apply(_9);
						}
						this.el.update(_5.join(""));
						this.nodes = this.el.dom.childNodes;
						this.updateIndexes(0);
					},
					prepareData : function(_a, _b) {
						return _a;
					},
					onUpdate : function(ds, _d) {
						this.clearSelections();
						var _e = this.store.indexOf(_d);
						var n = this.nodes[_e];
						this.tpl.insertBefore(n, this.prepareData(_d.data));
						n.parentNode.removeChild(n);
						this.updateIndexes(_e, _e);
					},
					onAdd : function(ds, _11, _12) {
						this.clearSelections();
						if (this.nodes.length == 0) {
							this.refresh();
							return;
						}
						var n = this.nodes[_12];
						for ( var i = 0, len = _11.length; i < len; i++) {
							var d = this.prepareData(_11[i].data);
							if (n) {
								this.tpl.insertBefore(n, d);
							} else {
								this.tpl.append(this.el, d);
							}
						}
						this.updateIndexes(_12);
					},
					onRemove : function(ds, _18, _19) {
						this.clearSelections();
						this.el.dom.removeChild(this.nodes[_19]);
						this.updateIndexes(_19);
					},
					refreshNode : function(_1a) {
						this.onUpdate(this.store, this.store.getAt(_1a));
					},
					updateIndexes : function(_1b, _1c) {
						var ns = this.nodes;
						_1b = _1b || 0;
						_1c = _1c || ns.length - 1;
						for ( var i = _1b; i <= _1c; i++) {
							ns[i].nodeIndex = i;
						}
					},
					setStore : function(_1f, _20) {
						if (!_20 && this.store) {
							this.store.un("datachanged", this.refresh);
							this.store.un("add", this.onAdd);
							this.store.un("remove", this.onRemove);
							this.store.un("update", this.onUpdate);
							this.store.un("clear", this.refresh);
						}
						if (_1f) {
							_1f.on("datachanged", this.refresh, this);
							_1f.on("add", this.onAdd, this);
							_1f.on("remove", this.onRemove, this);
							_1f.on("update", this.onUpdate, this);
							_1f.on("clear", this.refresh, this);
						}
						this.store = _1f;
						this.refresh();
					},
					findItemFromChild : function(_21) {
						var el = this.el.dom;
						if (!_21 || _21.parentNode == el) {
							return _21;
						}
						var p = _21.parentNode;
						while (p && p != el) {
							if (p.parentNode == el) {
								return p;
							}
							p = p.parentNode;
						}
						return null;
					},
					onClick : function(e) {
						var _25 = this.findItemFromChild(e.getTarget());
						if (_25) {
							var _26 = this.indexOf(_25);
							if (this.onItemClick(_25, _26, e) !== false) {
								this.fireEvent("click", this, _26, _25, e);
							}
						} else {
							this.clearSelections();
						}
					},
					onContextMenu : function(e) {
						var _28 = this.findItemFromChild(e.getTarget());
						if (_28) {
							this.fireEvent("contextmenu", this, this
									.indexOf(_28), _28, e);
						}
					},
					onDblClick : function(e) {
						var _2a = this.findItemFromChild(e.getTarget());
						if (_2a) {
							this.fireEvent("dblclick", this, this.indexOf(_2a),
									_2a, e);
						}
					},
					onItemClick : function(_2b, _2c, e) {
						if (this.fireEvent("beforeclick", this, _2c, _2b, e) === false) {
							return false;
						}
						if (this.multiSelect || this.singleSelect) {
							if (this.multiSelect && e.shiftKey
									&& this.lastSelection) {
								this.select(this.getNodes(this
										.indexOf(this.lastSelection), _2c),
										false);
							} else {
								this.select(_2b, this.multiSelect && e.ctrlKey);
								this.lastSelection = _2b;
							}
							e.preventDefault();
						}
						return true;
					},
					getSelectionCount : function() {
						return this.selections.length;
					},
					getSelectedNodes : function() {
						return this.selections;
					},
					getSelectedIndexes : function() {
						var _2e = [], s = this.selections;
						for ( var i = 0, len = s.length; i < len; i++) {
							_2e.push(s[i].nodeIndex);
						}
						return _2e;
					},
					clearSelections : function(_32) {
						if (this.nodes
								&& (this.multiSelect || this.singleSelect)
								&& this.selections.length > 0) {
							this.cmp.elements = this.selections;
							this.cmp.removeClass(this.selectedClass);
							this.selections = [];
							if (!_32) {
								this.fireEvent("selectionchange", this,
										this.selections);
							}
						}
					},
					isSelected : function(_33) {
						var s = this.selections;
						if (s.length < 1) {
							return false;
						}
						_33 = this.getNode(_33);
						return s.indexOf(_33) !== -1;
					},
					select : function(_35, _36, _37) {
						if (_35 instanceof Array) {
							if (!_36) {
								this.clearSelections(true);
							}
							for ( var i = 0, len = _35.length; i < len; i++) {
								this.select(_35[i], true, true);
							}
						} else {
							var _3a = this.getNode(_35);
							if (_3a && !this.isSelected(_3a)) {
								if (!_36) {
									this.clearSelections(true);
								}
								if (this.fireEvent("beforeselect", this, _3a,
										this.selections) !== false) {
									Ext.fly(_3a).addClass(this.selectedClass);
									this.selections.push(_3a);
									if (!_37) {
										this.fireEvent("selectionchange", this,
												this.selections);
									}
								}
							}
						}
					},
					getNode : function(_3b) {
						if (typeof _3b == "string") {
							return document.getElementById(_3b);
						} else {
							if (typeof _3b == "number") {
								return this.nodes[_3b];
							}
						}
						return _3b;
					},
					getNodes : function(_3c, end) {
						var ns = this.nodes;
						_3c = _3c || 0;
						end = typeof end == "undefined" ? ns.length - 1 : end;
						var _3f = [];
						if (_3c <= end) {
							for ( var i = _3c; i <= end; i++) {
								_3f.push(ns[i]);
							}
						} else {
							for ( var i = _3c; i >= end; i--) {
								_3f.push(ns[i]);
							}
						}
						return _3f;
					},
					indexOf : function(_41) {
						_41 = this.getNode(_41);
						if (typeof _41.nodeIndex == "number") {
							return _41.nodeIndex;
						}
						var ns = this.nodes;
						for ( var i = 0, len = ns.length; i < len; i++) {
							if (ns[i] == _41) {
								return i;
							}
						}
						return -1;
					}
				});
Ext.JsonView = function(_45, tpl, _47) {
	Ext.JsonView.superclass.constructor.call(this, _45, tpl, _47);
	var um = this.el.getUpdateManager();
	um.setRenderer(this);
	um.on("update", this.onLoad, this);
	um.on("failure", this.onLoadException, this);
	this.events["beforerender"] = true;
	this.events["load"] = true;
	this.events["loadexception"] = true;
};
Ext.extend(Ext.JsonView, Ext.View, {
	jsonRoot : "",
	refresh : function() {
		this.clearSelections();
		this.el.update("");
		var _49 = [];
		var o = this.jsonData;
		if (o && o.length > 0) {
			for ( var i = 0, len = o.length; i < len; i++) {
				var _4d = this.prepareData(o[i], i, o);
				_49[_49.length] = this.tpl.apply(_4d);
			}
		} else {
			_49.push(this.emptyText);
		}
		this.el.update(_49.join(""));
		this.nodes = this.el.dom.childNodes;
		this.updateIndexes(0);
	},
	load : function() {
		var um = this.el.getUpdateManager();
		um.update.apply(um, arguments);
	},
	render : function(el, _50) {
		this.clearSelections();
		this.el.update("");
		var o;
		try {
			o = Ext.util.JSON.decode(_50.responseText);
			if (this.jsonRoot) {
				o = eval("o." + this.jsonRoot);
			}
		} catch (e) {
		}
		this.jsonData = o;
		this.beforeRender();
		this.refresh();
	},
	getCount : function() {
		return this.jsonData ? this.jsonData.length : 0;
	},
	getNodeData : function(_52) {
		if (_52 instanceof Array) {
			var _53 = [];
			for ( var i = 0, len = _52.length; i < len; i++) {
				_53.push(this.getNodeData(_52[i]));
			}
			return _53;
		}
		return this.jsonData[this.indexOf(_52)] || null;
	},
	beforeRender : function() {
		this.snapshot = this.jsonData;
		if (this.sortInfo) {
			this.sort.apply(this, this.sortInfo);
		}
		this.fireEvent("beforerender", this, this.jsonData);
	},
	onLoad : function(el, o) {
		this.fireEvent("load", this, this.jsonData, o);
	},
	onLoadException : function(el, o) {
		this.fireEvent("loadexception", this, o);
	},
	filter : function(_5a, _5b) {
		if (this.jsonData) {
			var _5c = [];
			var ss = this.snapshot;
			if (typeof _5b == "string") {
				var _5e = _5b.length;
				if (_5e == 0) {
					this.clearFilter();
					return;
				}
				_5b = _5b.toLowerCase();
				for ( var i = 0, len = ss.length; i < len; i++) {
					var o = ss[i];
					if (o[_5a].substr(0, _5e).toLowerCase() == _5b) {
						_5c.push(o);
					}
				}
			} else {
				if (_5b.exec) {
					for ( var i = 0, len = ss.length; i < len; i++) {
						var o = ss[i];
						if (_5b.test(o[_5a])) {
							_5c.push(o);
						}
					}
				} else {
					return;
				}
			}
			this.jsonData = _5c;
			this.refresh();
		}
	},
	filterBy : function(fn, _63) {
		if (this.jsonData) {
			var _64 = [];
			var ss = this.snapshot;
			for ( var i = 0, len = ss.length; i < len; i++) {
				var o = ss[i];
				if (fn.call(_63 || this, o)) {
					_64.push(o);
				}
			}
			this.jsonData = _64;
			this.refresh();
		}
	},
	clearFilter : function() {
		if (this.snapshot && this.jsonData != this.snapshot) {
			this.jsonData = this.snapshot;
			this.refresh();
		}
	},
	sort : function(_69, dir, _6b) {
		this.sortInfo = Array.prototype.slice.call(arguments, 0);
		if (this.jsonData) {
			var p = _69;
			var dsc = dir && dir.toLowerCase() == "desc";
			var f = function(o1, o2) {
				var v1 = _6b ? _6b(o1[p]) : o1[p];
				var v2 = _6b ? _6b(o2[p]) : o2[p];
				if (v1 < v2) {
					return dsc ? +1 : -1;
				} else {
					if (v1 > v2) {
						return dsc ? -1 : +1;
					} else {
						return 0;
					}
				}
			};
			this.jsonData.sort(f);
			this.refresh();
			if (this.jsonData != this.snapshot) {
				this.snapshot.sort(f);
			}
		}
	}
});

Ext.JsonView = function(_1, _2, _3) {
	Ext.JsonView.superclass.constructor.call(this, _1, _2, _3);
	var um = this.el.getUpdateManager();
	um.setRenderer(this);
	um.on("update", this.onLoad, this);
	um.on("failure", this.onLoadException, this);
	this.events["beforerender"] = true;
	this.events["load"] = true;
	this.events["loadexception"] = true;
};
Ext.extend(Ext.JsonView, Ext.View, {
	jsonRoot : "",
	refresh : function() {
		this.clearSelections();
		this.el.update("");
		var _5 = [];
		var o = this.jsonData;
		if (o && o.length > 0) {
			for ( var i = 0, _8 = o.length; i < _8; i++) {
				var _9 = this.prepareData(o[i], i, o);
				_5[_5.length] = this.tpl.apply(_9);
			}
		} else {
			_5.push(this.emptyText);
		}
		this.el.update(_5.join(""));
		this.nodes = this.el.dom.childNodes;
		this.updateIndexes(0);
	},
	load : function() {
		var um = this.el.getUpdateManager();
		um.update.apply(um, arguments);
	},
	render : function(el, _c) {
		this.clearSelections();
		this.el.update("");
		var o;
		try {
			o = Ext.util.JSON.decode(_c.responseText);
			if (this.jsonRoot) {
				o = eval("o." + this.jsonRoot);
			}
		} catch (e) {
		}
		this.jsonData = o;
		this.beforeRender();
		this.refresh();
	},
	getCount : function() {
		return this.jsonData ? this.jsonData.length : 0;
	},
	getNodeData : function(_e) {
		if (_e instanceof Array) {
			var _f = [];
			for ( var i = 0, len = _e.length; i < len; i++) {
				_f.push(this.getNodeData(_e[i]));
			}
			return _f;
		}
		return this.jsonData[this.indexOf(_e)] || null;
	},
	beforeRender : function() {
		this.snapshot = this.jsonData;
		if (this.sortInfo) {
			this.sort.apply(this, this.sortInfo);
		}
		this.fireEvent("beforerender", this, this.jsonData);
	},
	onLoad : function(el, o) {
		this.fireEvent("load", this, this.jsonData, o);
	},
	onLoadException : function(el, o) {
		this.fireEvent("loadexception", this, o);
	},
	filter : function(_16, _17) {
		if (this.jsonData) {
			var _18 = [];
			var ss = this.snapshot;
			if (typeof _17 == "string") {
				var _1a = _17.length;
				if (_1a == 0) {
					this.clearFilter();
					return;
				}
				_17 = _17.toLowerCase();
				for ( var i = 0, len = ss.length; i < len; i++) {
					var o = ss[i];
					if (o[_16].substr(0, _1a).toLowerCase() == _17) {
						_18.push(o);
					}
				}
			} else {
				if (_17.exec) {
					for ( var i = 0, len = ss.length; i < len; i++) {
						var o = ss[i];
						if (_17.test(o[_16])) {
							_18.push(o);
						}
					}
				} else {
					return;
				}
			}
			this.jsonData = _18;
			this.refresh();
		}
	},
	filterBy : function(fn, _1f) {
		if (this.jsonData) {
			var _20 = [];
			var ss = this.snapshot;
			for ( var i = 0, len = ss.length; i < len; i++) {
				var o = ss[i];
				if (fn.call(_1f || this, o)) {
					_20.push(o);
				}
			}
			this.jsonData = _20;
			this.refresh();
		}
	},
	clearFilter : function() {
		if (this.snapshot && this.jsonData != this.snapshot) {
			this.jsonData = this.snapshot;
			this.refresh();
		}
	},
	sort : function(_25, dir, _27) {
		this.sortInfo = Array.prototype.slice.call(arguments, 0);
		if (this.jsonData) {
			var p = _25;
			var dsc = dir && dir.toLowerCase() == "desc";
			var f = function(o1, o2) {
				var v1 = _27 ? _27(o1[p]) : o1[p];
				var v2 = _27 ? _27(o2[p]) : o2[p];
				if (v1 < v2) {
					return dsc ? +1 : -1;
				} else {
					if (v1 > v2) {
						return dsc ? -1 : +1;
					} else {
						return 0;
					}
				}
			};
			this.jsonData.sort(f);
			this.refresh();
			if (this.jsonData != this.snapshot) {
				this.snapshot.sort(f);
			}
		}
	}
});

Ext.ColorPalette = function(_1) {
	Ext.ColorPalette.superclass.constructor.call(this, _1);
	this.addEvents( {
		select : true
	});
	if (this.handler) {
		this.on("select", this.handler, this.scope, true);
	}
};
Ext
		.extend(
				Ext.ColorPalette,
				Ext.Component,
				{
					itemCls : "x-color-palette",
					value : null,
					ctype : "Ext.ColorPalette",
					colors : [ "000000", "993300", "333300", "003300",
							"003366", "000080", "333399", "333333", "800000",
							"FF6600", "808000", "008000", "008080", "0000FF",
							"666699", "808080", "FF0000", "FF9900", "99CC00",
							"339966", "33CCCC", "3366FF", "800080", "969696",
							"FF00FF", "FFCC00", "FFFF00", "00FF00", "00FFFF",
							"00CCFF", "993366", "C0C0C0", "FF99CC", "FFCC99",
							"FFFF99", "CCFFCC", "CCFFFF", "99CCFF", "CC99FF",
							"FFFFFF" ],
					onRender : function(_2) {
						var t = new Ext.MasterTemplate(
								"<tpl><a href=\"#\" class=\"color-{0}\" hidefocus=\"on\"><em><span style=\"background:#{0}\">&#160;</span></em></a></tpl>");
						var c = this.colors;
						for ( var i = 0, _6 = c.length; i < _6; i++) {
							t.add( [ c[i] ]);
						}
						var el = document.createElement("div");
						el.className = this.itemCls;
						t.overwrite(el);
						_2.dom.appendChild(el);
						this.el = Ext.get(el);
						this.el.on("click", this.handleClick, this, {
							delegate : "a"
						});
					},
					afterRender : function() {
						if (this.value) {
							var s = this.value;
							this.value = null;
							this.select(s);
						}
					},
					handleClick : function(e, t) {
						e.preventDefault();
						if (!this.disabled) {
							var c = t.className
									.match(/(?:^|\s)color-(.{6})(?:\s|$)/)[1];
							this.select(c.toUpperCase());
						}
					},
					select : function(_c) {
						_c = _c.replace("#", "");
						if (_c != this.value) {
							var el = this.el;
							if (this.value) {
								el.child("a.color-" + this.value).removeClass(
										"x-color-palette-sel");
							}
							el.child("a.color-" + _c).addClass(
									"x-color-palette-sel");
							this.value = _c;
							this.fireEvent("select", this, _c);
						}
					}
				});

Ext.DatePicker = function(_1) {
	Ext.DatePicker.superclass.constructor.call(this, _1);
	this.value = new Date().clearTime();
	this.addEvents( {
		select : true
	});
	if (this.handler) {
		this.on("select", this.handler, this.scope || this);
	}
	if (!this.disabledDatesRE && this.disabledDates) {
		var dd = this.disabledDates;
		var re = "(?:";
		for ( var i = 0; i < dd.length; i++) {
			re += dd[i];
			if (i != dd.length - 1) {
				re += "|";
			}
		}
		this.disabledDatesRE = new RegExp(re + ")");
	}
};
Ext
		.extend(
				Ext.DatePicker,
				Ext.Component,
				{
					todayText : "Today",
					todayTip : "{0} (Spacebar)",
					minDate : null,
					maxDate : null,
					minText : "This date is before the minimum date",
					maxText : "This date is after the maximum date",
					format : "m/d/y",
					disabledDays : null,
					disabledDaysText : "",
					disabledDatesRE : null,
					disabledDatesText : "",
					constrainToViewport : true,
					monthNames : Date.monthNames,
					dayNames : Date.dayNames,
					nextText : "Next Month (Control+Right)",
					prevText : "Previous Month (Control+Left)",
					monthYearText : "Choose a month (Control+Up/Down to move years)",
					startDay : 0,
					setValue : function(_5) {
						var _6 = this.value;
						this.value = _5.clearTime(true);
						if (this.el) {
							this.update(this.value);
						}
					},
					getValue : function() {
						return this.value;
					},
					focus : function() {
						if (this.el) {
							this.update(this.activeDate);
						}
					},
					onRender : function(_7) {
						var m = [
								"<table cellspacing=\"0\">",
								"<tr><td class=\"x-date-left\"><a href=\"#\" title=\"",
								this.prevText,
								"\">&#160;</a></td><td class=\"x-date-middle\" align=\"center\"></td><td class=\"x-date-right\"><a href=\"#\" title=\"",
								this.nextText,
								"\">&#160;</a></td></tr>",
								"<tr><td colspan=\"3\"><table class=\"x-date-inner\" cellspacing=\"0\"><thead><tr>" ];
						var dn = this.dayNames;
						for ( var i = 0; i < 7; i++) {
							var d = this.startDay + i;
							if (d > 6) {
								d = d - 7;
							}
							m.push("<th><span>", dn[d].substr(0, 1),
									"</span></th>");
						}
						m[m.length] = "</tr></thead><tbody><tr>";
						for ( var i = 0; i < 42; i++) {
							if (i % 7 == 0 && i != 0) {
								m[m.length] = "</tr><tr>";
							}
							m[m.length] = "<td><a href=\"#\" hidefocus=\"on\" class=\"x-date-date\" tabIndex=\"1\"><em><span></span></em></a></td>";
						}
						m[m.length] = "</tr></tbody></table></td></tr><tr><td colspan=\"3\" class=\"x-date-bottom\" align=\"center\"></td></tr></table>";
						var el = document.createElement("div");
						el.className = "x-date-picker";
						el.innerHTML = m.join("");
						_7.dom.appendChild(el);
						this.el = Ext.get(el);
						new Ext.util.ClickRepeater(this.el
								.child("td.x-date-left a"), {
							handler : this.showPrevMonth,
							scope : this
						});
						new Ext.util.ClickRepeater(this.el
								.child("td.x-date-right a"), {
							handler : this.showNextMonth,
							scope : this
						});
						this.el.on("mousewheel", this.handleMouseWheel, this);
						var kn = new Ext.KeyNav(this.el, {
							"left" : function(e) {
								e.ctrlKey ? this.showPrevMonth() : this
										.update(this.activeDate.add("d", -1));
							},
							"right" : function(e) {
								e.ctrlKey ? this.showNextMonth() : this
										.update(this.activeDate.add("d", 1));
							},
							"up" : function(e) {
								e.ctrlKey ? this.showNextYear() : this
										.update(this.activeDate.add("d", -7));
							},
							"down" : function(e) {
								e.ctrlKey ? this.showPrevYear() : this
										.update(this.activeDate.add("d", 7));
							},
							"pageUp" : function(e) {
								this.showNextMonth();
							},
							"pageDown" : function(e) {
								this.showPrevMonth();
							},
							"enter" : function(e) {
								e.stopPropagation();
								return true;
							},
							scope : this
						});
						this.el.on("click", this.handleDateClick, this, {
							delegate : "a.x-date-date"
						});
						this.el.addKeyListener(Ext.EventObject.SPACE,
								this.selectToday, this);
						this.el.unselectable();
						this.cells = this.el
								.select("table.x-date-inner tbody td");
						this.textNodes = this.el
								.query("table.x-date-inner tbody span");
						var _15 = new Ext.menu.Menu( {
							plain : true,
							cls : "x-date-mmenu",
							allowOtherMenus : true
						});
						var _16 = Ext.id() + "months";
						for ( var i = 0; i < 12; i++) {
							_15.add(new Ext.menu.CheckItem( {
								id : "mm-" + i,
								text : this.monthNames[i],
								group : _16,
								month : i
							}));
						}
						_15
								.on( {
									"beforeshow" : function() {
										_15.items
												.get(
														"mm-"
																+ (this.activeDate || this.value)
																		.getMonth())
												.setChecked(true);
									},
									"itemclick" : function(_17) {
										var d = (this.activeDate || this.value)
												.clone();
										d.setMonth(_17.month);
										this.update(d);
									},
									"show" : function(m) {
										this.visibleRegion = m.el.getRegion()
												.adjust(2, 2, -2, -2);
									},
									"mouseout" : function(m, e) {
										if (!this.visibleRegion.contains(e
												.getPoint())) {
											m.hide();
										}
									},
									scope : this
								});
						this.mbtn = new Ext.Button(this.el.child(
								"td.x-date-middle", true), {
							menu : _15,
							text : "&#160;",
							menuAlign : "c-c?",
							tooltip : this.monthYearText
						});
						var _1c = (new Date()).dateFormat(this.format);
						var _1d = new Ext.Button(this.el.child(
								"td.x-date-bottom", true), {
							text : String.format(this.todayText, _1c),
							tooltip : String.format(this.todayTip, _1c),
							handler : this.selectToday,
							scope : this
						});
						if (Ext.isIE) {
							this.el.repaint();
						}
						this.update(this.value);
					},
					showPrevMonth : function(e) {
						this.update(this.activeDate.add("mo", -1));
					},
					showNextMonth : function(e) {
						this.update(this.activeDate.add("mo", 1));
					},
					showPrevYear : function() {
						this.update(this.activeDate.add("y", -1));
					},
					showNextYear : function() {
						this.update(this.activeDate.add("y", 1));
					},
					handleMouseWheel : function(e) {
						var _21 = e.getWheelDelta();
						if (_21 > 0) {
							this.showPrevMonth();
							e.stopEvent();
						} else {
							if (_21 < 0) {
								this.showNextMonth();
								e.stopEvent();
							}
						}
					},
					handleDateClick : function(e, t) {
						e.stopEvent();
						if (t.dateValue
								&& !Ext.fly(t.parentNode).hasClass(
										"x-date-disabled")) {
							this.setValue(new Date(t.dateValue));
							this.fireEvent("select", this, this.value);
						}
					},
					selectToday : function() {
						this.setValue(new Date().clearTime());
						this.fireEvent("select", this, this.value);
					},
					update : function(_24) {
						var vd = this.activeDate;
						this.activeDate = _24;
						if (vd && this.el) {
							var t = _24.getTime();
							if (vd.getMonth() == _24.getMonth()
									&& vd.getFullYear() == _24.getFullYear()) {
								this.cells.removeClass("x-date-selected");
								this.cells.each(function(c) {
									if (c.dom.firstChild.dateValue == t) {
										c.addClass("x-date-selected");
										setTimeout(function() {
											try {
												c.dom.firstChild.focus();
											} catch (e) {
											}
										}, 50);
										return false;
									}
								});
								return;
							}
						}
						var _28 = _24.getDaysInMonth();
						var _29 = _24.getFirstDateOfMonth();
						var _2a = _29.getDay() - this.startDay;
						if (_2a <= this.startDay) {
							_2a += 7;
						}
						var pm = _24.add("mo", -1);
						var _2c = pm.getDaysInMonth() - _2a;
						var _2d = this.cells.elements;
						var _2e = this.textNodes;
						_28 += _2a;
						var day = 86400000;
						var d = (new Date(pm.getFullYear(), pm.getMonth(), _2c))
								.clearTime();
						var _31 = new Date().clearTime().getTime();
						var sel = _24.clearTime().getTime();
						var min = this.minDate ? this.minDate.clearTime()
								: Number.NEGATIVE_INFINITY;
						var max = this.maxDate ? this.maxDate.clearTime()
								: Number.POSITIVE_INFINITY;
						var _35 = this.disabledDatesRE;
						var _36 = this.disabledDatesText;
						var _37 = this.disabledDays ? this.disabledDays
								.join("") : false;
						var _38 = this.disabledDaysText;
						var _39 = this.format;
						var _3a = function(cal, _3c) {
							_3c.title = "";
							var t = d.getTime();
							_3c.firstChild.dateValue = t;
							if (t == _31) {
								_3c.className += " x-date-today";
								_3c.title = cal.todayText;
							}
							if (t == sel) {
								_3c.className += " x-date-selected";
								setTimeout(function() {
									try {
										_3c.firstChild.focus();
									} catch (e) {
									}
								}, 50);
							}
							if (t < min) {
								_3c.className = " x-date-disabled";
								_3c.title = cal.minText;
								return;
							}
							if (t > max) {
								_3c.className = " x-date-disabled";
								_3c.title = cal.maxText;
								return;
							}
							if (_37) {
								if (_37.indexOf(d.getDay()) != -1) {
									_3c.title = _38;
									_3c.className = " x-date-disabled";
								}
							}
							if (_35 && _39) {
								var _3e = d.dateFormat(_39);
								if (_35.test(_3e)) {
									_3c.title = _36.replace("%0", _3e);
									_3c.className = " x-date-disabled";
								}
							}
						};
						var i = 0;
						for (; i < _2a; i++) {
							_2e[i].innerHTML = (++_2c);
							d.setDate(d.getDate() + 1);
							_2d[i].className = "x-date-prevday";
							_3a(this, _2d[i]);
						}
						for (; i < _28; i++) {
							intDay = i - _2a + 1;
							_2e[i].innerHTML = (intDay);
							d.setDate(d.getDate() + 1);
							_2d[i].className = "x-date-active";
							_3a(this, _2d[i]);
						}
						var _40 = 0;
						for (; i < 42; i++) {
							_2e[i].innerHTML = (++_40);
							d.setDate(d.getDate() + 1);
							_2d[i].className = "x-date-nextday";
							_3a(this, _2d[i]);
						}
						this.mbtn.setText(this.monthNames[_24.getMonth()] + " "
								+ _24.getFullYear());
						if (!this.internalRender) {
							var _41 = this.el.dom.firstChild;
							var w = _41.offsetWidth;
							this.el.setWidth(w + this.el.getBorderWidth("lr"));
							Ext.fly(_41).setWidth(w);
							this.internalRender = true;
							if (Ext.isOpera && !this.secondPass) {
								_41.rows[0].cells[1].style.width = (w - (_41.rows[0].cells[0].offsetWidth + _41.rows[0].cells[2].offsetWidth))
										+ "px";
								this.secondPass = true;
								this.update.defer(10, this, [ _24 ]);
							}
						}
					}
				});

Ext.TabPanel = function(_1, _2) {
	this.el = Ext.get(_1, true);
	if (_2) {
		if (typeof _2 == "boolean") {
			this.tabPosition = _2 ? "bottom" : "top";
		} else {
			Ext.apply(this, _2);
		}
	}
	if (this.tabPosition == "bottom") {
		this.bodyEl = Ext.get(this.createBody(this.el.dom));
		this.el.addClass("x-tabs-bottom");
	}
	this.stripWrap = Ext.get(this.createStrip(this.el.dom), true);
	this.stripEl = Ext.get(this.createStripList(this.stripWrap.dom), true);
	this.stripBody = Ext.get(this.stripWrap.dom.firstChild.firstChild, true);
	if (Ext.isIE) {
		Ext.fly(this.stripWrap.dom.firstChild).setStyle("overflow-x", "hidden");
	}
	if (this.tabPosition != "bottom") {
		this.bodyEl = Ext.get(this.createBody(this.el.dom));
		this.el.addClass("x-tabs-top");
	}
	this.items = [];
	this.bodyEl.setStyle("position", "relative");
	this.active = null;
	this.activateDelegate = this.activate.createDelegate(this);
	this.events = {
		"tabchange" : true,
		"beforetabchange" : true
	};
	Ext.EventManager.onWindowResize(this.onResize, this);
	this.cpad = this.el.getPadding("lr");
	this.hiddenCount = 0;
	Ext.TabPanel.superclass.constructor.call(this);
};
Ext.extend(Ext.TabPanel, Ext.util.Observable, {
	tabPosition : "top",
	currentTabWidth : 0,
	minTabWidth : 40,
	maxTabWidth : 250,
	preferredTabWidth : 175,
	resizeTabs : false,
	monitorResize : true,
	addTab : function(id, _4, _5, _6) {
		var _7 = new Ext.TabPanelItem(this, id, _4, _6);
		this.addTabItem(_7);
		if (_5) {
			_7.setContent(_5);
		}
		return _7;
	},
	getTab : function(id) {
		return this.items[id];
	},
	hideTab : function(id) {
		var t = this.items[id];
		if (!t.isHidden()) {
			t.setHidden(true);
			this.hiddenCount++;
			this.autoSizeTabs();
		}
	},
	unhideTab : function(id) {
		var t = this.items[id];
		if (t.isHidden()) {
			t.setHidden(false);
			this.hiddenCount--;
			this.autoSizeTabs();
		}
	},
	addTabItem : function(_d) {
		this.items[_d.id] = _d;
		this.items.push(_d);
		if (this.resizeTabs) {
			_d.setWidth(this.currentTabWidth || this.preferredTabWidth);
			this.autoSizeTabs();
		} else {
			_d.autoSize();
		}
	},
	removeTab : function(id) {
		var _f = this.items;
		var tab = _f[id];
		if (!tab) {
			return;
		}
		var _11 = _f.indexOf(tab);
		if (this.active == tab && _f.length > 1) {
			var _12 = this.getNextAvailable(_11);
			if (_12) {
				_12.activate();
			}
		}
		this.stripEl.dom.removeChild(tab.pnode.dom);
		if (tab.bodyEl.dom.parentNode == this.bodyEl.dom) {
			this.bodyEl.dom.removeChild(tab.bodyEl.dom);
		}
		_f.splice(_11, 1);
		delete this.items[tab.id];
		tab.fireEvent("close", tab);
		tab.purgeListeners();
		this.autoSizeTabs();
	},
	getNextAvailable : function(_13) {
		var _14 = this.items;
		var _15 = _13;
		while (_15 < _14.length) {
			var _16 = _14[++_15];
			if (_16 && !_16.isHidden()) {
				return _16;
			}
		}
		_15 = _13;
		while (_15 >= 0) {
			var _16 = _14[--_15];
			if (_16 && !_16.isHidden()) {
				return _16;
			}
		}
		return null;
	},
	disableTab : function(id) {
		var tab = this.items[id];
		if (tab && this.active != tab) {
			tab.disable();
		}
	},
	enableTab : function(id) {
		var tab = this.items[id];
		tab.enable();
	},
	activate : function(id) {
		var tab = this.items[id];
		if (!tab) {
			return null;
		}
		if (tab == this.active) {
			return tab;
		}
		var e = {};
		this.fireEvent("beforetabchange", this, e, tab);
		if (e.cancel !== true && !tab.disabled) {
			if (this.active) {
				this.active.hide();
			}
			this.active = this.items[id];
			this.active.show();
			this.fireEvent("tabchange", this, this.active);
		}
		return tab;
	},
	getActiveTab : function() {
		return this.active;
	},
	syncHeight : function(_1e) {
		var _1f = (_1e || this.el.getHeight()) - this.el.getBorderWidth("tb")
				- this.el.getPadding("tb");
		var bm = this.bodyEl.getMargins();
		var _21 = _1f - (this.stripWrap.getHeight() || 0)
				- (bm.top + bm.bottom);
		this.bodyEl.setHeight(_21);
		return _21;
	},
	onResize : function() {
		if (this.monitorResize) {
			this.autoSizeTabs();
		}
	},
	beginUpdate : function() {
		this.updating = true;
	},
	endUpdate : function() {
		this.updating = false;
		this.autoSizeTabs();
	},
	autoSizeTabs : function() {
		var _22 = this.items.length;
		var _23 = _22 - this.hiddenCount;
		if (!this.resizeTabs || _22 < 1 || _23 < 1 || this.updating) {
			return;
		}
		var w = Math.max(this.el.getWidth() - this.cpad, 10);
		var _25 = Math.floor(w / _23);
		var b = this.stripBody;
		if (b.getWidth() > w) {
			var _27 = this.items;
			this.setTabWidth(Math.max(_25, this.minTabWidth) - 2);
			if (_25 < this.minTabWidth) {
			}
		} else {
			if (this.currentTabWidth < this.preferredTabWidth) {
				this.setTabWidth(Math.min(_25, this.preferredTabWidth) - 2);
			}
		}
	},
	getCount : function() {
		return this.items.length;
	},
	setTabWidth : function(_28) {
		this.currentTabWidth = _28;
		for ( var i = 0, len = this.items.length; i < len; i++) {
			if (!this.items[i].isHidden()) {
				this.items[i].setWidth(_28);
			}
		}
	},
	destroy : function(_2b) {
		Ext.EventManager.removeResizeListener(this.onResize, this);
		for ( var i = 0, len = this.items.length; i < len; i++) {
			this.items[i].purgeListeners();
		}
		if (_2b === true) {
			this.el.update("");
			this.el.remove();
		}
	}
});
Ext.TabPanelItem = function(_2e, id, _30, _31) {
	this.tabPanel = _2e;
	this.id = id;
	this.disabled = false;
	this.text = _30;
	this.loaded = false;
	this.closable = _31;
	this.bodyEl = Ext.get(_2e.createItemBody(_2e.bodyEl.dom, id));
	this.bodyEl.setVisibilityMode(Ext.Element.VISIBILITY);
	this.bodyEl.setStyle("display", "block");
	this.bodyEl.setStyle("zoom", "1");
	this.hideAction();
	var els = _2e.createStripElements(_2e.stripEl.dom, _30, _31);
	this.el = Ext.get(els.el, true);
	this.inner = Ext.get(els.inner, true);
	this.textEl = Ext.get(this.el.dom.firstChild.firstChild.firstChild, true);
	this.pnode = Ext.get(els.el.parentNode, true);
	this.el.on("click", this.onTabClick, this);
	if (_31) {
		var c = Ext.get(els.close, true);
		c.dom.title = this.closeText;
		c.addClassOnOver("close-over");
		c.on("click", this.closeClick, this);
	}
	this.events = {
		"activate" : true,
		"beforeclose" : true,
		"close" : true,
		"deactivate" : true
	};
	this.hidden = false;
	Ext.TabPanelItem.superclass.constructor.call(this);
};
Ext.extend(Ext.TabPanelItem, Ext.util.Observable, {
	purgeListeners : function() {
		Ext.util.Observable.prototype.purgeListeners.call(this);
		this.el.removeAllListeners();
	},
	show : function() {
		this.pnode.addClass("on");
		this.showAction();
		if (Ext.isOpera) {
			this.tabPanel.stripWrap.repaint();
		}
		this.fireEvent("activate", this.tabPanel, this);
	},
	isActive : function() {
		return this.tabPanel.getActiveTab() == this;
	},
	hide : function() {
		this.pnode.removeClass("on");
		this.hideAction();
		this.fireEvent("deactivate", this.tabPanel, this);
	},
	hideAction : function() {
		this.bodyEl.hide();
		this.bodyEl.setStyle("position", "absolute");
		this.bodyEl.setLeft("-20000px");
		this.bodyEl.setTop("-20000px");
	},
	showAction : function() {
		this.bodyEl.setStyle("position", "relative");
		this.bodyEl.setTop("");
		this.bodyEl.setLeft("");
		this.bodyEl.show();
	},
	setTooltip : function(_34) {
		if (Ext.QuickTips && Ext.QuickTips.isEnabled()) {
			this.textEl.dom.qtip = _34;
			this.textEl.dom.removeAttribute("title");
		} else {
			this.textEl.dom.title = _34;
		}
	},
	onTabClick : function(e) {
		e.preventDefault();
		this.tabPanel.activate(this.id);
	},
	getWidth : function() {
		return this.inner.getWidth();
	},
	setWidth : function(_36) {
		var _37 = _36 - this.pnode.getPadding("lr");
		this.inner.setWidth(_37);
		this.textEl.setWidth(_37 - this.inner.getPadding("lr"));
		this.pnode.setWidth(_36);
	},
	setHidden : function(_38) {
		this.hidden = _38;
		this.pnode.setStyle("display", _38 ? "none" : "");
	},
	isHidden : function() {
		return this.hidden;
	},
	getText : function() {
		return this.text;
	},
	autoSize : function() {
		this.textEl.setWidth(1);
		this.setWidth(this.textEl.dom.scrollWidth + this.pnode.getPadding("lr")
				+ this.inner.getPadding("lr"));
	},
	setText : function(_39) {
		this.text = _39;
		this.textEl.update(_39);
		this.setTooltip(_39);
		if (!this.tabPanel.resizeTabs) {
			this.autoSize();
		}
	},
	activate : function() {
		this.tabPanel.activate(this.id);
	},
	disable : function() {
		if (this.tabPanel.active != this) {
			this.disabled = true;
			this.pnode.addClass("disabled");
		}
	},
	enable : function() {
		this.disabled = false;
		this.pnode.removeClass("disabled");
	},
	setContent : function(_3a, _3b) {
		this.bodyEl.update(_3a, _3b);
	},
	getUpdateManager : function() {
		return this.bodyEl.getUpdateManager();
	},
	setUrl : function(url, _3d, _3e) {
		if (this.refreshDelegate) {
			this.un("activate", this.refreshDelegate);
		}
		this.refreshDelegate = this._handleRefresh.createDelegate(this, [ url,
				_3d, _3e ]);
		this.on("activate", this.refreshDelegate);
		return this.bodyEl.getUpdateManager();
	},
	_handleRefresh : function(url, _40, _41) {
		if (!_41 || !this.loaded) {
			var _42 = this.bodyEl.getUpdateManager();
			_42.update(url, _40, this._setLoaded.createDelegate(this));
		}
	},
	refresh : function() {
		if (this.refreshDelegate) {
			this.loaded = false;
			this.refreshDelegate();
		}
	},
	_setLoaded : function() {
		this.loaded = true;
	},
	closeClick : function(e) {
		var o = {};
		e.stopEvent();
		this.fireEvent("beforeclose", this, o);
		if (o.cancel !== true) {
			this.tabPanel.removeTab(this.id);
		}
	},
	closeText : "Close this tab"
});
Ext.TabPanel.prototype.createStrip = function(_45) {
	var _46 = document.createElement("div");
	_46.className = "x-tabs-wrap";
	_45.appendChild(_46);
	return _46;
};
Ext.TabPanel.prototype.createStripList = function(_47) {
	_47.innerHTML = "<div class=\"x-tabs-strip-wrap\"><table class=\"x-tabs-strip\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr></tr></tbody></table></div>";
	return _47.firstChild.firstChild.firstChild.firstChild;
};
Ext.TabPanel.prototype.createBody = function(_48) {
	var _49 = document.createElement("div");
	Ext.id(_49, "tab-body");
	Ext.fly(_49).addClass("x-tabs-body");
	_48.appendChild(_49);
	return _49;
};
Ext.TabPanel.prototype.createItemBody = function(_4a, id) {
	var _4c = Ext.getDom(id);
	if (!_4c) {
		_4c = document.createElement("div");
		_4c.id = id;
	}
	Ext.fly(_4c).addClass("x-tabs-item-body");
	_4a.insertBefore(_4c, _4a.firstChild);
	return _4c;
};
Ext.TabPanel.prototype.createStripElements = function(_4d, _4e, _4f) {
	var td = document.createElement("td");
	_4d.appendChild(td);
	if (_4f) {
		td.className = "x-tabs-closable";
		if (!this.closeTpl) {
			this.closeTpl = new Ext.Template(
					"<a href=\"#\" class=\"x-tabs-right\"><span class=\"x-tabs-left\"><em class=\"x-tabs-inner\">"
							+ "<span unselectable=\"on\""
							+ (this.disableTooltips ? "" : " title=\"{text}\"")
							+ " class=\"x-tabs-text\">{text}</span>"
							+ "<div unselectable=\"on\" class=\"close-icon\">&#160;</div></em></span></a>");
		}
		var el = this.closeTpl.overwrite(td, {
			"text" : _4e
		});
		var _52 = el.getElementsByTagName("div")[0];
		var _53 = el.getElementsByTagName("em")[0];
		return {
			"el" : el,
			"close" : _52,
			"inner" : _53
		};
	} else {
		if (!this.tabTpl) {
			this.tabTpl = new Ext.Template(
					"<a href=\"#\" class=\"x-tabs-right\"><span class=\"x-tabs-left\"><em class=\"x-tabs-inner\">"
							+ "<span unselectable=\"on\""
							+ (this.disableTooltips ? "" : " title=\"{text}\"")
							+ " class=\"x-tabs-text\">{text}</span></em></span></a>");
		}
		var el = this.tabTpl.overwrite(td, {
			"text" : _4e
		});
		var _53 = el.getElementsByTagName("em")[0];
		return {
			"el" : el,
			"inner" : _53
		};
	}
};

Ext.Button = function(_1, _2) {
	Ext.apply(this, _2);
	this.events = {
		"click" : true,
		"toggle" : true,
		"mouseover" : true,
		"mouseout" : true
	};
	if (this.menu) {
		this.menu = Ext.menu.MenuMgr.get(this.menu);
	}
	if (_1) {
		this.render(_1);
	}
	Ext.Button.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.Button,
				Ext.util.Observable,
				{
					hidden : false,
					disabled : false,
					pressed : false,
					enableToggle : false,
					menu : undefined,
					menuAlign : "tl-bl?",
					menuClassTarget : "tr",
					tooltipType : "qtip",
					render : function(_3) {
						var _4;
						if (this.hideParent) {
							this.parentEl = Ext.get(_3);
						}
						if (!this.dhconfig) {
							if (!this.template) {
								if (!Ext.Button.buttonTemplate) {
									Ext.Button.buttonTemplate = new Ext.Template(
											"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"x-btn-wrap\"><tbody><tr>",
											"<td class=\"x-btn-left\"><i>&#160;</i></td><td class=\"x-btn-center\"><em><button class=\"x-btn-text\">{0}</button></em></td><td class=\"x-btn-right\"><i>&#160;</i></td>",
											"</tr></tbody></table>");
								}
								this.template = Ext.Button.buttonTemplate;
							}
							_4 = this.template.append(_3, [ this.text
									|| "&#160;" ], true);
							var _5 = _4.child("button:first");
							if (this.cls) {
								_4.addClass(this.cls);
							}
							if (this.icon) {
								_5.setStyle("background-image", "url("
										+ this.icon + ")");
							}
							if (this.tooltip) {
								if (typeof this.tooltip == "object") {
									Ext.QuickTips.tips(Ext.apply( {
										target : _5.id
									}, this.tooltip));
								} else {
									_5.dom[this.tooltipType] = this.tooltip;
								}
							}
						} else {
							_4 = Ext.DomHelper.append(Ext.get(_3).dom,
									this.dhconfig, true);
						}
						this.el = _4;
						if (this.id) {
							this.el.dom.id = this.el.id = this.id;
						}
						if (this.menu) {
							this.el.child(this.menuClassTarget).addClass(
									"x-btn-with-menu");
							this.menu.on("show", this.onMenuShow, this);
							this.menu.on("hide", this.onMenuHide, this);
						}
						_4.addClass("x-btn");
						if (Ext.isIE && !Ext.isIE7) {
							this.autoWidth.defer(1, this);
						} else {
							this.autoWidth();
						}
						_4.on("click", this.onClick, this);
						_4.on("mouseover", this.onMouseOver, this);
						_4.on("mouseout", this.onMouseOut, this);
						_4.on("mousedown", this.onMouseDown, this);
						if (this.hidden) {
							this.hide();
						}
						if (this.disabled) {
							this.disable();
						}
						Ext.ButtonToggleMgr.register(this);
						if (this.pressed) {
							this.el.addClass("x-btn-pressed");
						}
						if (this.repeat) {
							var _6 = new Ext.util.ClickRepeater(
									_4,
									typeof this.repeat == "object" ? this.repeat
											: {});
							_6.on("click", this.onClick, this);
						}
					},
					getEl : function() {
						return this.el;
					},
					destroy : function() {
						Ext.ButtonToggleMgr.unregister(this);
						this.el.removeAllListeners();
						this.purgeListeners();
						this.el.remove();
					},
					autoWidth : function() {
						if (this.el) {
							this.el.setWidth("auto");
							if (Ext.isIE7 && Ext.isStrict) {
								var ib = this.el.child("button");
								if (ib && ib.getWidth() > 20) {
									ib.clip();
									ib.setWidth(Ext.util.TextMetrics.measure(
											ib, this.text).width
											+ ib.getFrameWidth("lr"));
								}
							}
							if (this.minWidth) {
								if (this.hidden) {
									this.el.beginMeasure();
								}
								if (this.el.getWidth() < this.minWidth) {
									this.el.setWidth(this.minWidth);
								}
								if (this.hidden) {
									this.el.endMeasure();
								}
							}
						}
					},
					setHandler : function(_8, _9) {
						this.handler = _8;
						this.scope = _9;
					},
					setText : function(_a) {
						this.text = _a;
						if (this.el) {
							this.el.child("td.x-btn-center button.x-btn-text")
									.update(_a);
						}
						this.autoWidth();
					},
					getText : function() {
						return this.text;
					},
					show : function() {
						this.hidden = false;
						if (this.el) {
							this[this.hideParent ? "parentEl" : "el"].setStyle(
									"display", "");
						}
					},
					hide : function() {
						this.hidden = true;
						if (this.el) {
							this[this.hideParent ? "parentEl" : "el"].setStyle(
									"display", "none");
						}
					},
					setVisible : function(_b) {
						if (_b) {
							this.show();
						} else {
							this.hide();
						}
					},
					toggle : function(_c) {
						_c = _c === undefined ? !this.pressed : _c;
						if (_c != this.pressed) {
							if (_c) {
								this.el.addClass("x-btn-pressed");
								this.pressed = true;
								this.fireEvent("toggle", this, true);
							} else {
								this.el.removeClass("x-btn-pressed");
								this.pressed = false;
								this.fireEvent("toggle", this, false);
							}
							if (this.toggleHandler) {
								this.toggleHandler.call(this.scope || this,
										this, _c);
							}
						}
					},
					focus : function() {
						this.el.child("button:first").focus();
					},
					disable : function() {
						if (this.el) {
							this.el.addClass("x-btn-disabled");
						}
						this.disabled = true;
					},
					enable : function() {
						if (this.el) {
							this.el.removeClass("x-btn-disabled");
						}
						this.disabled = false;
					},
					setDisabled : function(v) {
						this[v !== true ? "enable" : "disable"]();
					},
					onClick : function(e) {
						if (e) {
							e.preventDefault();
						}
						if (!this.disabled) {
							if (this.enableToggle) {
								this.toggle();
							}
							if (this.menu && !this.menu.isVisible()) {
								this.menu.show(this.el, this.menuAlign);
							}
							this.fireEvent("click", this, e);
							if (this.handler) {
								this.el.removeClass("x-btn-over");
								this.handler.call(this.scope || this, this, e);
							}
						}
					},
					onMouseOver : function(e) {
						if (!this.disabled) {
							this.el.addClass("x-btn-over");
							this.fireEvent("mouseover", this, e);
						}
					},
					onMouseOut : function(e) {
						if (!e.within(this.el, true)) {
							this.el.removeClass("x-btn-over");
							this.fireEvent("mouseout", this, e);
						}
					},
					onMouseDown : function() {
						if (!this.disabled) {
							this.el.addClass("x-btn-click");
							Ext.get(document).on("mouseup", this.onMouseUp,
									this);
						}
					},
					onMouseUp : function() {
						this.el.removeClass("x-btn-click");
						Ext.get(document).un("mouseup", this.onMouseUp, this);
					},
					onMenuShow : function(e) {
						this.el.addClass("x-btn-menu-active");
					},
					onMenuHide : function(e) {
						this.el.removeClass("x-btn-menu-active");
					}
				});
Ext.ButtonToggleMgr = function() {
	var _13 = {};
	function toggleGroup(btn, _15) {
		if (_15) {
			var g = _13[btn.toggleGroup];
			for ( var i = 0, l = g.length; i < l; i++) {
				if (g[i] != btn) {
					g[i].toggle(false);
				}
			}
		}
	}
	return {
		register : function(btn) {
			if (!btn.toggleGroup) {
				return;
			}
			var g = _13[btn.toggleGroup];
			if (!g) {
				g = _13[btn.toggleGroup] = [];
			}
			g.push(btn);
			btn.on("toggle", toggleGroup);
		},
		unregister : function(btn) {
			if (!btn.toggleGroup) {
				return;
			}
			var g = _13[btn.toggleGroup];
			if (g) {
				g.remove(btn);
				btn.un("toggle", toggleGroup);
			}
		}
	};
}();

Ext.MenuButton = function(_1, _2) {
	Ext.MenuButton.superclass.constructor.call(this, _1, _2);
	this.events["arrowclick"] = true;
};
Ext
		.extend(
				Ext.MenuButton,
				Ext.Button,
				{
					render : function(_3) {
						var _4 = new Ext.Template(
								"<table cellspacing=\"0\" class=\"x-btn-menu-wrap x-btn\"><tr><td>",
								"<table cellspacing=\"0\" class=\"x-btn-wrap x-btn-menu-text-wrap\"><tbody>",
								"<tr><td class=\"x-btn-left\"><i>&#160;</i></td><td class=\"x-btn-center\"><button class=\"x-btn-text\">{0}</button></td></tr>",
								"</tbody></table></td><td>",
								"<table cellspacing=\"0\" class=\"x-btn-wrap x-btn-menu-arrow-wrap\"><tbody>",
								"<tr><td class=\"x-btn-center\"><button class=\"x-btn-menu-arrow-el\">&#160;</button></td><td class=\"x-btn-right\"><i>&#160;</i></td></tr>",
								"</tbody></table></td></tr></table>");
						var _5 = _4.append(_3, [ this.text ], true);
						if (this.cls) {
							_5.addClass(this.cls);
						}
						if (this.icon) {
							_5.child("button").setStyle("background-image",
									"url(" + this.icon + ")");
						}
						this.el = _5;
						this.autoWidth();
						_5.on("click", this.onClick, this);
						_5.on("mouseover", this.onMouseOver, this);
						_5.on("mouseout", this.onMouseOut, this);
						_5.on("mousedown", this.onMouseDown, this);
						_5.on("mouseup", this.onMouseUp, this);
						if (this.tooltip) {
							var _6 = _5.child("button:first");
							if (typeof this.tooltip == "object") {
								Ext.QuickTips.tips(Ext.apply( {
									target : _6.id
								}, this.tooltip));
							} else {
								_6.dom[this.tooltipType] = this.tooltip;
							}
						}
						if (this.arrowTooltip) {
							var _6 = _5.child("button:nth(2)");
							_6.dom[this.tooltipType] = this.arrowTooltip;
						}
						if (this.hidden) {
							this.hide();
						}
						if (this.disabled) {
							this.disable();
						}
						if (this.menu) {
							this.menu.on("show", this.onMenuShow, this);
							this.menu.on("hide", this.onMenuHide, this);
						}
					},
					autoWidth : function() {
						if (this.el) {
							var _7 = this.el.child("table:first");
							var _8 = this.el.child("table:last");
							this.el.setWidth("auto");
							_7.setWidth("auto");
							if (Ext.isIE7 && Ext.isStrict) {
								var ib = this.el.child("button:first");
								if (ib && ib.getWidth() > 20) {
									ib.clip();
									ib.setWidth(Ext.util.TextMetrics.measure(
											ib, this.text).width
											+ ib.getFrameWidth("lr"));
								}
							}
							if (this.minWidth) {
								if (this.hidden) {
									this.el.beginMeasure();
								}
								if ((_7.getWidth() + _8.getWidth()) < this.minWidth) {
									_7.setWidth(this.minWidth - _8.getWidth());
								}
								if (this.hidden) {
									this.el.endMeasure();
								}
							}
							this.el.setWidth(_7.getWidth() + _8.getWidth());
						}
					},
					setHandler : function(_a, _b) {
						this.handler = _a;
						this.scope = _b;
					},
					setArrowHandler : function(_c, _d) {
						this.arrowHandler = _c;
						this.scope = _d;
					},
					focus : function() {
						if (this.el) {
							this.el.child("a:first").focus();
						}
					},
					onClick : function(e) {
						e.preventDefault();
						if (!this.disabled) {
							if (e.getTarget(".x-btn-menu-arrow-wrap")) {
								if (this.menu && !this.menu.isVisible()) {
									this.menu.show(this.el, this.menuAlign);
								}
								this.fireEvent("arrowclick", this, e);
								if (this.arrowHandler) {
									this.arrowHandler.call(this.scope || this,
											this, e);
								}
							} else {
								this.fireEvent("click", this, e);
								if (this.handler) {
									this.handler.call(this.scope || this, this,
											e);
								}
							}
						}
					},
					onMouseDown : function(e) {
						if (!this.disabled) {
							Ext.fly(e.getTarget("table")).addClass(
									"x-btn-click");
						}
					},
					onMouseUp : function(e) {
						Ext.fly(e.getTarget("table"))
								.removeClass("x-btn-click");
					}
				});

Ext.Toolbar = function(_1, _2, _3) {
	Ext.apply(this, _3);
	this.el = Ext.get(_1);
	if (this.cls) {
		this.el.addClass(this.cls);
	}
	this.el
			.update("<div class=\"x-toolbar x-small-editor\"><table cellspacing=\"0\"><tr></tr></table></div>");
	this.tr = this.el.child("tr", true);
	var _4 = 0;
	this.items = new Ext.util.MixedCollection(false, function(o) {
		return o.id || ("item" + (++_4));
	});
	if (_2) {
		this.add.apply(this, _2);
	}
};
Ext.Toolbar.prototype = {
	add : function() {
		var a = arguments, l = a.length;
		for ( var i = 0; i < l; i++) {
			var el = a[i];
			if (el.applyTo) {
				this.addField(el);
			} else {
				if (el.render) {
					this.addItem(el);
				} else {
					if (typeof el == "string") {
						if (el == "separator" || el == "-") {
							this.addSeparator();
						} else {
							if (el == " ") {
								this.addSpacer();
							} else {
								this.addText(el);
							}
						}
					} else {
						if (el.tagName) {
							this.addElement(el);
						} else {
							if (typeof el == "object") {
								this.addButton(el);
							}
						}
					}
				}
			}
		}
	},
	getEl : function() {
		return this.el;
	},
	addSeparator : function() {
		return this.addItem(new Ext.Toolbar.Separator());
	},
	addSpacer : function() {
		return this.addItem(new Ext.Toolbar.Spacer());
	},
	addElement : function(el) {
		return this.addItem(new Ext.Toolbar.Item(el));
	},
	addItem : function(_b) {
		var td = this.nextBlock();
		_b.render(td);
		this.items.add(_b);
		return _b;
	},
	addButton : function(_d) {
		if (_d instanceof Array) {
			var _e = [];
			for ( var i = 0, len = _d.length; i < len; i++) {
				_e.push(this.addButton(_d[i]));
			}
			return _e;
		}
		var b = _d;
		if (!(_d instanceof Ext.Toolbar.Button)) {
			b = new Ext.Toolbar.Button(_d);
		}
		var td = this.nextBlock();
		b.render(td);
		this.items.add(b);
		return b;
	},
	addText : function(_13) {
		return this.addItem(new Ext.Toolbar.TextItem(_13));
	},
	insertButton : function(_14, _15) {
		if (_15 instanceof Array) {
			var _16 = [];
			for ( var i = 0, len = _15.length; i < len; i++) {
				_16.push(this.insertButton(_14 + i, _15[i]));
			}
			return _16;
		}
		if (!(_15 instanceof Ext.Toolbar.Button)) {
			_15 = new Ext.Toolbar.Button(_15);
		}
		var td = document.createElement("td");
		this.tr.insertBefore(td, this.tr.childNodes[_14]);
		_15.render(td);
		this.items.insert(_14, _15);
		return _15;
	},
	addDom : function(_1a, _1b) {
		var td = this.nextBlock();
		Ext.DomHelper.overwrite(td, _1a);
		var ti = new Ext.Toolbar.Item(td.firstChild);
		ti.render(td);
		this.items.add(ti);
		return ti;
	},
	addField : function(_1e) {
		var td = this.nextBlock();
		_1e.render(td);
		var ti = new Ext.Toolbar.Item(td.firstChild);
		ti.render(td);
		this.items.add(ti);
		return ti;
	},
	nextBlock : function() {
		var td = document.createElement("td");
		this.tr.appendChild(td);
		return td;
	}
};
Ext.Toolbar.Item = function(el) {
	this.el = Ext.getDom(el);
	this.id = Ext.id(this.el);
	this.hidden = false;
};
Ext.Toolbar.Item.prototype = {
	getEl : function() {
		return this.el;
	},
	render : function(td) {
		this.td = td;
		td.appendChild(this.el);
	},
	destroy : function() {
		this.td.parentNode.removeChild(this.td);
	},
	show : function() {
		this.hidden = false;
		this.td.style.display = "";
	},
	hide : function() {
		this.hidden = true;
		this.td.style.display = "none";
	},
	setVisible : function(_24) {
		if (_24) {
			this.show();
		} else {
			this.hide();
		}
	},
	focus : function() {
		Ext.fly(this.el).focus();
	},
	disable : function() {
		Ext.fly(this.td).addClass("x-item-disabled");
		this.disabled = true;
		this.el.disabled = true;
	},
	enable : function() {
		Ext.fly(this.td).removeClass("x-item-disabled");
		this.disabled = false;
		this.el.disabled = false;
	}
};
Ext.Toolbar.Separator = function() {
	var s = document.createElement("span");
	s.className = "ytb-sep";
	Ext.Toolbar.Separator.superclass.constructor.call(this, s);
};
Ext.extend(Ext.Toolbar.Separator, Ext.Toolbar.Item);
Ext.Toolbar.Spacer = function() {
	var s = document.createElement("div");
	s.className = "ytb-spacer";
	Ext.Toolbar.Separator.superclass.constructor.call(this, s);
};
Ext.extend(Ext.Toolbar.Spacer, Ext.Toolbar.Item);
Ext.Toolbar.TextItem = function(_27) {
	var s = document.createElement("span");
	s.className = "ytb-text";
	s.innerHTML = _27;
	Ext.Toolbar.TextItem.superclass.constructor.call(this, s);
};
Ext.extend(Ext.Toolbar.TextItem, Ext.Toolbar.Item);
Ext.Toolbar.Button = function(_29) {
	Ext.Toolbar.Button.superclass.constructor.call(this, null, _29);
};
Ext.extend(Ext.Toolbar.Button, Ext.Button, {
	render : function(td) {
		this.td = td;
		Ext.Toolbar.Button.superclass.render.call(this, td);
	},
	destroy : function() {
		Ext.Toolbar.Button.superclass.destroy.call(this);
		this.td.parentNode.removeChild(this.td);
	},
	show : function() {
		this.hidden = false;
		this.td.style.display = "";
	},
	hide : function() {
		this.hidden = true;
		this.td.style.display = "none";
	},
	disable : function() {
		Ext.fly(this.td).addClass("x-item-disabled");
		this.disabled = true;
	},
	enable : function() {
		Ext.fly(this.td).removeClass("x-item-disabled");
		this.disabled = false;
	}
});
Ext.ToolbarButton = Ext.Toolbar.Button;
Ext.Toolbar.MenuButton = function(_2b) {
	Ext.Toolbar.MenuButton.superclass.constructor.call(this, null, _2b);
};
Ext.extend(Ext.Toolbar.MenuButton, Ext.MenuButton, {
	render : function(td) {
		this.td = td;
		Ext.Toolbar.MenuButton.superclass.render.call(this, td);
	},
	destroy : function() {
		Ext.Toolbar.MenuButton.superclass.destroy.call(this);
		this.td.parentNode.removeChild(this.td);
	},
	show : function() {
		this.hidden = false;
		this.td.style.display = "";
	},
	hide : function() {
		this.hidden = true;
		this.td.style.display = "none";
	}
});

Ext.PagingToolbar = function(el, ds, _3) {
	Ext.PagingToolbar.superclass.constructor.call(this, el, null, _3);
	this.ds = ds;
	this.cursor = 0;
	this.render(this.el);
	this.bind(ds);
};
Ext
		.extend(
				Ext.PagingToolbar,
				Ext.Toolbar,
				{
					pageSize : 20,
					displayMsg : "Displaying {0} - {1} of {2}",
					emptyMsg : "No data to display",
					beforePageText : "Page",
					afterPageText : "of {0}",
					firstText : "First Page",
					prevText : "Previous Page",
					nextText : "Next Page",
					lastText : "Last Page",
					refreshText : "Refresh",
					render : function(el) {
						this.first = this.addButton( {
							tooltip : this.firstText,
							cls : "x-btn-icon x-grid-page-first",
							disabled : true,
							handler : this.onClick.createDelegate(this,
									[ "first" ])
						});
						this.prev = this.addButton( {
							tooltip : this.prevText,
							cls : "x-btn-icon x-grid-page-prev",
							disabled : true,
							handler : this.onClick.createDelegate(this,
									[ "prev" ])
						});
						this.addSeparator();
						this.add(this.beforePageText);
						this.field = Ext.get(this.addDom( {
							tag : "input",
							type : "text",
							size : "3",
							value : "1",
							cls : "x-grid-page-number"
						}).el);
						this.field.on("keydown", this.onPagingKeydown, this);
						this.field.on("focus", function() {
							this.dom.select();
						});
						this.afterTextEl = this.addText(String.format(
								this.afterPageText, 1));
						this.field.setHeight(18);
						this.addSeparator();
						this.next = this.addButton( {
							tooltip : this.nextText,
							cls : "x-btn-icon x-grid-page-next",
							disabled : true,
							handler : this.onClick.createDelegate(this,
									[ "next" ])
						});
						this.last = this.addButton( {
							tooltip : this.lastText,
							cls : "x-btn-icon x-grid-page-last",
							disabled : true,
							handler : this.onClick.createDelegate(this,
									[ "last" ])
						});
						this.addSeparator();
						this.loading = this.addButton( {
							tooltip : this.refreshText,
							cls : "x-btn-icon x-grid-loading",
							disabled : true,
							handler : this.onClick.createDelegate(this,
									[ "refresh" ])
						});
						if (this.displayInfo) {
							this.displayEl = this.el.createChild( {
								cls : "x-paging-info"
							});
						}
					},
					updateInfo : function() {
						if (this.displayEl) {
							var _5 = this.ds.getCount();
							var _6 = _5 == 0 ? this.emptyMsg : String.format(
									this.displayMsg, this.cursor + 1,
									this.cursor + _5, this.ds.getTotalCount());
							this.displayEl.update(_6);
						}
					},
					onLoad : function(ds, r, o) {
						this.cursor = o.params ? o.params.start : 0;
						var d = this.getPageData(), ap = d.activePage, ps = d.pages;
						this.afterTextEl.el.innerHTML = String.format(
								this.afterPageText, d.pages);
						this.field.dom.value = ap;
						this.first.setDisabled(ap == 1);
						this.prev.setDisabled(ap == 1);
						this.next.setDisabled(ap == ps);
						this.last.setDisabled(ap == ps);
						this.loading.enable();
						this.updateInfo();
					},
					getPageData : function() {
						var _d = this.ds.getTotalCount();
						return {
							total : _d,
							activePage : Math
									.ceil((this.cursor + this.pageSize)
											/ this.pageSize),
							pages : _d < this.pageSize ? 1 : Math.ceil(_d
									/ this.pageSize)
						};
					},
					onLoadError : function() {
						this.loading.enable();
					},
					onPagingKeydown : function(e) {
						var k = e.getKey();
						var d = this.getPageData();
						if (k == e.RETURN) {
							var v = this.field.dom.value, _12;
							if (!v || isNaN(_12 = parseInt(v, 10))) {
								this.field.dom.value = d.activePage;
								return;
							}
							_12 = Math.min(Math.max(1, _12), d.pages) - 1;
							this.ds.load( {
								params : {
									start : _12 * this.pageSize,
									limit : this.pageSize
								}
							});
							e.stopEvent();
						} else {
							if (k == e.HOME || (k == e.UP && e.ctrlKey)
									|| (k == e.PAGEUP && e.ctrlKey)
									|| (k == e.RIGHT && e.ctrlKey)
									|| k == e.END || (k == e.DOWN && e.ctrlKey)
									|| (k == e.LEFT && e.ctrlKey)
									|| (k == e.PAGEDOWN && e.ctrlKey)) {
								var _12 = (k == e.HOME
										|| (k == e.DOWN && e.ctrlKey)
										|| (k == e.LEFT && e.ctrlKey) || (k == e.PAGEDOWN && e.ctrlKey)) ? 1
										: d.pages;
								this.field.dom.value = _12;
								this.ds.load( {
									params : {
										start : (_12 - 1) * this.pageSize,
										limit : this.pageSize
									}
								});
								e.stopEvent();
							} else {
								if (k == e.UP || k == e.RIGHT || k == e.PAGEUP
										|| k == e.DOWN || k == e.LEFT
										|| k == e.PAGEDOWN) {
									var v = this.field.dom.value, _12;
									var _13 = (e.shiftKey) ? 10 : 1;
									if (k == e.DOWN || k == e.LEFT
											|| k == e.PAGEDOWN) {
										_13 *= -1;
									}
									if (!v || isNaN(_12 = parseInt(v, 10))) {
										this.field.dom.value = d.activePage;
										return;
									} else {
										if (parseInt(v, 10) + _13 >= 1
												& parseInt(v, 10) + _13 <= d.pages) {
											this.field.dom.value = parseInt(v,
													10)
													+ _13;
											_12 = Math.min(Math.max(1, _12
													+ _13), d.pages) - 1;
											this.ds
													.load( {
														params : {
															start : _12
																	* this.pageSize,
															limit : this.pageSize
														}
													});
										}
									}
									e.stopEvent();
								}
							}
						}
					},
					beforeLoad : function() {
						if (this.loading) {
							this.loading.disable();
						}
					},
					onClick : function(_14) {
						var ds = this.ds;
						switch (_14) {
						case "first":
							ds.load( {
								params : {
									start : 0,
									limit : this.pageSize
								}
							});
							break;
						case "prev":
							ds.load( {
								params : {
									start : Math.max(0, this.cursor
											- this.pageSize),
									limit : this.pageSize
								}
							});
							break;
						case "next":
							ds.load( {
								params : {
									start : this.cursor + this.pageSize,
									limit : this.pageSize
								}
							});
							break;
						case "last":
							var _16 = ds.getTotalCount();
							var _17 = _16 % this.pageSize;
							var _18 = _17 ? (_16 - _17) : _16 - this.pageSize;
							ds.load( {
								params : {
									start : _18,
									limit : this.pageSize
								}
							});
							break;
						case "refresh":
							ds.load( {
								params : {
									start : this.cursor,
									limit : this.pageSize
								}
							});
							break;
						}
					},
					unbind : function(ds) {
						ds.un("beforeload", this.beforeLoad, this);
						ds.un("load", this.onLoad, this);
						ds.un("loadexception", this.onLoadError, this);
					},
					bind : function(ds) {
						ds.on("beforeload", this.beforeLoad, this);
						ds.on("load", this.onLoad, this);
						ds.on("loadexception", this.onLoadError, this);
					}
				});

Ext.Resizable = function(el, _2) {
	this.el = Ext.get(el);
	if (_2 && _2.wrap) {
		_2.resizeChild = this.el;
		this.el = this.el.wrap(typeof _2.wrap == "object" ? _2.wrap : {
			cls : "xresizable-wrap"
		});
		this.el.id = this.el.dom.id = _2.resizeChild.id + "-rzwrap";
		this.el.setStyle("overflow", "hidden");
		this.el.setPositioning(_2.resizeChild.getPositioning());
		_2.resizeChild.clearPositioning();
		if (!_2.width || !_2.height) {
			var _3 = _2.resizeChild.getSize();
			this.el.setSize(_3.width, _3.height);
		}
		if (_2.pinned && !_2.adjustments) {
			_2.adjustments = "auto";
		}
	}
	this.proxy = this.el.createProxy( {
		tag : "div",
		cls : "x-resizable-proxy",
		id : this.el.id + "-rzproxy"
	});
	this.proxy.unselectable();
	this.overlay = this.el.createProxy( {
		tag : "div",
		cls : "x-resizable-overlay",
		html : "&#160;"
	});
	this.overlay.unselectable();
	this.overlay.enableDisplayMode("block");
	this.overlay.on("mousemove", this.onMouseMove, this);
	this.overlay.on("mouseup", this.onMouseUp, this);
	Ext.apply(this, _2);
	if (this.pinned) {
		this.disableTrackOver = true;
		this.el.addClass("x-resizable-pinned");
	}
	var _4 = this.el.getStyle("position");
	if (_4 != "absolute" && _4 != "fixed") {
		this.el.setStyle("position", "relative");
	}
	if (!this.handles) {
		this.handles = "s,e,se";
		if (this.multiDirectional) {
			this.handles += ",n,w";
		}
	}
	if (this.handles == "all") {
		this.handles = "n s e w ne nw se sw";
	}
	var hs = this.handles.split(/\s*?[,;]\s*?| /);
	var ps = Ext.Resizable.positions;
	for ( var i = 0, _8 = hs.length; i < _8; i++) {
		if (hs[i] && ps[hs[i]]) {
			var _9 = ps[hs[i]];
			this[_9] = new Ext.Resizable.Handle(this, _9,
					this.disableTrackOver, this.transparent);
		}
	}
	this.corner = this.southeast;
	if (this.handles.indexOf("n") != -1 || this.handles.indexOf("w") != -1) {
		this.updateBox = true;
	}
	this.activeHandle = null;
	if (this.resizeChild) {
		if (typeof this.resizeChild == "boolean") {
			this.resizeChild = Ext.get(this.el.dom.firstChild, true);
		} else {
			this.resizeChild = Ext.get(this.resizeChild, true);
		}
	}
	if (this.adjustments == "auto") {
		var rc = this.resizeChild;
		var hw = this.west, he = this.east, hn = this.north, hs = this.south;
		if (rc && (hw || hn)) {
			rc.position("relative");
			rc.setLeft(hw ? hw.el.getWidth() : 0);
			rc.setTop(hn ? hn.el.getHeight() : 0);
		}
		this.adjustments = [
				(he ? -he.el.getWidth() : 0) + (hw ? -hw.el.getWidth() : 0),
				(hn ? -hn.el.getHeight() : 0) + (hs ? -hs.el.getHeight() : 0)
						- 1 ];
	}
	if (this.draggable) {
		this.dd = this.dynamic ? this.el.initDD(null) : this.el.initDDProxy(
				null, {
					dragElId : this.proxy.id
				});
		this.dd.setHandleElId(this.resizeChild ? this.resizeChild.id
				: this.el.id);
	}
	this.events = {
		"beforeresize" : true,
		"resize" : true
	};
	if (this.width !== null && this.height !== null) {
		this.resizeTo(this.width, this.height);
	} else {
		this.updateChildSize();
	}
	Ext.Resizable.superclass.constructor.call(this);
};
Ext.extend(Ext.Resizable, Ext.util.Observable, {
	resizeChild : false,
	adjustments : [ 0, 0 ],
	minWidth : 5,
	minHeight : 5,
	maxWidth : 10000,
	maxHeight : 10000,
	enabled : true,
	animate : false,
	duration : 0.35,
	dynamic : false,
	handles : false,
	multiDirectional : false,
	disableTrackOver : false,
	easing : "easeOutStrong",
	widthIncrement : 0,
	heightIncrement : 0,
	pinned : false,
	width : null,
	height : null,
	preserveRatio : false,
	transparent : false,
	minX : 0,
	minY : 0,
	draggable : false,
	resizeTo : function(_e, _f) {
		this.el.setSize(_e, _f);
		this.updateChildSize();
		this.fireEvent("resize", this, _e, _f, null);
	},
	startSizing : function(e) {
		this.fireEvent("beforeresize", this, e);
		if (this.enabled) {
			this.resizing = true;
			this.startBox = this.el.getBox();
			this.startPoint = e.getXY();
			this.offsets = [
					(this.startBox.x + this.startBox.width)
							- this.startPoint[0],
					(this.startBox.y + this.startBox.height)
							- this.startPoint[1] ];
			this.proxy.setBox(this.startBox);
			this.overlay.setSize(Ext.lib.Dom.getViewWidth(true), Ext.lib.Dom
					.getViewHeight(true));
			this.overlay.show();
			if (!this.dynamic) {
				this.proxy.show();
			}
		}
	},
	onMouseDown : function(_11, e) {
		if (this.enabled) {
			e.stopEvent();
			this.activeHandle = _11;
			this.overlay.setStyle("cursor", _11.el.getStyle("cursor"));
			this.startSizing(e);
		}
	},
	onMouseUp : function(e) {
		var _14 = this.resizeElement();
		this.resizing = false;
		this.handleOut();
		this.overlay.hide();
		this.fireEvent("resize", this, _14.width, _14.height, e);
	},
	updateChildSize : function() {
		if (this.resizeChild) {
			var el = this.el;
			var _16 = this.resizeChild;
			var adj = this.adjustments;
			if (el.dom.offsetWidth) {
				var b = el.getSize(true);
				_16.setSize(b.width + adj[0], b.height + adj[1]);
			}
			if (Ext.isIE) {
				setTimeout(function() {
					if (el.dom.offsetWidth) {
						var b = el.getSize(true);
						_16.setSize(b.width + adj[0], b.height + adj[1]);
					}
				}, 10);
			}
		}
	},
	snap : function(_1a, inc, min) {
		if (!inc || !_1a) {
			return _1a;
		}
		var _1d = _1a;
		var m = _1a % inc;
		if (m > 0) {
			if (m > (inc / 2)) {
				_1d = _1a + (inc - m);
			} else {
				_1d = _1a - m;
			}
		}
		return Math.max(min, _1d);
	},
	resizeElement : function() {
		var box = this.proxy.getBox();
		if (this.updateBox) {
			this.el.setBox(box, false, this.animate, this.duration, null,
					this.easing);
		} else {
			this.el.setSize(box.width, box.height, this.animate, this.duration,
					null, this.easing);
		}
		this.updateChildSize();
		this.proxy.hide();
		return box;
	},
	constrain : function(v, _21, m, mx) {
		if (v - _21 < m) {
			_21 = v - m;
		} else {
			if (v - _21 > mx) {
				_21 = mx - v;
			}
		}
		return _21;
	},
	onMouseMove : function(e) {
		if (this.enabled) {
			try {
				var _25 = this.curSize || this.startBox;
				var x = this.startBox.x, y = this.startBox.y;
				var ox = x, oy = y;
				var w = _25.width, h = _25.height;
				var ow = w, oh = h;
				var mw = this.minWidth, mh = this.minHeight;
				var mxw = this.maxWidth, mxh = this.maxHeight;
				var wi = this.widthIncrement;
				var hi = this.heightIncrement;
				var _34 = e.getXY();
				var _35 = -(this.startPoint[0] - Math.max(this.minX, _34[0]));
				var _36 = -(this.startPoint[1] - Math.max(this.minY, _34[1]));
				var pos = this.activeHandle.position;
				switch (pos) {
				case "east":
					w += _35;
					w = Math.min(Math.max(mw, w), mxw);
					break;
				case "south":
					h += _36;
					h = Math.min(Math.max(mh, h), mxh);
					break;
				case "southeast":
					w += _35;
					h += _36;
					w = Math.min(Math.max(mw, w), mxw);
					h = Math.min(Math.max(mh, h), mxh);
					break;
				case "north":
					_36 = this.constrain(h, _36, mh, mxh);
					y += _36;
					h -= _36;
					break;
				case "west":
					_35 = this.constrain(w, _35, mw, mxw);
					x += _35;
					w -= _35;
					break;
				case "northeast":
					w += _35;
					w = Math.min(Math.max(mw, w), mxw);
					_36 = this.constrain(h, _36, mh, mxh);
					y += _36;
					h -= _36;
					break;
				case "northwest":
					_35 = this.constrain(w, _35, mw, mxw);
					_36 = this.constrain(h, _36, mh, mxh);
					y += _36;
					h -= _36;
					x += _35;
					w -= _35;
					break;
				case "southwest":
					_35 = this.constrain(w, _35, mw, mxw);
					h += _36;
					h = Math.min(Math.max(mh, h), mxh);
					x += _35;
					w -= _35;
					break;
				}
				var sw = this.snap(w, wi, mw);
				var sh = this.snap(h, hi, mh);
				if (sw != w || sh != h) {
					switch (pos) {
					case "northeast":
						y -= sh - h;
						break;
					case "north":
						y -= sh - h;
						break;
					case "southwest":
						x -= sw - w;
						break;
					case "west":
						x -= sw - w;
						break;
					case "northwest":
						x -= sw - w;
						y -= sh - h;
						break;
					}
					w = sw;
					h = sh;
				}
				if (this.preserveRatio) {
					switch (pos) {
					case "southeast":
					case "east":
						h = oh * (w / ow);
						h = Math.min(Math.max(mh, h), mxh);
						w = ow * (h / oh);
						break;
					case "south":
						w = ow * (h / oh);
						w = Math.min(Math.max(mw, w), mxw);
						h = oh * (w / ow);
						break;
					case "northeast":
						w = ow * (h / oh);
						w = Math.min(Math.max(mw, w), mxw);
						h = oh * (w / ow);
						break;
					case "north":
						var tw = w;
						w = ow * (h / oh);
						w = Math.min(Math.max(mw, w), mxw);
						h = oh * (w / ow);
						x += (tw - w) / 2;
						break;
					case "southwest":
						h = oh * (w / ow);
						h = Math.min(Math.max(mh, h), mxh);
						var tw = w;
						w = ow * (h / oh);
						x += tw - w;
						break;
					case "west":
						var th = h;
						h = oh * (w / ow);
						h = Math.min(Math.max(mh, h), mxh);
						y += (th - h) / 2;
						var tw = w;
						w = ow * (h / oh);
						x += tw - w;
						break;
					case "northwest":
						var tw = w;
						var th = h;
						h = oh * (w / ow);
						h = Math.min(Math.max(mh, h), mxh);
						w = ow * (h / oh);
						y += th - h;
						x += tw - w;
						break;
					}
				}
				this.proxy.setBounds(x, y, w, h);
				if (this.dynamic) {
					this.resizeElement();
				}
			} catch (e) {
			}
		}
	},
	handleOver : function() {
		if (this.enabled) {
			this.el.addClass("x-resizable-over");
		}
	},
	handleOut : function() {
		if (!this.resizing) {
			this.el.removeClass("x-resizable-over");
		}
	},
	getEl : function() {
		return this.el;
	},
	getResizeChild : function() {
		return this.resizeChild;
	},
	destroy : function(_3c) {
		this.proxy.remove();
		this.overlay.removeAllListeners();
		this.overlay.remove();
		var ps = Ext.Resizable.positions;
		for ( var k in ps) {
			if (typeof ps[k] != "function" && this[ps[k]]) {
				var h = this[ps[k]];
				h.el.removeAllListeners();
				h.el.remove();
			}
		}
		if (_3c) {
			this.el.update("");
			this.el.remove();
		}
	}
});
Ext.Resizable.positions = {
	n : "north",
	s : "south",
	e : "east",
	w : "west",
	se : "southeast",
	sw : "southwest",
	nw : "northwest",
	ne : "northeast"
};
Ext.Resizable.Handle = function(rz, pos, _42, _43) {
	if (!this.tpl) {
		var tpl = Ext.DomHelper.createTemplate( {
			tag : "div",
			cls : "x-resizable-handle x-resizable-handle-{0}"
		});
		tpl.compile();
		Ext.Resizable.Handle.prototype.tpl = tpl;
	}
	this.position = pos;
	this.rz = rz;
	this.el = this.tpl.append(rz.el.dom, [ this.position ], true);
	this.el.unselectable();
	if (_43) {
		this.el.setOpacity(0);
	}
	this.el.on("mousedown", this.onMouseDown, this);
	if (!_42) {
		this.el.on("mouseover", this.onMouseOver, this);
		this.el.on("mouseout", this.onMouseOut, this);
	}
};
Ext.Resizable.Handle.prototype = {
	afterResize : function(rz) {
	},
	onMouseDown : function(e) {
		this.rz.onMouseDown(this, e);
	},
	onMouseOver : function(e) {
		this.rz.handleOver(this, e);
	},
	onMouseOut : function(e) {
		this.rz.handleOut(this, e);
	}
};

Ext.SplitBar = function(_1, _2, _3, _4, _5) {
	this.el = Ext.get(_1, true);
	this.el.dom.unselectable = "on";
	this.resizingEl = Ext.get(_2, true);
	this.orientation = _3 || Ext.SplitBar.HORIZONTAL;
	this.minSize = 0;
	this.maxSize = 2000;
	this.animate = false;
	this.useShim = false;
	this.shim = null;
	if (!_5) {
		this.proxy = Ext.SplitBar.createProxy(this.orientation);
	} else {
		this.proxy = Ext.get(_5).dom;
	}
	this.dd = new Ext.dd.DDProxy(this.el.dom.id, "XSplitBars", {
		dragElId : this.proxy.id
	});
	this.dd.b4StartDrag = this.onStartProxyDrag.createDelegate(this);
	this.dd.endDrag = this.onEndProxyDrag.createDelegate(this);
	this.dragSpecs = {};
	this.adapter = new Ext.SplitBar.BasicLayoutAdapter();
	this.adapter.init(this);
	if (this.orientation == Ext.SplitBar.HORIZONTAL) {
		this.placement = _4
				|| (this.el.getX() > this.resizingEl.getX() ? Ext.SplitBar.LEFT
						: Ext.SplitBar.RIGHT);
		this.el.addClass("x-splitbar-h");
	} else {
		this.placement = _4
				|| (this.el.getY() > this.resizingEl.getY() ? Ext.SplitBar.TOP
						: Ext.SplitBar.BOTTOM);
		this.el.addClass("x-splitbar-v");
	}
	this.events = {
		"resize" : true,
		"moved" : true,
		"beforeresize" : true
	};
	Ext.SplitBar.superclass.constructor.call(this);
};
Ext.extend(Ext.SplitBar, Ext.util.Observable, {
	onStartProxyDrag : function(x, y) {
		this.fireEvent("beforeresize", this);
		if (!this.overlay) {
			var o = Ext.DomHelper.insertFirst(document.body, {
				cls : "x-drag-overlay",
				html : "&#160;"
			}, true);
			o.unselectable();
			o.enableDisplayMode("block");
			Ext.SplitBar.prototype.overlay = o;
		}
		this.overlay.setSize(Ext.lib.Dom.getViewWidth(true), Ext.lib.Dom
				.getViewHeight(true));
		this.overlay.show();
		Ext.get(this.proxy).setDisplayed("block");
		var _9 = this.adapter.getElementSize(this);
		this.activeMinSize = this.getMinimumSize();
		this.activeMaxSize = this.getMaximumSize();
		var c1 = _9 - this.activeMinSize;
		var c2 = Math.max(this.activeMaxSize - _9, 0);
		if (this.orientation == Ext.SplitBar.HORIZONTAL) {
			this.dd.resetConstraints();
			this.dd.setXConstraint(this.placement == Ext.SplitBar.LEFT ? c1
					: c2, this.placement == Ext.SplitBar.LEFT ? c2 : c1);
			this.dd.setYConstraint(0, 0);
		} else {
			this.dd.resetConstraints();
			this.dd.setXConstraint(0, 0);
			this.dd.setYConstraint(
					this.placement == Ext.SplitBar.TOP ? c1 : c2,
					this.placement == Ext.SplitBar.TOP ? c2 : c1);
		}
		this.dragSpecs.startSize = _9;
		this.dragSpecs.startPoint = [ x, y ];
		Ext.dd.DDProxy.prototype.b4StartDrag.call(this.dd, x, y);
	},
	onEndProxyDrag : function(e) {
		Ext.get(this.proxy).setDisplayed(false);
		var _d = Ext.lib.Event.getXY(e);
		if (this.overlay) {
			this.overlay.hide();
		}
		var _e;
		if (this.orientation == Ext.SplitBar.HORIZONTAL) {
			_e = this.dragSpecs.startSize
					+ (this.placement == Ext.SplitBar.LEFT ? _d[0]
							- this.dragSpecs.startPoint[0]
							: this.dragSpecs.startPoint[0] - _d[0]);
		} else {
			_e = this.dragSpecs.startSize
					+ (this.placement == Ext.SplitBar.TOP ? _d[1]
							- this.dragSpecs.startPoint[1]
							: this.dragSpecs.startPoint[1] - _d[1]);
		}
		_e = Math.min(Math.max(_e, this.activeMinSize), this.activeMaxSize);
		if (_e != this.dragSpecs.startSize) {
			this.adapter.setElementSize(this, _e);
			this.fireEvent("moved", this, _e);
			this.fireEvent("resize", this, _e);
		}
	},
	getAdapter : function() {
		return this.adapter;
	},
	setAdapter : function(_f) {
		this.adapter = _f;
		this.adapter.init(this);
	},
	getMinimumSize : function() {
		return this.minSize;
	},
	setMinimumSize : function(_10) {
		this.minSize = _10;
	},
	getMaximumSize : function() {
		return this.maxSize;
	},
	setMaximumSize : function(_11) {
		this.maxSize = _11;
	},
	setCurrentSize : function(_12) {
		var _13 = this.animate;
		this.animate = false;
		this.adapter.setElementSize(this, _12);
		this.animate = _13;
	},
	destroy : function(_14) {
		if (this.shim) {
			this.shim.remove();
		}
		this.dd.unreg();
		this.proxy.parentNode.removeChild(this.proxy);
		if (_14) {
			this.el.remove();
		}
	}
});
Ext.SplitBar.createProxy = function(dir) {
	var _16 = new Ext.Element(document.createElement("div"));
	_16.unselectable();
	var cls = "x-splitbar-proxy";
	_16.addClass(cls + " "
			+ (dir == Ext.SplitBar.HORIZONTAL ? cls + "-h" : cls + "-v"));
	document.body.appendChild(_16.dom);
	return _16.dom;
};
Ext.SplitBar.BasicLayoutAdapter = function() {
};
Ext.SplitBar.BasicLayoutAdapter.prototype = {
	init : function(s) {
	},
	getElementSize : function(s) {
		if (s.orientation == Ext.SplitBar.HORIZONTAL) {
			return s.resizingEl.getWidth();
		} else {
			return s.resizingEl.getHeight();
		}
	},
	setElementSize : function(s, _1b, _1c) {
		if (s.orientation == Ext.SplitBar.HORIZONTAL) {
			if (!s.animate) {
				s.resizingEl.setWidth(_1b);
				if (_1c) {
					_1c(s, _1b);
				}
			} else {
				s.resizingEl.setWidth(_1b, true, 0.1, _1c, "easeOut");
			}
		} else {
			if (!s.animate) {
				s.resizingEl.setHeight(_1b);
				if (_1c) {
					_1c(s, _1b);
				}
			} else {
				s.resizingEl.setHeight(_1b, true, 0.1, _1c, "easeOut");
			}
		}
	}
};
Ext.SplitBar.AbsoluteLayoutAdapter = function(_1d) {
	this.basic = new Ext.SplitBar.BasicLayoutAdapter();
	this.container = Ext.get(_1d);
};
Ext.SplitBar.AbsoluteLayoutAdapter.prototype = {
	init : function(s) {
		this.basic.init(s);
	},
	getElementSize : function(s) {
		return this.basic.getElementSize(s);
	},
	setElementSize : function(s, _21, _22) {
		this.basic.setElementSize(s, _21, this.moveSplitter.createDelegate(
				this, [ s ]));
	},
	moveSplitter : function(s) {
		var yes = Ext.SplitBar;
		switch (s.placement) {
		case yes.LEFT:
			s.el.setX(s.resizingEl.getRight());
			break;
		case yes.RIGHT:
			s.el.setStyle("right", (this.container.getWidth() - s.resizingEl
					.getLeft())
					+ "px");
			break;
		case yes.TOP:
			s.el.setY(s.resizingEl.getBottom());
			break;
		case yes.BOTTOM:
			s.el.setY(s.resizingEl.getTop() - s.el.getHeight());
			break;
		}
	}
};
Ext.SplitBar.VERTICAL = 1;
Ext.SplitBar.HORIZONTAL = 2;
Ext.SplitBar.LEFT = 1;
Ext.SplitBar.RIGHT = 2;
Ext.SplitBar.TOP = 3;
Ext.SplitBar.BOTTOM = 4;

Ext.Editor = function(_1, _2) {
	Ext.Editor.superclass.constructor.call(this, _2);
	this.field = _1;
	this.addEvents( {
		"beforestartedit" : true,
		"startedit" : true,
		"beforecomplete" : true,
		"complete" : true,
		"specialkey" : true
	});
};
Ext
		.extend(Ext.Editor, Ext.Component,
				{
					value : "",
					alignment : "c-c?",
					shadow : "frame",
					updateEl : false,
					onRender : function(ct) {
						this.el = new Ext.Layer( {
							shadow : this.shadow,
							cls : "x-editor",
							parentEl : ct,
							shim : this.shim,
							shadowOffset : 3,
							id : this.id
						});
						this.el.setStyle("overflow", Ext.isGecko ? "auto"
								: "hidden");
						this.field.render(this.el);
						if (Ext.isGecko) {
							this.field.el.dom.setAttribute("autocomplete",
									"off");
						}
						this.field.show();
						this.field.on("blur", this.onBlur, this);
						this.relayEvents(this.field, [ "specialkey" ]);
						if (this.field.grow) {
							this.field.on("autosize", this.el.sync, this.el, {
								delay : 1
							});
						}
					},
					startEdit : function(el, _5) {
						if (this.editing) {
							this.completeEdit();
						}
						this.boundEl = Ext.get(el);
						var v = _5 !== undefined ? _5
								: this.boundEl.dom.innerHTML;
						if (!this.rendered) {
							this.render(this.parentEl || document.body);
						}
						if (this.fireEvent("beforestartedit", this,
								this.boundEl, v) === false) {
							return;
						}
						this.startValue = v;
						this.field.setValue(v);
						if (this.autoSize) {
							var sz = this.boundEl.getSize();
							switch (this.autoSize) {
							case "width":
								this.setSize(sz.width, "");
								break;
							case "height":
								this.setSize("", sz.height);
								break;
							default:
								this.setSize(sz.width, sz.height);
							}
						}
						this.el.alignTo(this.boundEl, this.alignment);
						this.editing = true;
						if (Ext.QuickTips) {
							Ext.QuickTips.disable();
						}
						this.show();
					},
					setSize : function(w, h) {
						this.field.setSize(w, h);
						if (this.el) {
							this.el.sync();
						}
					},
					realign : function() {
						this.el.alignTo(this.boundEl, this.alignment);
					},
					completeEdit : function(_a) {
						if (!this.editing) {
							return;
						}
						var v = this.getValue();
						if (this.revertInvalid !== false
								&& !this.field.isValid()) {
							v = this.startValue;
							this.cancelEdit(true);
						}
						if (String(v) == String(this.startValue)
								&& this.ignoreNoChange) {
							this.editing = false;
							this.hide();
							return;
						}
						if (this.fireEvent("beforecomplete", this, v,
								this.startValue) !== false) {
							this.editing = false;
							if (this.updateEl && this.boundEl) {
								this.boundEl.update(v);
							}
							if (_a !== true) {
								this.hide();
							}
							this
									.fireEvent("complete", this, v,
											this.startValue);
						}
					},
					onShow : function() {
						this.el.show();
						if (this.hideEl !== false) {
							this.boundEl.hide();
						}
						this.field.show();
						this.field.focus();
						this.fireEvent("startedit", this.boundEl,
								this.startValue);
					},
					cancelEdit : function(_c) {
						if (this.editing) {
							this.setValue(this.startValue);
							if (_c !== true) {
								this.hide();
							}
						}
					},
					onBlur : function() {
						if (this.allowBlur !== true && this.editing) {
							this.completeEdit();
						}
					},
					onHide : function() {
						if (this.editing) {
							this.completeEdit();
							return;
						}
						this.field.blur();
						if (this.field.collapse) {
							this.field.collapse();
						}
						this.el.hide();
						if (this.hideEl !== false) {
							this.boundEl.show();
						}
						if (Ext.QuickTips) {
							Ext.QuickTips.enable();
						}
					},
					setValue : function(v) {
						this.field.setValue(v);
					},
					getValue : function() {
						return this.field.getValue();
					}
				});

Ext.BasicDialog = function(el, _2) {
	this.el = Ext.get(el);
	var dh = Ext.DomHelper;
	if (!this.el && _2 && _2.autoCreate) {
		if (typeof _2.autoCreate == "object") {
			if (!_2.autoCreate.id) {
				_2.autoCreate.id = el;
			}
			this.el = dh.append(document.body, _2.autoCreate, true);
		} else {
			this.el = dh.append(document.body, {
				tag : "div",
				id : el,
				style : "visibility:hidden;"
			}, true);
		}
	}
	el = this.el;
	el.setDisplayed(true);
	el.hide = this.hideAction;
	this.id = el.id;
	el.addClass("x-dlg");
	Ext.apply(this, _2);
	this.proxy = el.createProxy("x-dlg-proxy");
	this.proxy.hide = this.hideAction;
	this.proxy.setOpacity(0.5);
	this.proxy.hide();
	if (_2.width) {
		el.setWidth(_2.width);
	}
	if (_2.height) {
		el.setHeight(_2.height);
	}
	this.size = el.getSize();
	if (typeof _2.x != "undefined" && typeof _2.y != "undefined") {
		this.xy = [ _2.x, _2.y ];
	} else {
		this.xy = el.getCenterXY(true);
	}
	this.header = el.child("/.x-dlg-hd");
	this.body = el.child("/.x-dlg-bd");
	this.footer = el.child("/.x-dlg-ft");
	if (!this.header) {
		this.header = el.createChild( {
			tag : "div",
			cls : "x-dlg-hd",
			html : "&#160;"
		}, this.body ? this.body.dom : null);
	}
	if (!this.body) {
		this.body = el.createChild( {
			tag : "div",
			cls : "x-dlg-bd"
		});
	}
	this.header.unselectable();
	if (this.title) {
		this.header.update(this.title);
	}
	this.focusEl = el.createChild( {
		tag : "a",
		href : "#",
		cls : "x-dlg-focus",
		tabIndex : "-1"
	});
	this.focusEl.swallowEvent("click", true);
	this.header.wrap( {
		cls : "x-dlg-hd-right"
	}).wrap( {
		cls : "x-dlg-hd-left"
	}, true);
	this.bwrap = this.body.wrap( {
		tag : "div",
		cls : "x-dlg-dlg-body"
	});
	if (this.footer) {
		this.bwrap.dom.appendChild(this.footer.dom);
	}
	this.bg = this.el
			.createChild( {
				tag : "div",
				cls : "x-dlg-bg",
				html : "<div class=\"x-dlg-bg-left\"><div class=\"x-dlg-bg-right\"><div class=\"x-dlg-bg-center\">&#160;</div></div></div>"
			});
	this.centerBg = this.bg.child("div.x-dlg-bg-center");
	if (this.autoScroll !== false && !this.autoTabs) {
		this.body.setStyle("overflow", "auto");
	}
	this.toolbox = this.el.createChild( {
		cls : "x-dlg-toolbox"
	});
	if (this.closable !== false) {
		this.el.addClass("x-dlg-closable");
		this.close = this.toolbox.createChild( {
			cls : "x-dlg-close"
		});
		this.close.on("click", this.closeClick, this);
		this.close.addClassOnOver("x-dlg-close-over");
	}
	if (this.collapsible !== false) {
		this.collapseBtn = this.toolbox.createChild( {
			cls : "x-dlg-collapse"
		});
		this.collapseBtn.on("click", this.collapseClick, this);
		this.collapseBtn.addClassOnOver("x-dlg-collapse-over");
		this.header.on("dblclick", this.collapseClick, this);
	}
	if (this.resizable !== false) {
		this.el.addClass("x-dlg-resizable");
		this.resizer = new Ext.Resizable(el, {
			minWidth : this.minWidth || 80,
			minHeight : this.minHeight || 80,
			handles : this.resizeHandles || "all",
			pinned : true
		});
		this.resizer.on("beforeresize", this.beforeResize, this);
		this.resizer.on("resize", this.onResize, this);
	}
	if (this.draggable !== false) {
		el.addClass("x-dlg-draggable");
		if (!this.proxyDrag) {
			var dd = new Ext.dd.DD(el.dom.id, "WindowDrag");
		} else {
			var dd = new Ext.dd.DDProxy(el.dom.id, "WindowDrag", {
				dragElId : this.proxy.id
			});
		}
		dd.setHandleElId(this.header.id);
		dd.endDrag = this.endMove.createDelegate(this);
		dd.startDrag = this.startMove.createDelegate(this);
		dd.onDrag = this.onDrag.createDelegate(this);
		dd.scroll = false;
		this.dd = dd;
	}
	if (this.modal) {
		this.mask = dh.append(document.body, {
			tag : "div",
			cls : "x-dlg-mask"
		}, true);
		this.mask.enableDisplayMode("block");
		this.mask.hide();
		this.el.addClass("x-dlg-modal");
	}
	if (this.shadow) {
		this.shadow = new Ext.Shadow( {
			mode : typeof this.shadow == "string" ? this.shadow : "sides",
			offset : this.shadowOffset
		});
	} else {
		this.shadowOffset = 0;
	}
	if (Ext.useShims && this.shim !== false) {
		this.shim = this.el.createShim();
		this.shim.hide = this.hideAction;
		this.shim.hide();
	} else {
		this.shim = false;
	}
	if (this.autoTabs) {
		this.initTabs();
	}
	this.events = {
		"keydown" : true,
		"move" : true,
		"resize" : true,
		"beforehide" : true,
		"hide" : true,
		"beforeshow" : true,
		"show" : true
	};
	el.on("keydown", this.onKeyDown, this);
	el.on("mousedown", this.toFront, this);
	Ext.EventManager.onWindowResize(this.adjustViewport, this, true);
	this.el.hide();
	Ext.DialogManager.register(this);
	Ext.BasicDialog.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.BasicDialog,
				Ext.util.Observable,
				{
					shadowOffset : 5,
					minHeight : 80,
					minWidth : 200,
					minButtonWidth : 75,
					defaultButton : null,
					buttonAlign : "right",
					tabTag : "div",
					firstShow : true,
					setTitle : function(_5) {
						this.header.update(_5);
						return this;
					},
					closeClick : function() {
						this.hide();
					},
					collapseClick : function() {
						this[this.collapsed ? "expand" : "collapse"]();
					},
					collapse : function() {
						if (!this.collapsed) {
							this.collapsed = true;
							this.el.addClass("x-dlg-collapsed");
							this.restoreHeight = this.el.getHeight();
							this.resizeTo(this.el.getWidth(), this.header
									.getHeight());
						}
					},
					expand : function() {
						if (this.collapsed) {
							this.collapsed = false;
							this.el.removeClass("x-dlg-collapsed");
							this.resizeTo(this.el.getWidth(),
									this.restoreHeight);
						}
					},
					initTabs : function() {
						var _6 = this.getTabs();
						while (_6.getTab(0)) {
							_6.removeTab(0);
						}
						this.el.select(this.tabTag + ".x-dlg-tab").each(
								function(el) {
									var _8 = el.dom;
									_6.addTab(Ext.id(_8), _8.title);
									_8.title = "";
								});
						_6.activate(0);
						return _6;
					},
					beforeResize : function() {
						this.resizer.minHeight = Math.max(this.minHeight, this
								.getHeaderFooterHeight(true) + 40);
					},
					onResize : function() {
						this.refreshSize();
						this.syncBodyHeight();
						this.adjustAssets();
						this.focus();
						this.fireEvent("resize", this, this.size.width,
								this.size.height);
					},
					onKeyDown : function(e) {
						if (this.isVisible()) {
							this.fireEvent("keydown", this, e);
						}
					},
					resizeTo : function(_a, _b) {
						this.el.setSize(_a, _b);
						this.size = {
							width : _a,
							height : _b
						};
						this.syncBodyHeight();
						if (this.fixedcenter) {
							this.center();
						}
						if (this.isVisible()) {
							this.constrainXY();
							this.adjustAssets();
						}
						this.fireEvent("resize", this, _a, _b);
						return this;
					},
					setContentSize : function(w, h) {
						h += this.getHeaderFooterHeight()
								+ this.body.getMargins("tb");
						w += this.body.getMargins("lr")
								+ this.bwrap.getMargins("lr")
								+ this.centerBg.getPadding("lr");
						h += this.body.getPadding("tb")
								+ this.bwrap.getBorderWidth("tb")
								+ this.body.getBorderWidth("tb")
								+ this.el.getBorderWidth("tb");
						w += this.body.getPadding("lr")
								+ this.bwrap.getBorderWidth("lr")
								+ this.body.getBorderWidth("lr")
								+ this.bwrap.getPadding("lr")
								+ this.el.getBorderWidth("lr");
						if (this.tabs) {
							h += this.tabs.stripWrap.getHeight()
									+ this.tabs.bodyEl.getMargins("tb")
									+ this.tabs.bodyEl.getPadding("tb");
							w += this.tabs.bodyEl.getMargins("lr")
									+ this.tabs.bodyEl.getPadding("lr");
						}
						this.resizeTo(w, h);
						return this;
					},
					addKeyListener : function(_e, fn, _10) {
						var _11, _12, _13, alt;
						if (typeof _e == "object" && !(_e instanceof Array)) {
							_11 = _e["key"];
							_12 = _e["shift"];
							_13 = _e["ctrl"];
							alt = _e["alt"];
						} else {
							_11 = _e;
						}
						var _15 = function(dlg, e) {
							if ((!_12 || e.shiftKey) && (!_13 || e.ctrlKey)
									&& (!alt || e.altKey)) {
								var k = e.getKey();
								if (_11 instanceof Array) {
									for ( var i = 0, len = _11.length; i < len; i++) {
										if (_11[i] == k) {
											fn.call(_10 || window, dlg, k, e);
											return;
										}
									}
								} else {
									if (k == _11) {
										fn.call(_10 || window, dlg, k, e);
									}
								}
							}
						};
						this.on("keydown", _15);
						return this;
					},
					getTabs : function() {
						if (!this.tabs) {
							this.el.addClass("x-dlg-auto-tabs");
							this.body
									.addClass(this.tabPosition == "bottom" ? "x-tabs-bottom"
											: "x-tabs-top");
							this.tabs = new Ext.TabPanel(this.body.dom,
									this.tabPosition == "bottom");
						}
						return this.tabs;
					},
					addButton : function(_1b, _1c, _1d) {
						var dh = Ext.DomHelper;
						if (!this.footer) {
							this.footer = dh.append(this.bwrap, {
								tag : "div",
								cls : "x-dlg-ft"
							}, true);
						}
						if (!this.btnContainer) {
							var tb = this.footer
									.createChild(
											{
												tag : "div",
												cls : "x-dlg-btns x-dlg-btns-"
														+ this.buttonAlign,
												html : "<table cellspacing=\"0\"><tbody><tr></tr></tbody></table><div class=\"x-clear\"></div>"
											}, null, true);
							this.btnContainer = tb.firstChild.firstChild.firstChild;
						}
						var _20 = {
							handler : _1c,
							scope : _1d,
							minWidth : this.minButtonWidth,
							hideParent : true
						};
						if (typeof _1b == "string") {
							_20.text = _1b;
						} else {
							if (_1b.tag) {
								_20.dhconfig = _1b;
							} else {
								Ext.apply(_20, _1b);
							}
						}
						var btn = new Ext.Button(this.btnContainer
								.appendChild(document.createElement("td")), _20);
						this.syncBodyHeight();
						if (!this.buttons) {
							this.buttons = [];
						}
						this.buttons.push(btn);
						return btn;
					},
					setDefaultButton : function(btn) {
						this.defaultButton = btn;
						return this;
					},
					getHeaderFooterHeight : function(_23) {
						var _24 = 0;
						if (this.header) {
							_24 += this.header.getHeight();
						}
						if (this.footer) {
							var fm = this.footer.getMargins();
							_24 += (this.footer.getHeight() + fm.top + fm.bottom);
						}
						_24 += this.bwrap.getPadding("tb")
								+ this.bwrap.getBorderWidth("tb");
						_24 += this.centerBg.getPadding("tb");
						return _24;
					},
					syncBodyHeight : function() {
						var bd = this.body, cb = this.centerBg, bw = this.bwrap;
						var _29 = this.size.height
								- this.getHeaderFooterHeight(false);
						bd.setHeight(_29 - bd.getMargins("tb"));
						var hh = this.header.getHeight();
						var h = this.size.height - hh;
						cb.setHeight(h);
						bw.setLeftTop(cb.getPadding("l"), hh
								+ cb.getPadding("t"));
						bw.setHeight(h - cb.getPadding("tb"));
						bw.setWidth(this.el.getWidth(true)
								- cb.getPadding("lr"));
						bd.setWidth(bw.getWidth(true));
						if (this.tabs) {
							this.tabs.syncHeight();
							if (Ext.isIE) {
								this.tabs.el.repaint();
							}
						}
					},
					restoreState : function() {
						var box = Ext.state.Manager.get(this.stateId
								|| (this.el.id + "-state"));
						if (box && box.width) {
							this.xy = [ box.x, box.y ];
							this.resizeTo(box.width, box.height);
						}
						return this;
					},
					beforeShow : function() {
						this.expand();
						if (this.fixedcenter) {
							this.xy = this.el.getCenterXY(true);
						}
						if (this.modal) {
							Ext.get(document.body).addClass("x-body-masked");
							this.mask.setSize(Ext.lib.Dom.getViewWidth(true),
									Ext.lib.Dom.getViewHeight(true));
							this.mask.show();
						}
						this.constrainXY();
					},
					animShow : function() {
						var b = Ext.get(this.animateTarget, true).getBox();
						this.proxy.setSize(b.width, b.height);
						this.proxy.setLocation(b.x, b.y);
						this.proxy.show();
						this.proxy.setBounds(this.xy[0], this.xy[1],
								this.size.width, this.size.height, true, 0.35,
								this.showEl.createDelegate(this));
					},
					show : function(_2e) {
						if (this.fireEvent("beforeshow", this) === false) {
							return;
						}
						if (this.syncHeightBeforeShow) {
							this.syncBodyHeight();
						} else {
							if (this.firstShow) {
								this.firstShow = false;
								this.syncBodyHeight();
							}
						}
						this.animateTarget = _2e || this.animateTarget;
						if (!this.el.isVisible()) {
							this.beforeShow();
							if (this.animateTarget) {
								this.animShow();
							} else {
								this.showEl();
							}
						}
						return this;
					},
					showEl : function() {
						this.proxy.hide();
						this.el.setXY(this.xy);
						this.el.show();
						this.adjustAssets(true);
						this.toFront();
						this.focus();
						this.fireEvent("show", this);
					},
					focus : function() {
						if (this.defaultButton) {
							this.defaultButton.focus();
						} else {
							this.focusEl.focus();
						}
					},
					constrainXY : function() {
						if (this.constraintoviewport !== false) {
							if (!this.viewSize) {
								if (this.container) {
									var s = this.container.getSize();
									this.viewSize = [ s.width, s.height ];
								} else {
									this.viewSize = [
											Ext.lib.Dom.getViewWidth(),
											Ext.lib.Dom.getViewHeight() ];
								}
							}
							var s = Ext.get(this.container || document)
									.getScroll();
							var x = this.xy[0], y = this.xy[1];
							var w = this.size.width, h = this.size.height;
							var vw = this.viewSize[0], vh = this.viewSize[1];
							var _36 = false;
							if (x + w > vw + s.left) {
								x = vw - w;
								_36 = true;
							}
							if (y + h > vh + s.top) {
								y = vh - h;
								_36 = true;
							}
							if (x < s.left) {
								x = s.left;
								_36 = true;
							}
							if (y < s.top) {
								y = s.top;
								_36 = true;
							}
							if (_36) {
								this.xy = [ x, y ];
								if (this.isVisible()) {
									this.el.setLocation(x, y);
									this.adjustAssets();
								}
							}
						}
					},
					onDrag : function() {
						if (!this.proxyDrag) {
							this.xy = this.el.getXY();
							this.adjustAssets();
						}
					},
					adjustAssets : function(_37) {
						var x = this.xy[0], y = this.xy[1];
						var w = this.size.width, h = this.size.height;
						if (_37 === true) {
							if (this.shadow) {
								this.shadow.show(this.el);
							}
							if (this.shim) {
								this.shim.show();
							}
						}
						if (this.shadow && this.shadow.isVisible()) {
							this.shadow.show(this.el);
						}
						if (this.shim && this.shim.isVisible()) {
							this.shim.setBounds(x, y, w, h);
						}
					},
					adjustViewport : function(w, h) {
						if (!w || !h) {
							w = Ext.lib.Dom.getViewWidth();
							h = Ext.lib.Dom.getViewHeight();
						}
						this.viewSize = [ w, h ];
						if (this.modal && this.mask.isVisible()) {
							this.mask.setSize(w, h);
							this.mask.setSize(Ext.lib.Dom.getViewWidth(true),
									Ext.lib.Dom.getViewHeight(true));
						}
						if (this.isVisible()) {
							this.constrainXY();
						}
					},
					destroy : function(_3e) {
						if (this.isVisible()) {
							this.animateTarget = null;
							this.hide();
						}
						Ext.EventManager.removeResizeListener(
								this.adjustViewport, this);
						if (this.tabs) {
							this.tabs.destroy(_3e);
						}
						if (this.shim) {
							this.shim.remove();
						}
						if (this.proxy) {
							this.proxy.remove();
						}
						if (this.resizer) {
							this.resizer.destroy();
						}
						if (this.close) {
							this.close.removeAllListeners();
							this.close.remove();
						}
						if (this.mask) {
							this.mask.remove();
						}
						if (this.dd) {
							this.dd.unreg();
						}
						if (this.buttons) {
							for ( var i = 0, len = this.buttons.length; i < len; i++) {
								this.buttons[i].destroy();
							}
						}
						this.el.removeAllListeners();
						if (_3e === true) {
							this.el.update("");
							this.el.remove();
						}
						Ext.DialogManager.unregister(this);
					},
					startMove : function() {
						if (this.proxyDrag) {
							this.proxy.show();
						}
						if (this.constraintoviewport !== false) {
							this.dd.constrainTo(document.body, {
								right : this.shadowOffset,
								bottom : this.shadowOffset
							});
						}
					},
					endMove : function() {
						if (!this.proxyDrag) {
							Ext.dd.DD.prototype.endDrag.apply(this.dd,
									arguments);
						} else {
							Ext.dd.DDProxy.prototype.endDrag.apply(this.dd,
									arguments);
							this.proxy.hide();
						}
						this.refreshSize();
						this.adjustAssets();
						this.focus();
						this.fireEvent("move", this, this.xy[0], this.xy[1]);
					},
					toFront : function() {
						Ext.DialogManager.bringToFront(this);
						return this;
					},
					toBack : function() {
						Ext.DialogManager.sendToBack(this);
						return this;
					},
					center : function() {
						var xy = this.el.getCenterXY(true);
						this.moveTo(xy[0], xy[1]);
						return this;
					},
					moveTo : function(x, y) {
						this.xy = [ x, y ];
						if (this.isVisible()) {
							this.el.setXY(this.xy);
							this.adjustAssets();
						}
						return this;
					},
					alignTo : function(_44, _45, _46) {
						this.xy = this.el.getAlignToXY(_44, _45, _46);
						if (this.isVisible()) {
							this.el.setXY(this.xy);
							this.adjustAssets();
						}
						return this;
					},
					anchorTo : function(el, _48, _49, _4a) {
						var _4b = function() {
							this.alignTo(el, _48, _49);
						};
						Ext.EventManager.onWindowResize(_4b, this);
						var tm = typeof _4a;
						if (tm != "undefined") {
							Ext.EventManager.on(window, "scroll", _4b, this, {
								buffer : tm == "number" ? _4a : 50
							});
						}
						_4b.call(this);
						return this;
					},
					isVisible : function() {
						return this.el.isVisible();
					},
					animHide : function(_4d) {
						var b = Ext.get(this.animateTarget).getBox();
						this.proxy.show();
						this.proxy.setBounds(this.xy[0], this.xy[1],
								this.size.width, this.size.height);
						this.el.hide();
						this.proxy
								.setBounds(b.x, b.y, b.width, b.height, true,
										0.35, this.hideEl.createDelegate(this,
												[ _4d ]));
					},
					hide : function(_4f) {
						if (this.fireEvent("beforehide", this) === false) {
							return;
						}
						if (this.shadow) {
							this.shadow.hide();
						}
						if (this.shim) {
							this.shim.hide();
						}
						if (this.animateTarget) {
							this.animHide(_4f);
						} else {
							this.el.hide();
							this.hideEl(_4f);
						}
						return this;
					},
					hideEl : function(_50) {
						this.proxy.hide();
						if (this.modal) {
							this.mask.hide();
							Ext.get(document.body).removeClass("x-body-masked");
						}
						this.fireEvent("hide", this);
						if (typeof _50 == "function") {
							_50();
						}
					},
					hideAction : function() {
						this.setLeft("-10000px");
						this.setTop("-10000px");
						this.setStyle("visibility", "hidden");
					},
					refreshSize : function() {
						this.size = this.el.getSize();
						this.xy = this.el.getXY();
						Ext.state.Manager.set(this.stateId || this.el.id
								+ "-state", this.el.getBox());
					},
					setZIndex : function(_51) {
						if (this.modal) {
							this.mask.setStyle("z-index", _51);
						}
						if (this.shim) {
							this.shim.setStyle("z-index", ++_51);
						}
						if (this.shadow) {
							this.shadow.setZIndex(++_51);
						}
						this.el.setStyle("z-index", ++_51);
						if (this.proxy) {
							this.proxy.setStyle("z-index", ++_51);
						}
						if (this.resizer) {
							this.resizer.proxy.setStyle("z-index", ++_51);
						}
						this.lastZIndex = _51;
					},
					getEl : function() {
						return this.el;
					}
				});
Ext.DialogManager = function() {
	var _52 = {};
	var _53 = [];
	var _54 = null;
	var _55 = function(d1, d2) {
		return (!d1._lastAccess || d1._lastAccess < d2._lastAccess) ? -1 : 1;
	};
	var _58 = function() {
		_53.sort(_55);
		var _59 = Ext.DialogManager.zseed;
		for ( var i = 0, len = _53.length; i < len; i++) {
			if (_53[i]) {
				_53[i].setZIndex(_59 + (i * 10));
			}
		}
	};
	return {
		zseed : 9000,
		register : function(dlg) {
			_52[dlg.id] = dlg;
			_53.push(dlg);
		},
		unregister : function(dlg) {
			delete _52[dlg.id];
			if (!_53.indexOf) {
				for ( var i = 0, len = _53.length; i < len; i++) {
					if (_53[i] == dlg) {
						_53.splice(i, 1);
						return;
					}
				}
			} else {
				var i = _53.indexOf(dlg);
				if (i != -1) {
					_53.splice(i, 1);
				}
			}
		},
		get : function(id) {
			return typeof id == "object" ? id : _52[id];
		},
		bringToFront : function(dlg) {
			dlg = this.get(dlg);
			if (dlg != _54) {
				_54 = dlg;
				dlg._lastAccess = new Date().getTime();
				_58();
			}
			return dlg;
		},
		sendToBack : function(dlg) {
			dlg = this.get(dlg);
			dlg._lastAccess = -(new Date().getTime());
			_58();
			return dlg;
		},
		hideAll : function() {
			for ( var id in _52) {
				if (_52[id] && typeof _52[id] != "function"
						&& _52[id].isVisible()) {
					_52[id].hide();
				}
			}
		}
	};
}();
Ext.LayoutDialog = function(el, _65) {
	_65.autoTabs = false;
	Ext.LayoutDialog.superclass.constructor.call(this, el, _65);
	this.body.setStyle( {
		overflow : "hidden",
		position : "relative"
	});
	this.layout = new Ext.BorderLayout(this.body.dom, _65);
	this.layout.monitorWindowResize = false;
	this.el.addClass("x-dlg-auto-layout");
	this.center = Ext.BasicDialog.prototype.center;
	this.on("show", this.layout.layout, this.layout, true);
};
Ext.extend(Ext.LayoutDialog, Ext.BasicDialog, {
	endUpdate : function() {
		this.layout.endUpdate();
	},
	beginUpdate : function() {
		this.layout.beginUpdate();
	},
	getLayout : function() {
		return this.layout;
	},
	showEl : function() {
		Ext.LayoutDialog.superclass.showEl.apply(this, arguments);
		if (Ext.isIE7) {
			this.layout.layout();
		}
	},
	syncBodyHeight : function() {
		Ext.LayoutDialog.superclass.syncBodyHeight.call(this);
		if (this.layout) {
			this.layout.layout();
		}
	}
});

Ext.MessageBox = function() {
	var _1, _2, _3, _4;
	var _5, _6, _7, _8, _9, pp;
	var _b, _c, _d;
	var _e = function(_f) {
		_1.hide();
		Ext.callback(_2.fn, _2.scope || window, [ _f, _c.dom.value ], 1);
	};
	var _10 = function() {
		if (_2 && _2.cls) {
			_1.el.removeClass(_2.cls);
		}
		if (_4) {
			Ext.TaskMgr.stop(_4);
			_4 = null;
		}
	};
	var _11 = function(b) {
		var _13 = 0;
		if (!b) {
			_b["ok"].hide();
			_b["cancel"].hide();
			_b["yes"].hide();
			_b["no"].hide();
			_1.footer.dom.style.display = "none";
			return _13;
		}
		_1.footer.dom.style.display = "";
		for ( var k in _b) {
			if (typeof _b[k] != "function") {
				if (b[k]) {
					_b[k].show();
					_b[k].setText(typeof b[k] == "string" ? b[k]
							: Ext.MessageBox.buttonText[k]);
					_13 += _b[k].el.getWidth() + 15;
				} else {
					_b[k].hide();
				}
			}
		}
		return _13;
	};
	var _15 = function(d, k, e) {
		if (_2 && _2.closable !== false) {
			_1.hide();
		}
		if (e) {
			e.stopEvent();
		}
	};
	return {
		getDialog : function() {
			if (!_1) {
				_1 = new Ext.BasicDialog("x-msg-box", {
					autoCreate : true,
					shadow : true,
					draggable : true,
					resizable : false,
					constraintoviewport : false,
					fixedcenter : true,
					collapsible : false,
					shim : true,
					modal : true,
					width : 400,
					height : 100,
					buttonAlign : "center",
					closeClick : function() {
						if (_2 && _2.buttons && _2.buttons.no
								&& !_2.buttons.cancel) {
							_e("no");
						} else {
							_e("cancel");
						}
					}
				});
				_1.on("hide", _10);
				_3 = _1.mask;
				_1.addKeyListener(27, _15);
				_b = {};
				var bt = this.buttonText;
				_b["ok"] = _1.addButton(bt["ok"], _e.createCallback("ok"));
				_b["yes"] = _1.addButton(bt["yes"], _e.createCallback("yes"));
				_b["no"] = _1.addButton(bt["no"], _e.createCallback("no"));
				_b["cancel"] = _1.addButton(bt["cancel"], _e
						.createCallback("cancel"));
				_5 = _1.body
						.createChild( {
							tag : "div",
							html : "<span class=\"ext-mb-text\"></span><br /><input type=\"text\" class=\"ext-mb-input\"><textarea class=\"ext-mb-textarea\"></textarea><div class=\"ext-mb-progress-wrap\"><div class=\"ext-mb-progress\"><div class=\"ext-mb-progress-bar\">&#160;</div></div></div>"
						});
				_6 = _5.dom.firstChild;
				_7 = Ext.get(_5.dom.childNodes[2]);
				_7.enableDisplayMode();
				_7.addKeyListener( [ 10, 13 ], function() {
					if (_1.isVisible() && _2 && _2.buttons) {
						if (_2.buttons.ok) {
							_e("ok");
						} else {
							if (_2.buttons.yes) {
								_e("yes");
							}
						}
					}
				});
				_8 = Ext.get(_5.dom.childNodes[3]);
				_8.enableDisplayMode();
				_9 = Ext.get(_5.dom.childNodes[4]);
				_9.enableDisplayMode();
				var pf = _9.dom.firstChild;
				pp = Ext.get(pf.firstChild);
				pp.setHeight(pf.offsetHeight);
			}
			return _1;
		},
		updateText : function(_1b) {
			if (!_1.isVisible() && !_2.width) {
				_1.resizeTo(this.maxWidth, 100);
			}
			_6.innerHTML = _1b || "&#160;";
			var w = Math.max(Math
					.min(_2.width || _6.offsetWidth, this.maxWidth), Math.max(
					_2.minWidth || this.minWidth, _d));
			if (_2.prompt) {
				_c.setWidth(w);
			}
			if (_1.isVisible()) {
				_1.fixedcenter = false;
			}
			_1.setContentSize(w, _5.getHeight());
			if (_1.isVisible()) {
				_1.fixedcenter = true;
			}
			return this;
		},
		updateProgress : function(_1d, _1e) {
			if (_1e) {
				this.updateText(_1e);
			}
			pp.setWidth(Math.floor(_1d * _9.dom.firstChild.offsetWidth));
			return this;
		},
		isVisible : function() {
			return _1 && _1.isVisible();
		},
		hide : function() {
			if (this.isVisible()) {
				_1.hide();
			}
		},
		show : function(_1f) {
			if (this.isVisible()) {
				this.hide();
			}
			var d = this.getDialog();
			_2 = _1f;
			d.setTitle(_2.title || "&#160;");
			d.close.setDisplayed(_2.closable !== false);
			_c = _7;
			_2.prompt = _2.prompt || (_2.multiline ? true : false);
			if (_2.prompt) {
				if (_2.multiline) {
					_7.hide();
					_8.show();
					_8.setHeight(typeof _2.multiline == "number" ? _2.multiline
							: this.defaultTextHeight);
					_c = _8;
				} else {
					_7.show();
					_8.hide();
				}
			} else {
				_7.hide();
				_8.hide();
			}
			_9.setDisplayed(_2.progress === true);
			this.updateProgress(0);
			_c.dom.value = _2.value || "";
			if (_2.prompt) {
				_1.setDefaultButton(_c);
			} else {
				var bs = _2.buttons;
				var db = null;
				if (bs && bs.ok) {
					db = _b["ok"];
				} else {
					if (bs && bs.yes) {
						db = _b["yes"];
					}
				}
				_1.setDefaultButton(db);
			}
			_d = _11(_2.buttons);
			this.updateText(_2.msg);
			if (_2.cls) {
				d.el.addClass(_2.cls);
			}
			d.proxyDrag = _2.proxyDrag === true;
			d.modal = _2.modal !== false;
			d.mask = _2.modal !== false ? _3 : false;
			if (!d.isVisible()) {
				document.body.appendChild(_1.el.dom);
				d.animateTarget = null;
				d.show(_1f.animEl);
			}
			return this;
		},
		progress : function(_23, msg) {
			this.show( {
				title : _23,
				msg : msg,
				buttons : false,
				progress : true,
				closable : false,
				minWidth : this.minProgressWidth
			});
			return this;
		},
		alert : function(_25, msg, fn, _28) {
			this.show( {
				title : _25,
				msg : msg,
				buttons : this.OK,
				fn : fn,
				scope : _28
			});
			return this;
		},
		wait : function(msg, _2a) {
			this.show( {
				title : _2a,
				msg : msg,
				buttons : false,
				closable : false,
				progress : true,
				modal : true,
				width : 300,
				wait : true
			});
			_4 = Ext.TaskMgr
					.start( {
						run : function(i) {
							Ext.MessageBox
									.updateProgress(((((i + 20) % 20) + 1) * 5) * 0.01);
						},
						interval : 1000
					});
			return this;
		},
		confirm : function(_2c, msg, fn, _2f) {
			this.show( {
				title : _2c,
				msg : msg,
				buttons : this.YESNO,
				fn : fn,
				scope : _2f
			});
			return this;
		},
		prompt : function(_30, msg, fn, _33, _34) {
			this.show( {
				title : _30,
				msg : msg,
				buttons : this.OKCANCEL,
				fn : fn,
				minWidth : 250,
				scope : _33,
				prompt : true,
				multiline : _34
			});
			return this;
		},
		OK : {
			ok : true
		},
		YESNO : {
			yes : true,
			no : true
		},
		OKCANCEL : {
			ok : true,
			cancel : true
		},
		YESNOCANCEL : {
			yes : true,
			no : true,
			cancel : true
		},
		defaultTextHeight : 75,
		maxWidth : 600,
		minWidth : 100,
		minProgressWidth : 250,
		buttonText : {
			ok : "OK",
			cancel : "Cancel",
			yes : "Yes",
			no : "No"
		}
	};
}();
Ext.Msg = Ext.MessageBox;

Ext.QuickTips = function() {
	var el, _2, _3, _4, tm, _6, _7, _8 = {}, _9, _a = null, _b, _c;
	var ce, bd, xy, dd;
	var _11 = false, _12 = true, _13 = false;
	var _14 = 1, _15 = 1, _16 = 1, _17 = [];
	var _18 = function(e) {
		if (_12) {
			return;
		}
		var t = e.getTarget();
		if (!t || t.nodeType !== 1 || t == document || t == document.body) {
			return;
		}
		if (ce && t == ce.el) {
			clearTimeout(_15);
			return;
		}
		if (t && _8[t.id]) {
			_8[t.id].el = t;
			_14 = _1b.defer(tm.showDelay, tm, [ _8[t.id] ]);
			return;
		}
		var ttp, et = Ext.fly(t);
		var ns = _6.namespace;
		if (tm.interceptTitles && t.title) {
			ttp = t.title;
			t.qtip = ttp;
			t.removeAttribute("title");
			e.preventDefault();
		} else {
			ttp = t.qtip || et.getAttributeNS(ns, _6.attribute);
		}
		if (ttp) {
			_14 = _1b.defer(tm.showDelay, tm, [ {
				el : t,
				text : ttp,
				width : et.getAttributeNS(ns, _6.width),
				autoHide : et.getAttributeNS(ns, _6.hide) != "user",
				title : et.getAttributeNS(ns, _6.title),
				cls : et.getAttributeNS(ns, _6.cls)
			} ]);
		}
	};
	var _1f = function(e) {
		clearTimeout(_14);
		var t = e.getTarget();
		if (t && ce && ce.el == t && (tm.autoHide && ce.autoHide !== false)) {
			_15 = setTimeout(_22, tm.hideDelay);
		}
	};
	var _23 = function(e) {
		if (_12) {
			return;
		}
		xy = e.getXY();
		xy[1] += 18;
		if (tm.trackMouse && ce) {
			el.setXY(xy);
		}
	};
	var _25 = function(e) {
		clearTimeout(_14);
		clearTimeout(_15);
		if (!e.within(el)) {
			if (tm.hideOnClick) {
				_22();
				tm.disable();
			}
		}
	};
	var _27 = function(e) {
		tm.enable();
	};
	var _29 = function() {
		return _b.getPadding("l") + _c.getPadding("r");
	};
	var _1b = function(o) {
		if (_12) {
			return;
		}
		clearTimeout(_16);
		ce = o;
		if (_a) {
			el.removeClass(_a);
			_a = null;
		}
		if (ce.cls) {
			el.addClass(ce.cls);
			_a = ce.cls;
		}
		if (ce.title) {
			_4.update(ce.title);
			_4.show();
		} else {
			_4.update("");
			_4.hide();
		}
		el.dom.style.width = tm.maxWidth + "px";
		_3.update(o.text);
		var p = _29(), w = ce.width;
		if (!w) {
			var td = _3.dom;
			var aw = Math.max(td.offsetWidth, td.clientWidth, td.scrollWidth);
			if (aw > tm.maxWidth) {
				w = tm.maxWidth;
			} else {
				if (aw < tm.minWidth) {
					w = tm.minWidth;
				} else {
					w = aw;
				}
			}
		}
		el.setWidth(w + p);
		if (!ce.autoHide) {
			_7.setDisplayed(true);
			if (dd) {
				dd.unlock();
			}
		} else {
			_7.setDisplayed(false);
			if (dd) {
				dd.lock();
			}
		}
		if (xy) {
			el.avoidY = xy[1] - 18;
			el.setXY(xy);
		}
		if (tm.animate) {
			el.setOpacity(0.1);
			el.setStyle("visibility", "visible");
			el.fadeIn( {
				callback : _2f
			});
		} else {
			_2f();
		}
	};
	var _2f = function() {
		if (ce) {
			el.show();
			_9.enable();
			if (tm.autoDismiss && ce.autoHide !== false) {
				_16 = setTimeout(_22, tm.autoDismissDelay);
			}
		}
	};
	var _22 = function(_30) {
		clearTimeout(_16);
		clearTimeout(_15);
		ce = null;
		if (el.isVisible()) {
			_9.disable();
			if (_30 !== true && tm.animate) {
				el.fadeOut( {
					callback : _31
				});
			} else {
				_31();
			}
		}
	};
	var _31 = function() {
		el.hide();
		if (_a) {
			el.removeClass(_a);
			_a = null;
		}
	};
	return {
		minWidth : 40,
		maxWidth : 300,
		interceptTitles : false,
		trackMouse : false,
		hideOnClick : true,
		showDelay : 500,
		hideDelay : 200,
		autoHide : true,
		autoDismiss : true,
		autoDismissDelay : 5000,
		animate : false,
		init : function() {
			tm = Ext.QuickTips;
			_6 = tm.tagConfig;
			if (!_13) {
				el = new Ext.Layer( {
					cls : "x-tip",
					shadow : "drop",
					shim : true,
					constrain : true,
					shadowOffset : 3
				});
				el.fxDefaults = {
					stopFx : true
				};
				el
						.update("<div class=\"x-tip-top-left\"><div class=\"x-tip-top-right\"><div class=\"x-tip-top\"></div></div></div><div class=\"x-tip-bd-left\"><div class=\"x-tip-bd-right\"><div class=\"x-tip-bd\"><div class=\"x-tip-close\"></div><h3></h3><div class=\"x-tip-bd-inner\"></div><div class=\"x-clear\"></div></div></div></div><div class=\"x-tip-ft-left\"><div class=\"x-tip-ft-right\"><div class=\"x-tip-ft\"></div></div></div>");
				_4 = el.child("h3");
				_4.enableDisplayMode("block");
				_2 = el.child("div.x-tip-bd");
				_3 = el.child("div.x-tip-bd-inner");
				_b = el.child("div.x-tip-bd-left");
				_c = el.child("div.x-tip-bd-right");
				_7 = el.child("div.x-tip-close");
				_7.enableDisplayMode("block");
				_7.on("click", _22);
				d = Ext.get(document);
				d.on("mousedown", _25);
				d.on("mouseup", _27);
				d.on("mouseover", _18);
				d.on("mouseout", _1f);
				d.on("mousemove", _23);
				_9 = d.addKeyListener(27, _22);
				_9.disable();
				if (Ext.dd.DD) {
					dd = el.initDD("default", null, {
						onDrag : function() {
							el.sync();
						}
					});
					dd.setHandleElId(_4.id);
					dd.lock();
				}
				_13 = true;
			}
			this.enable();
		},
		register : function(_32) {
			var cs = _32 instanceof Array ? _32 : arguments;
			for ( var i = 0, len = cs.length; i < len; i++) {
				var c = cs[i];
				var _37 = c.target;
				if (_37) {
					if (_37 instanceof Array) {
						for ( var j = 0, _39 = _37.length; j < _39; j++) {
							_8[_37[j]] = c;
						}
					} else {
						_8[typeof _37 == "string" ? _37 : Ext.id(_37.id)] = c;
					}
				}
			}
		},
		unregister : function(el) {
			delete _8[Ext.id(el)];
		},
		enable : function() {
			if (_13) {
				_17.pop();
				if (_17.length < 1) {
					_12 = false;
				}
			}
		},
		disable : function() {
			_12 = true;
			clearTimeout(_14);
			clearTimeout(_15);
			clearTimeout(_16);
			if (ce) {
				_22(true);
			}
			_17.push(1);
		},
		isEnabled : function() {
			return !_12;
		},
		tagConfig : {
			namespace : "ext",
			attribute : "qtip",
			width : "width",
			target : "target",
			title : "qtitle",
			hide : "hide",
			cls : "qclass"
		}
	};
}();
Ext.QuickTips.tips = Ext.QuickTips.register;

Ext.tree.TreePanel = function(el, _2) {
	Ext.tree.TreePanel.superclass.constructor.call(this);
	this.el = Ext.get(el);
	this.el.addClass("x-tree");
	this.id = this.el.id;
	Ext.apply(this, _2);
	this.addEvents( {
		"beforeload" : true,
		"load" : true,
		"textchange" : true,
		"beforeexpand" : true,
		"beforecollapse" : true,
		"expand" : true,
		"disabledchange" : true,
		"collapse" : true,
		"beforeclick" : true,
		"click" : true,
		"dblclick" : true,
		"contextmenu" : true,
		"beforechildrenrendered" : true,
		"startdrag" : true,
		"enddrag" : true,
		"dragdrop" : true,
		"beforenodedrop" : true,
		"nodedrop" : true,
		"nodedragover" : true
	});
	if (this.singleExpand) {
		this.on("beforeexpand", this.restrictExpand, this);
	}
};
Ext.extend(Ext.tree.TreePanel, Ext.data.Tree, {
	rootVisible : true,
	animate : Ext.enableFx,
	lines : true,
	enableDD : false,
	hlDrop : Ext.enableFx,
	restrictExpand : function(_3) {
		var p = _3.parentNode;
		if (p) {
			if (p.expandedChild && p.expandedChild.parentNode == p) {
				p.expandedChild.collapse();
			}
			p.expandedChild = _3;
		}
	},
	setRootNode : function(_5) {
		Ext.tree.TreePanel.superclass.setRootNode.call(this, _5);
		if (!this.rootVisible) {
			_5.ui = new Ext.tree.RootTreeNodeUI(_5);
		}
		return _5;
	},
	getEl : function() {
		return this.el;
	},
	getLoader : function() {
		return this.loader;
	},
	expandAll : function() {
		this.root.expand(true);
	},
	collapseAll : function() {
		this.root.collapse(true);
	},
	getSelectionModel : function() {
		if (!this.selModel) {
			this.selModel = new Ext.tree.DefaultSelectionModel();
		}
		return this.selModel;
	},
	expandPath : function(_6, _7, _8) {
		_7 = _7 || "id";
		var _9 = _6.split(this.pathSeparator);
		var _a = this.root;
		if (_a.attributes[_7] != _9[1]) {
			if (_8) {
				_8(false, null);
			}
			return;
		}
		var _b = 1;
		var f = function() {
			if (++_b == _9.length) {
				if (_8) {
					_8(true, _a);
				}
				return;
			}
			var c = _a.findChild(_7, _9[_b]);
			if (!c) {
				if (_8) {
					_8(false, _a);
				}
				return;
			}
			_a = c;
			c.expand(false, false, f);
		};
		_a.expand(false, false, f);
	},
	selectPath : function(_e, _f, _10) {
		_f = _f || "id";
		var _11 = _e.split(this.pathSeparator);
		var v = _11.pop();
		if (_11.length > 0) {
			var f = function(_14, _15) {
				if (_14 && _15) {
					var n = _15.findChild(_f, v);
					if (n) {
						n.select();
						if (_10) {
							_10(true, n);
						}
					}
				} else {
					if (_10) {
						_10(false, n);
					}
				}
			};
			this.expandPath(_11.join(this.pathSeparator), _f, f);
		} else {
			this.root.select();
			if (_10) {
				_10(true, this.root);
			}
		}
	},
	render : function() {
		this.container = this.el.createChild( {
			tag : "ul",
			cls : "x-tree-root-ct "
					+ (this.lines ? "x-tree-lines" : "x-tree-no-lines")
		});
		if (this.containerScroll) {
			Ext.dd.ScrollManager.register(this.el);
		}
		if ((this.enableDD || this.enableDrop) && !this.dropZone) {
			this.dropZone = new Ext.tree.TreeDropZone(this, this.dropConfig
					|| {
						ddGroup : this.ddGroup || "TreeDD",
						appendOnly : this.ddAppendOnly === true
					});
		}
		if ((this.enableDD || this.enableDrag) && !this.dragZone) {
			this.dragZone = new Ext.tree.TreeDragZone(this, this.dragConfig
					|| {
						ddGroup : this.ddGroup || "TreeDD",
						scroll : this.ddScroll
					});
		}
		this.getSelectionModel().init(this);
		this.root.render();
		if (!this.rootVisible) {
			this.root.renderChildren();
		}
		return this;
	}
});

Ext.tree.DefaultSelectionModel = function() {
	this.selNode = null;
	this.events = {
		"selectionchange" : true,
		"beforeselect" : true
	};
};
Ext
		.extend(
				Ext.tree.DefaultSelectionModel,
				Ext.util.Observable,
				{
					init : function(_1) {
						this.tree = _1;
						_1.el.on("keydown", this.onKeyDown, this);
						_1.on("click", this.onNodeClick, this);
					},
					onNodeClick : function(_2, e) {
						this.select(_2);
					},
					select : function(_4) {
						var _5 = this.selNode;
						if (_5 != _4
								&& this.fireEvent("beforeselect", this, _4, _5) !== false) {
							if (_5) {
								_5.ui.onSelectedChange(false);
							}
							this.selNode = _4;
							_4.ui.onSelectedChange(true);
							this.fireEvent("selectionchange", this, _4, _5);
						}
						return _4;
					},
					unselect : function(_6) {
						if (this.selNode == _6) {
							this.clearSelections();
						}
					},
					clearSelections : function() {
						var n = this.selNode;
						if (n) {
							n.ui.onSelectedChange(false);
							this.selNode = null;
							this.fireEvent("selectionchange", this, null);
						}
						return n;
					},
					getSelectedNode : function() {
						return this.selNode;
					},
					isSelected : function(_8) {
						return this.selNode == _8;
					},
					selectPrevious : function() {
						var s = this.selNode || this.lastSelNode;
						if (!s) {
							return null;
						}
						var ps = s.previousSibling;
						if (ps) {
							if (!ps.isExpanded() || ps.childNodes.length < 1) {
								return this.select(ps);
							} else {
								var lc = ps.lastChild;
								while (lc && lc.isExpanded()
										&& lc.childNodes.length > 0) {
									lc = lc.lastChild;
								}
								return this.select(lc);
							}
						} else {
							if (s.parentNode
									&& (this.tree.rootVisible || !s.parentNode.isRoot)) {
								return this.select(s.parentNode);
							}
						}
						return null;
					},
					selectNext : function() {
						var s = this.selNode || this.lastSelNode;
						if (!s) {
							return null;
						}
						if (s.firstChild && s.isExpanded()) {
							return this.select(s.firstChild);
						} else {
							if (s.nextSibling) {
								return this.select(s.nextSibling);
							} else {
								if (s.parentNode) {
									var _d = null;
									s.parentNode.bubble(function() {
										if (this.nextSibling) {
											_d = this.getOwnerTree().selModel
													.select(this.nextSibling);
											return false;
										}
									});
									return _d;
								}
							}
						}
						return null;
					},
					onKeyDown : function(e) {
						var s = this.selNode || this.lastSelNode;
						var sm = this;
						if (!s) {
							return;
						}
						var k = e.getKey();
						switch (k) {
						case e.DOWN:
							e.stopEvent();
							this.selectNext();
							break;
						case e.UP:
							e.stopEvent();
							this.selectPrevious();
							break;
						case e.RIGHT:
							e.preventDefault();
							if (s.hasChildNodes()) {
								if (!s.isExpanded()) {
									s.expand();
								} else {
									if (s.firstChild) {
										this.select(s.firstChild, e);
									}
								}
							}
							break;
						case e.LEFT:
							e.preventDefault();
							if (s.hasChildNodes() && s.isExpanded()) {
								s.collapse();
							} else {
								if (s.parentNode
										&& (this.tree.rootVisible || s.parentNode != this.tree
												.getRootNode())) {
									this.select(s.parentNode, e);
								}
							}
							break;
						}
					}
				});
Ext.tree.MultiSelectionModel = function() {
	this.selNodes = [];
	this.selMap = {};
	this.events = {
		"selectionchange" : true
	};
};
Ext.extend(Ext.tree.MultiSelectionModel, Ext.util.Observable, {
	init : function(_12) {
		this.tree = _12;
		_12.el.on("keydown", this.onKeyDown, this);
		_12.on("click", this.onNodeClick, this);
	},
	onNodeClick : function(_13, e) {
		this.select(_13, e, e.ctrlKey);
	},
	select : function(_15, e, _17) {
		if (_17 !== true) {
			this.clearSelections(true);
		}
		if (this.isSelected(_15)) {
			this.lastSelNode = _15;
			return _15;
		}
		this.selNodes.push(_15);
		this.selMap[_15.id] = _15;
		this.lastSelNode = _15;
		_15.ui.onSelectedChange(true);
		this.fireEvent("selectionchange", this, this.selNodes);
		return _15;
	},
	unselect : function(_18) {
		if (this.selMap[_18.id]) {
			_18.ui.onSelectedChange(false);
			var sn = this.selNodes;
			var _1a = -1;
			if (sn.indexOf) {
				_1a = sn.indexOf(_18);
			} else {
				for ( var i = 0, len = sn.length; i < len; i++) {
					if (sn[i] == _18) {
						_1a = i;
						break;
					}
				}
			}
			if (_1a != -1) {
				this.selNodes.splice(_1a, 1);
			}
			delete this.selMap[_18.id];
			this.fireEvent("selectionchange", this, this.selNodes);
		}
	},
	clearSelections : function(_1d) {
		var sn = this.selNodes;
		if (sn.length > 0) {
			for ( var i = 0, len = sn.length; i < len; i++) {
				sn[i].ui.onSelectedChange(false);
			}
			this.selNodes = [];
			this.selMap = {};
			if (_1d !== true) {
				this.fireEvent("selectionchange", this, this.selNodes);
			}
		}
	},
	isSelected : function(_21) {
		return this.selMap[_21.id] ? true : false;
	},
	getSelectedNodes : function() {
		return this.selNodes;
	},
	onKeyDown : Ext.tree.DefaultSelectionModel.prototype.onKeyDown
});

Ext.tree.TreeNode = function(_1) {
	_1 = _1 || {};
	if (typeof _1 == "string") {
		_1 = {
			text : _1
		};
	}
	this.childrenRendered = false;
	this.rendered = false;
	Ext.tree.TreeNode.superclass.constructor.call(this, _1);
	this.expanded = _1.expanded === true;
	this.isTarget = _1.isTarget !== false;
	this.draggable = _1.draggable !== false && _1.allowDrag !== false;
	this.allowChildren = _1.allowChildren !== false && _1.allowDrop !== false;
	this.text = _1.text;
	this.disabled = _1.disabled === true;
	Ext.apply(this.events, {
		"textchange" : true,
		"beforeexpand" : true,
		"beforecollapse" : true,
		"expand" : true,
		"disabledchange" : true,
		"collapse" : true,
		"beforeclick" : true,
		"click" : true,
		"dblclick" : true,
		"contextmenu" : true,
		"beforechildrenrendered" : true
	});
	var _2 = this.attributes.uiProvider || Ext.tree.TreeNodeUI;
	this.ui = new _2(this);
};
Ext.extend(Ext.tree.TreeNode, Ext.data.Node, {
	preventHScroll : true,
	isExpanded : function() {
		return this.expanded;
	},
	getUI : function() {
		return this.ui;
	},
	setFirstChild : function(_3) {
		var of = this.firstChild;
		Ext.tree.TreeNode.superclass.setFirstChild.call(this, _3);
		if (this.childrenRendered && of && _3 != of) {
			of.renderIndent(true, true);
		}
		if (this.rendered) {
			this.renderIndent(true, true);
		}
	},
	setLastChild : function(_5) {
		var ol = this.lastChild;
		Ext.tree.TreeNode.superclass.setLastChild.call(this, _5);
		if (this.childrenRendered && ol && _5 != ol) {
			ol.renderIndent(true, true);
		}
		if (this.rendered) {
			this.renderIndent(true, true);
		}
	},
	appendChild : function() {
		var _7 = Ext.tree.TreeNode.superclass.appendChild
				.apply(this, arguments);
		if (_7 && this.childrenRendered) {
			_7.render();
		}
		this.ui.updateExpandIcon();
		return _7;
	},
	removeChild : function(_8) {
		this.ownerTree.getSelectionModel().unselect(_8);
		Ext.tree.TreeNode.superclass.removeChild.apply(this, arguments);
		if (this.childrenRendered) {
			_8.ui.remove();
		}
		if (this.childNodes.length < 1) {
			this.collapse(false, false);
		} else {
			this.ui.updateExpandIcon();
		}
		return _8;
	},
	insertBefore : function(_9, _a) {
		var _b = Ext.tree.TreeNode.superclass.insertBefore.apply(this,
				arguments);
		if (_b && _a && this.childrenRendered) {
			_9.render();
		}
		this.ui.updateExpandIcon();
		return _b;
	},
	setText : function(_c) {
		var _d = this.text;
		this.text = _c;
		this.attributes.text = _c;
		if (this.rendered) {
			this.ui.onTextChange(this, _c, _d);
		}
		this.fireEvent("textchange", this, _c, _d);
	},
	select : function() {
		this.getOwnerTree().getSelectionModel().select(this);
	},
	unselect : function() {
		this.getOwnerTree().getSelectionModel().unselect(this);
	},
	isSelected : function() {
		return this.getOwnerTree().getSelectionModel().isSelected(this);
	},
	expand : function(_e, _f, _10) {
		if (!this.expanded) {
			if (this.fireEvent("beforeexpand", this, _e, _f) === false) {
				return;
			}
			if (!this.childrenRendered) {
				this.renderChildren();
			}
			this.expanded = true;
			if (!this.isHiddenRoot()
					&& (this.getOwnerTree().animate && _f !== false) || _f) {
				this.ui.animExpand(function() {
					this.fireEvent("expand", this);
					if (typeof _10 == "function") {
						_10(this);
					}
					if (_e === true) {
						this.expandChildNodes(true);
					}
				}.createDelegate(this));
				return;
			} else {
				this.ui.expand();
				this.fireEvent("expand", this);
				if (typeof _10 == "function") {
					_10(this);
				}
			}
		} else {
			if (typeof _10 == "function") {
				_10(this);
			}
		}
		if (_e === true) {
			this.expandChildNodes(true);
		}
	},
	isHiddenRoot : function() {
		return this.isRoot && !this.getOwnerTree().rootVisible;
	},
	collapse : function(_11, _12) {
		if (this.expanded && !this.isHiddenRoot()) {
			if (this.fireEvent("beforecollapse", this, _11, _12) === false) {
				return;
			}
			this.expanded = false;
			if ((this.getOwnerTree().animate && _12 !== false) || _12) {
				this.ui.animCollapse(function() {
					this.fireEvent("collapse", this);
					if (_11 === true) {
						this.collapseChildNodes(true);
					}
				}.createDelegate(this));
				return;
			} else {
				this.ui.collapse();
				this.fireEvent("collapse", this);
			}
		}
		if (_11 === true) {
			var cs = this.childNodes;
			for ( var i = 0, len = cs.length; i < len; i++) {
				cs[i].collapse(true);
			}
		}
	},
	delayedExpand : function(_16) {
		if (!this.expandProcId) {
			this.expandProcId = this.expand.defer(_16, this);
		}
	},
	cancelExpand : function() {
		if (this.expandProcId) {
			clearTimeout(this.expandProcId);
		}
		this.expandProcId = false;
	},
	toggle : function() {
		if (this.expanded) {
			this.collapse();
		} else {
			this.expand();
		}
	},
	ensureVisible : function(_17) {
		var _18 = this.getOwnerTree();
		_18.expandPath(this.getPath(), false, function() {
			_18.getEl().scrollChildIntoView(this.ui.anchor);
			Ext.callback(_17);
		}.createDelegate(this));
	},
	expandChildNodes : function(_19) {
		var cs = this.childNodes;
		for ( var i = 0, len = cs.length; i < len; i++) {
			cs[i].expand(_19);
		}
	},
	collapseChildNodes : function(_1d) {
		var cs = this.childNodes;
		for ( var i = 0, len = cs.length; i < len; i++) {
			cs[i].collapse(_1d);
		}
	},
	disable : function() {
		this.disabled = true;
		this.unselect();
		if (this.rendered && this.ui.onDisableChange) {
			this.ui.onDisableChange(this, true);
		}
		this.fireEvent("disabledchange", this, true);
	},
	enable : function() {
		this.disabled = false;
		if (this.rendered && this.ui.onDisableChange) {
			this.ui.onDisableChange(this, false);
		}
		this.fireEvent("disabledchange", this, false);
	},
	renderChildren : function(_21) {
		if (_21 !== false) {
			this.fireEvent("beforechildrenrendered", this);
		}
		var cs = this.childNodes;
		for ( var i = 0, len = cs.length; i < len; i++) {
			cs[i].render(true);
		}
		this.childrenRendered = true;
	},
	sort : function(fn, _26) {
		Ext.tree.TreeNode.superclass.sort.apply(this, arguments);
		if (this.childrenRendered) {
			var cs = this.childNodes;
			for ( var i = 0, len = cs.length; i < len; i++) {
				cs[i].render(true);
			}
		}
	},
	render : function(_2a) {
		this.ui.render(_2a);
		if (!this.rendered) {
			this.rendered = true;
			if (this.expanded) {
				this.expanded = false;
				this.expand(false, false);
			}
		}
	},
	renderIndent : function(_2b, _2c) {
		if (_2c) {
			this.ui.childIndent = null;
		}
		this.ui.renderIndent();
		if (_2b === true && this.childrenRendered) {
			var cs = this.childNodes;
			for ( var i = 0, len = cs.length; i < len; i++) {
				cs[i].renderIndent(true, _2c);
			}
		}
	}
});

Ext.tree.AsyncTreeNode = function(_1) {
	this.loaded = false;
	this.loading = false;
	Ext.tree.AsyncTreeNode.superclass.constructor.apply(this, arguments);
	this.events["beforeload"] = true;
	this.events["load"] = true;
};
Ext.extend(Ext.tree.AsyncTreeNode, Ext.tree.TreeNode, {
	expand : function(_2, _3, _4) {
		if (this.loading) {
			var _5;
			var f = function() {
				if (!this.loading) {
					clearInterval(_5);
					this.expand(_2, _3, _4);
				}
			}.createDelegate(this);
			_5 = setInterval(f, 200);
			return;
		}
		if (!this.loaded) {
			if (this.fireEvent("beforeload", this) === false) {
				return;
			}
			this.loading = true;
			this.ui.beforeLoad(this);
			var _7 = this.loader || this.attributes.loader
					|| this.getOwnerTree().getLoader();
			if (_7) {
				_7.load(this, this.loadComplete.createDelegate(this, [ _2, _3,
						_4 ]));
				return;
			}
		}
		Ext.tree.AsyncTreeNode.superclass.expand.call(this, _2, _3, _4);
	},
	isLoading : function() {
		return this.loading;
	},
	loadComplete : function(_8, _9, _a) {
		this.loading = false;
		this.loaded = true;
		this.ui.afterLoad(this);
		this.fireEvent("load", this);
		this.expand(_8, _9, _a);
	},
	isLoaded : function() {
		return this.loaded;
	},
	hasChildNodes : function() {
		if (!this.isLeaf() && !this.loaded) {
			return true;
		} else {
			return Ext.tree.AsyncTreeNode.superclass.hasChildNodes.call(this);
		}
	},
	reload : function(_b) {
		this.collapse(false, false);
		while (this.firstChild) {
			this.removeChild(this.firstChild);
		}
		this.childrenRendered = false;
		this.loaded = false;
		if (this.isHiddenRoot()) {
			this.expanded = false;
		}
		this.expand(false, false, _b);
	}
});

Ext.tree.TreeNodeUI = function(_1) {
	this.node = _1;
	this.rendered = false;
	this.animating = false;
	this.emptyIcon = Ext.BLANK_IMAGE_URL;
};
Ext.tree.TreeNodeUI.prototype = {
	removeChild : function(_2) {
		if (this.rendered) {
			this.ctNode.removeChild(_2.ui.getEl());
		}
	},
	beforeLoad : function() {
		this.addClass("x-tree-node-loading");
	},
	afterLoad : function() {
		this.removeClass("x-tree-node-loading");
	},
	onTextChange : function(_3, _4, _5) {
		if (this.rendered) {
			this.textNode.innerHTML = _4;
		}
	},
	onDisableChange : function(_6, _7) {
		this.disabled = _7;
		if (_7) {
			this.addClass("x-tree-node-disabled");
		} else {
			this.removeClass("x-tree-node-disabled");
		}
	},
	onSelectedChange : function(_8) {
		if (_8) {
			this.focus();
			this.addClass("x-tree-selected");
		} else {
			this.removeClass("x-tree-selected");
		}
	},
	onMove : function(_9, _a, _b, _c, _d, _e) {
		this.childIndent = null;
		if (this.rendered) {
			var _f = _c.ui.getContainer();
			if (!_f) {
				this.holder = document.createElement("div");
				this.holder.appendChild(this.wrap);
				return;
			}
			var _10 = _e ? _e.ui.getEl() : null;
			if (_10) {
				_f.insertBefore(this.wrap, _10);
			} else {
				_f.appendChild(this.wrap);
			}
			this.node.renderIndent(true);
		}
	},
	addClass : function(cls) {
		if (this.elNode) {
			Ext.fly(this.elNode).addClass(cls);
		}
	},
	removeClass : function(cls) {
		if (this.elNode) {
			Ext.fly(this.elNode).removeClass(cls);
		}
	},
	remove : function() {
		if (this.rendered) {
			this.holder = document.createElement("div");
			this.holder.appendChild(this.wrap);
		}
	},
	fireEvent : function() {
		return this.node.fireEvent.apply(this.node, arguments);
	},
	initEvents : function() {
		this.node.on("move", this.onMove, this);
		var E = Ext.EventManager;
		var a = this.anchor;
		var el = Ext.fly(a);
		if (Ext.isOpera) {
			el.setStyle("text-decoration", "none");
		}
		el.on("click", this.onClick, this);
		el.on("dblclick", this.onDblClick, this);
		el.on("contextmenu", this.onContextMenu, this);
		var _16 = Ext.fly(this.iconNode);
		_16.on("click", this.onClick, this);
		_16.on("dblclick", this.onDblClick, this);
		_16.on("contextmenu", this.onContextMenu, this);
		E.on(this.ecNode, "click", this.ecClick, this, true);
		if (this.node.disabled) {
			this.addClass("x-tree-node-disabled");
		}
		if (this.node.hidden) {
			this.addClass("x-tree-node-disabled");
		}
		var ot = this.node.getOwnerTree();
		var dd = ot.enableDD || ot.enableDrag || ot.enableDrop;
		if (dd && (!this.node.isRoot || ot.rootVisible)) {
			Ext.dd.Registry.register(this.elNode, {
				node : this.node,
				handles : [ this.iconNode, this.textNode ],
				isHandle : false
			});
		}
	},
	hide : function() {
		if (this.rendered) {
			this.wrap.style.display = "none";
		}
	},
	show : function() {
		if (this.rendered) {
			this.wrap.style.display = "";
		}
	},
	onContextMenu : function(e) {
		e.preventDefault();
		this.focus();
		this.fireEvent("contextmenu", this.node, e);
	},
	onClick : function(e) {
		if (this.dropping) {
			return;
		}
		if (this.fireEvent("beforeclick", this.node, e) !== false) {
			if (!this.disabled && this.node.attributes.href) {
				this.fireEvent("click", this.node, e);
				return;
			}
			e.preventDefault();
			if (this.disabled) {
				return;
			}
			if (this.node.attributes.singleClickExpand && !this.animating
					&& this.node.hasChildNodes()) {
				this.node.toggle();
			}
			this.fireEvent("click", this.node, e);
		} else {
			e.stopEvent();
		}
	},
	onDblClick : function(e) {
		e.preventDefault();
		if (this.disabled) {
			return;
		}
		if (!this.animating && this.node.hasChildNodes()) {
			this.node.toggle();
		}
		this.fireEvent("dblclick", this.node, e);
	},
	ecClick : function(e) {
		if (!this.animating && this.node.hasChildNodes()) {
			this.node.toggle();
		}
	},
	startDrop : function() {
		this.dropping = true;
	},
	endDrop : function() {
		setTimeout(function() {
			this.dropping = false;
		}.createDelegate(this), 50);
	},
	expand : function() {
		this.updateExpandIcon();
		this.ctNode.style.display = "";
	},
	focus : function() {
		if (!this.node.preventHScroll) {
			try {
				this.anchor.focus();
			} catch (e) {
			}
		} else {
			if (!Ext.isIE) {
				try {
					var _1d = this.node.getOwnerTree().el.dom;
					var l = _1d.scrollLeft;
					this.anchor.focus();
					_1d.scrollLeft = l;
				} catch (e) {
				}
			}
		}
	},
	blur : function() {
		try {
			this.anchor.blur();
		} catch (e) {
		}
	},
	animExpand : function(_1f) {
		var ct = Ext.get(this.ctNode);
		ct.stopFx();
		if (!this.node.hasChildNodes()) {
			this.updateExpandIcon();
			this.ctNode.style.display = "";
			Ext.callback(_1f);
			return;
		}
		this.animating = true;
		this.updateExpandIcon();
		ct.slideIn("t", {
			callback : function() {
				this.animating = false;
				Ext.callback(_1f);
			},
			scope : this,
			duration : this.node.ownerTree.duration || 0.25
		});
	},
	highlight : function() {
		var _21 = this.node.getOwnerTree();
		Ext.fly(this.wrap).highlight(_21.hlColor || "C3DAF9", {
			endColor : _21.hlBaseColor
		});
	},
	collapse : function() {
		this.updateExpandIcon();
		this.ctNode.style.display = "none";
	},
	animCollapse : function(_22) {
		var ct = Ext.get(this.ctNode);
		ct.enableDisplayMode("block");
		ct.stopFx();
		this.animating = true;
		this.updateExpandIcon();
		ct.slideOut("t", {
			callback : function() {
				this.animating = false;
				Ext.callback(_22);
			},
			scope : this,
			duration : this.node.ownerTree.duration || 0.25
		});
	},
	getContainer : function() {
		return this.ctNode;
	},
	getEl : function() {
		return this.wrap;
	},
	appendDDGhost : function(_24) {
		_24.appendChild(this.elNode.cloneNode(true));
	},
	getDDRepairXY : function() {
		return Ext.lib.Dom.getXY(this.iconNode);
	},
	onRender : function() {
		this.render();
	},
	render : function(_25) {
		var n = this.node;
		var _27 = n.parentNode ? n.parentNode.ui.getContainer()
				: n.ownerTree.container.dom;
		if (!this.rendered) {
			this.rendered = true;
			var a = n.attributes;
			this.indentMarkup = "";
			if (n.parentNode) {
				this.indentMarkup = n.parentNode.ui.getChildIndent();
			}
			var buf = [
					"<li class=\"x-tree-node\"><div class=\"x-tree-node-el ",
					n.attributes.cls,
					"\">",
					"<span class=\"x-tree-node-indent\">",
					this.indentMarkup,
					"</span>",
					"<img src=\"",
					this.emptyIcon,
					"\" class=\"x-tree-ec-icon\">",
					"<img src=\"",
					a.icon || this.emptyIcon,
					"\" class=\"x-tree-node-icon",
					(a.icon ? " x-tree-node-inline-icon" : ""),
					(a.iconCls ? " " + a.iconCls : ""),
					"\" unselectable=\"on\">",
					"<a hidefocus=\"on\" href=\"",
					a.href ? a.href : "#",
					"\" tabIndex=\"1\" ",
					a.hrefTarget ? " target=\"" + a.hrefTarget + "\"" : "",
					"><span unselectable=\"on\">",
					n.text,
					"</span></a></div>",
					"<ul class=\"x-tree-node-ct\" style=\"display:none;\"></ul>",
					"</li>" ];
			if (_25 !== true && n.nextSibling && n.nextSibling.ui.getEl()) {
				this.wrap = Ext.DomHelper.insertHtml("beforeBegin",
						n.nextSibling.ui.getEl(), buf.join(""));
			} else {
				this.wrap = Ext.DomHelper.insertHtml("beforeEnd", _27, buf
						.join(""));
			}
			this.elNode = this.wrap.childNodes[0];
			this.ctNode = this.wrap.childNodes[1];
			var cs = this.elNode.childNodes;
			this.indentNode = cs[0];
			this.ecNode = cs[1];
			this.iconNode = cs[2];
			this.anchor = cs[3];
			this.textNode = cs[3].firstChild;
			if (a.qtip) {
				if (this.textNode.setAttributeNS) {
					this.textNode.setAttributeNS("ext", "qtip", a.qtip);
					if (a.qtipTitle) {
						this.textNode.setAttributeNS("ext", "qtitle",
								a.qtipTitle);
					}
				} else {
					this.textNode.setAttribute("ext:qtip", a.qtip);
					if (a.qtipTitle) {
						this.textNode.setAttribute("ext:qtitle", a.qtipTitle);
					}
				}
			}
			this.initEvents();
			if (!this.node.expanded) {
				this.updateExpandIcon();
			}
		} else {
			if (_25 === true) {
				_27.appendChild(this.wrap);
			}
		}
	},
	getAnchor : function() {
		return this.anchor;
	},
	getTextEl : function() {
		return this.textNode;
	},
	getIconEl : function() {
		return this.iconNode;
	},
	updateExpandIcon : function() {
		if (this.rendered) {
			var n = this.node, c1, c2;
			var cls = n.isLast() ? "x-tree-elbow-end" : "x-tree-elbow";
			var _2f = n.hasChildNodes();
			if (_2f) {
				if (n.expanded) {
					cls += "-minus";
					c1 = "x-tree-node-collapsed";
					c2 = "x-tree-node-expanded";
				} else {
					cls += "-plus";
					c1 = "x-tree-node-expanded";
					c2 = "x-tree-node-collapsed";
				}
				if (this.wasLeaf) {
					this.removeClass("x-tree-node-leaf");
					this.wasLeaf = false;
				}
				if (this.c1 != c1 || this.c2 != c2) {
					Ext.fly(this.elNode).replaceClass(c1, c2);
					this.c1 = c1;
					this.c2 = c2;
				}
			} else {
				if (!this.wasLeaf) {
					Ext.fly(this.elNode).replaceClass("x-tree-node-expanded","x-tree-node-leaf");
					this.wasLeaf = true;
				}
			}
			var ecc = "x-tree-ec-icon " + cls;
			if (this.ecc != ecc) {
				this.ecNode.className = ecc;
				this.ecc = ecc;
			}
		}
	},
	getChildIndent : function() {
		if (!this.childIndent) {
			var buf = [];
			var p = this.node;
			while (p) {
				if (!p.isRoot || (p.isRoot && p.ownerTree.rootVisible)) {
					if (!p.isLast()) {
						buf.unshift("<img src=\"" + this.emptyIcon
								+ "\" class=\"x-tree-elbow-line\">");
					} else {
						buf.unshift("<img src=\"" + this.emptyIcon
								+ "\" class=\"x-tree-icon\">");
					}
				}
				p = p.parentNode;
			}
			this.childIndent = buf.join("");
		}
		return this.childIndent;
	},
	renderIndent : function() {
		if (this.rendered) {
			var _33 = "";
			var p = this.node.parentNode;
			if (p) {
				_33 = p.ui.getChildIndent();
			}
			if (this.indentMarkup != _33) {
				this.indentNode.innerHTML = _33;
				this.indentMarkup = _33;
			}
			this.updateExpandIcon();
		}
	}
};
Ext.tree.RootTreeNodeUI = function() {
	Ext.tree.RootTreeNodeUI.superclass.constructor.apply(this, arguments);
};
Ext.extend(Ext.tree.RootTreeNodeUI, Ext.tree.TreeNodeUI, {
	render : function() {
		if (!this.rendered) {
			var _35 = this.node.ownerTree.container.dom;
			this.node.expanded = true;
			_35.innerHTML = "<div class=\"x-tree-root-node\"></div>";
			this.wrap = this.ctNode = _35.firstChild;
		}
	},
	collapse : function() {
	},
	expand : function() {
	}
});

Ext.tree.TreeLoader = function(_1) {
	this.baseParams = {};
	this.requestMethod = "POST";
	Ext.apply(this, _1);
	this.events = {
		"beforeload" : true,
		"load" : true,
		"loadexception" : true
	};
};
Ext.extend(Ext.tree.TreeLoader, Ext.util.Observable, {
	uiProviders : {},
	clearOnLoad : true,
	load : function(_2, _3) {
		if (this.clearOnLoad) {
			while (_2.firstChild) {
				_2.removeChild(_2.firstChild);
			}
		}
		if (_2.attributes.children) {
			var cs = _2.attributes.children;
			for ( var i = 0, _6 = cs.length; i < _6; i++) {
				_2.appendChild(this.createNode(cs[i]));
			}
			if (typeof _3 == "function") {
				_3();
			}
		} else {
			if (this.dataUrl) {
				this.requestData(_2, _3);
			}
		}
	},
	getParams : function(_7) {
		var _8 = [], bp = this.baseParams;
		for ( var _a in bp) {
			if (typeof bp[_a] != "function") {
				_8.push(encodeURIComponent(_a), "=",
						encodeURIComponent(bp[_a]), "&");
			}
		}
		_8.push("node=", encodeURIComponent(_7.id));
		return _8.join("");
	},
	requestData : function(_b, _c) {
		if (this.fireEvent("beforeload", this, _b, _c) !== false) {
			var _d = this.getParams(_b);
			var cb = {
				success : this.handleResponse,
				failure : this.handleFailure,
				scope : this,
				argument : {
					callback : _c,
					node : _b
				}
			};
			this.transId = Ext.lib.Ajax.request(this.requestMethod,
					this.dataUrl, cb, _d);
		} else {
			if (typeof _c == "function") {
				_c();
			}
		}
	},
	isLoading : function() {
		return this.transId ? true : false;
	},
	abort : function() {
		if (this.isLoading()) {
			Ext.lib.Ajax.abort(this.transId);
		}
	},
	createNode : function(_f) {
		if (this.applyLoader !== false) {
			_f.loader = this;
		}
		if (typeof _f.uiProvider == "string") {
			_f.uiProvider = this.uiProviders[_f.uiProvider]
					|| eval(_f.uiProvider);
		}
		return (_f.leaf ? new Ext.tree.TreeNode(_f)
				: new Ext.tree.AsyncTreeNode(_f));
	},
	processResponse : function(_10, _11, _12) {
		var _13 = _10.responseText;
		try {
			var o = eval("(" + _13 + ")");
			for ( var i = 0, len = o.length; i < len; i++) {
				var n = this.createNode(o[i]);
				if (n) {
					_11.appendChild(n);
				}
			}
			if (typeof _12 == "function") {
				_12(this, _11);
			}
		} catch (e) {
			this.handleFailure(_10);
		}
	},
	handleResponse : function(_18) {
		this.transId = false;
		var a = _18.argument;
		this.processResponse(_18, a.node, a.callback);
		this.fireEvent("load", this, a.node, _18);
	},
	handleFailure : function(_1a) {
		this.transId = false;
		var a = _1a.argument;
		this.fireEvent("loadexception", this, a.node, _1a);
		if (typeof a.callback == "function") {
			a.callback(this, a.node);
		}
	}
});

Ext.tree.TreeFilter = function(_1, _2) {
	this.tree = _1;
	this.filtered = {};
	Ext.apply(this, _2, {
		clearBlank : false,
		reverse : false,
		autoClear : false,
		remove : false
	});
};
Ext.tree.TreeFilter.prototype = {
	filter : function(_3, _4, _5) {
		_4 = _4 || "text";
		var f;
		if (typeof _3 == "string") {
			var _7 = _3.length;
			if (_7 == 0 && this.clearBlank) {
				this.clearFilter();
				return;
			}
			_3 = _3.toLowerCase();
			f = function(n) {
				return n.attributes[_4].substr(0, _7).toLowerCase() == _3;
			};
		} else {
			if (_3.exec) {
				f = function(n) {
					return _3.test(n.attributes[_4]);
				};
			} else {
				throw "Illegal filter type, must be string or regex";
			}
		}
		this.filterBy(f, null, _5);
	},
	filterBy : function(fn, _b, _c) {
		_c = _c || this.tree.root;
		if (this.autoClear) {
			this.clearFilter();
		}
		var af = this.filtered, rv = this.reverse;
		var f = function(n) {
			if (n == _c) {
				return true;
			}
			if (af[n.id]) {
				return false;
			}
			var m = fn.call(_b || n, n);
			if (!m || rv) {
				af[n.id] = n;
				n.ui.hide();
				return false;
			}
			return true;
		};
		_c.cascade(f);
		if (this.remove) {
			for ( var id in af) {
				if (typeof id != "function") {
					var n = af[id];
					if (n && n.parentNode) {
						n.parentNode.removeChild(n);
					}
				}
			}
		}
	},
	clear : function() {
		var t = this.tree;
		var af = this.filtered;
		for ( var id in af) {
			if (typeof id != "function") {
				var n = af[id];
				if (n) {
					n.ui.show();
				}
			}
		}
		this.filtered = {};
	}
};

Ext.tree.TreeSorter = function(_1, _2) {
	Ext.apply(this, _2);
	_1.on("beforechildrenrendered", this.doSort, this);
	_1.on("append", this.updateSort, this);
	_1.on("insert", this.updateSort, this);
	var _3 = this.dir && this.dir.toLowerCase() == "desc";
	var p = this.property || "text";
	var _5 = this.sortType;
	var fs = this.folderSort;
	var cs = this.caseSensitive === true;
	var _8 = this.leafAttr || "leaf";
	this.sortFn = function(n1, n2) {
		if (fs) {
			if (n1.attributes[_8] && !n2.attributes[_8]) {
				return 1;
			}
			if (!n1.attributes[_8] && n2.attributes[_8]) {
				return -1;
			}
		}
		var v1 = _5 ? _5(n1) : (cs ? n1[p] : n1[p].toUpperCase());
		var v2 = _5 ? _5(n2) : (cs ? n2[p] : n2[p].toUpperCase());
		if (v1 < v2) {
			return _3 ? +1 : -1;
		} else {
			if (v1 > v2) {
				return _3 ? -1 : +1;
			} else {
				return 0;
			}
		}
	};
};
Ext.tree.TreeSorter.prototype = {
	doSort : function(_d) {
		_d.sort(this.sortFn);
	},
	compareNodes : function(n1, n2) {
		return (n1.text.toUpperCase() > n2.text.toUpperCase() ? 1 : -1);
	},
	updateSort : function(_10, _11) {
		if (_11.childrenRendered) {
			this.doSort.defer(1, this, [ _11 ]);
		}
	}
};

if (Ext.dd.DropZone) {
	Ext.tree.TreeDropZone = function(_1, _2) {
		this.allowParentInsert = false;
		this.allowContainerDrop = false;
		this.appendOnly = false;
		Ext.tree.TreeDropZone.superclass.constructor.call(this, _1.container,
				_2);
		this.tree = _1;
		this.lastInsertClass = "x-tree-no-status";
		this.dragOverData = {};
	};
	Ext
			.extend(
					Ext.tree.TreeDropZone,
					Ext.dd.DropZone,
					{
						ddGroup : "TreeDD",
						expandDelay : 1000,
						expandNode : function(_3) {
							if (_3.hasChildNodes() && !_3.isExpanded()) {
								_3.expand(false, null, this.triggerCacheRefresh
										.createDelegate(this));
							}
						},
						queueExpand : function(_4) {
							this.expandProcId = this.expandNode.defer(
									this.expandDelay, this, [ _4 ]);
						},
						cancelExpand : function() {
							if (this.expandProcId) {
								clearTimeout(this.expandProcId);
								this.expandProcId = false;
							}
						},
						isValidDropPoint : function(n, pt, dd, e, _9) {
							if (!n || !_9) {
								return false;
							}
							var _a = n.node;
							var _b = _9.node;
							if (!(_a && _a.isTarget && pt)) {
								return false;
							}
							if (pt == "append" && _a.allowChildren === false) {
								return false;
							}
							if ((pt == "above" || pt == "below")
									&& (_a.parentNode && _a.parentNode.allowChildren === false)) {
								return false;
							}
							if (_b && (_a == _b || _b.contains(_a))) {
								return false;
							}
							var _c = this.dragOverData;
							_c.tree = this.tree;
							_c.target = _a;
							_c.data = _9;
							_c.point = pt;
							_c.source = dd;
							_c.rawEvent = e;
							_c.dropNode = _b;
							_c.cancel = false;
							var _d = this.tree.fireEvent("nodedragover", _c);
							return _c.cancel === false && _d !== false;
						},
						getDropPoint : function(e, n, dd) {
							var tn = n.node;
							if (tn.isRoot) {
								return tn.allowChildren !== false ? "append"
										: false;
							}
							var _12 = n.ddel;
							var t = Ext.lib.Dom.getY(_12), b = t
									+ _12.offsetHeight;
							var y = Ext.lib.Event.getPageY(e);
							var _16 = tn.allowChildren === false || tn.isLeaf();
							if (this.appendOnly
									|| tn.parentNode.allowChildren === false) {
								return _16 ? false : "append";
							}
							var _17 = false;
							if (!this.allowParentInsert) {
								_17 = tn.hasChildNodes() && tn.isExpanded();
							}
							var q = (b - t) / (_16 ? 2 : 3);
							if (y >= t && y < (t + q)) {
								return "above";
							} else {
								if (!_17 && (_16 || y >= b - q && y <= b)) {
									return "below";
								} else {
									return "append";
								}
							}
						},
						onNodeEnter : function(n, dd, e, _1c) {
							this.cancelExpand();
						},
						onNodeOver : function(n, dd, e, _20) {
							var pt = this.getDropPoint(e, n, dd);
							var _22 = n.node;
							if (!this.expandProcId && pt == "append"
									&& _22.hasChildNodes()
									&& !n.node.isExpanded()) {
								this.queueExpand(_22);
							} else {
								if (pt != "append") {
									this.cancelExpand();
								}
							}
							var _23 = this.dropNotAllowed;
							if (this.isValidDropPoint(n, pt, dd, e, _20)) {
								if (pt) {
									var el = n.ddel;
									var cls;
									if (pt == "above") {
										_23 = n.node.isFirst() ? "x-tree-drop-ok-above"
												: "x-tree-drop-ok-between";
										cls = "x-tree-drag-insert-above";
									} else {
										if (pt == "below") {
											_23 = n.node.isLast() ? "x-tree-drop-ok-below"
													: "x-tree-drop-ok-between";
											cls = "x-tree-drag-insert-below";
										} else {
											_23 = "x-tree-drop-ok-append";
											cls = "x-tree-drag-append";
										}
									}
									if (this.lastInsertClass != cls) {
										Ext.fly(el).replaceClass(
												this.lastInsertClass, cls);
										this.lastInsertClass = cls;
									}
								}
							}
							return _23;
						},
						onNodeOut : function(n, dd, e, _29) {
							this.cancelExpand();
							this.removeDropIndicators(n);
						},
						onNodeDrop : function(n, dd, e, _2d) {
							var _2e = this.getDropPoint(e, n, dd);
							var _2f = n.node;
							_2f.ui.startDrop();
							if (!this.isValidDropPoint(n, _2e, dd, e, _2d)) {
								_2f.ui.endDrop();
								return false;
							}
							var _30 = _2d.node
									|| (dd.getTreeNode ? dd.getTreeNode(_2d,
											_2f, _2e, e) : null);
							var _31 = {
								tree : this.tree,
								target : _2f,
								data : _2d,
								point : _2e,
								source : dd,
								rawEvent : e,
								dropNode : _30,
								cancel : !_30
							};
							var _32 = this.tree
									.fireEvent("beforenodedrop", _31);
							if (_32 === false || _31.cancel === true
									|| !_31.dropNode) {
								_2f.ui.endDrop();
								return false;
							}
							_2f = _31.target;
							if (_2e == "append" && !_2f.isExpanded()) {
								_2f.expand(false, null, function() {
									this.completeDrop(_31);
								}.createDelegate(this));
							} else {
								this.completeDrop(_31);
							}
							return true;
						},
						completeDrop : function(de) {
							var ns = de.dropNode, p = de.point, t = de.target;
							if (!(ns instanceof Array)) {
								ns = [ ns ];
							}
							var n;
							for ( var i = 0, len = ns.length; i < len; i++) {
								n = ns[i];
								if (p == "above") {
									t.parentNode.insertBefore(n, t);
								} else {
									if (p == "below") {
										t.parentNode.insertBefore(n,
												t.nextSibling);
									} else {
										t.appendChild(n);
									}
								}
							}
							n.ui.focus();
							if (this.tree.hlDrop) {
								n.ui.highlight();
							}
							t.ui.endDrop();
							this.tree.fireEvent("nodedrop", de);
						},
						afterNodeMoved : function(dd, _3b, e, _3d, _3e) {
							if (this.tree.hlDrop) {
								_3e.ui.focus();
								_3e.ui.highlight();
							}
							this.tree.fireEvent("nodedrop", this.tree, _3d,
									_3b, dd, e);
						},
						getTree : function() {
							return this.tree;
						},
						removeDropIndicators : function(n) {
							if (n && n.ddel) {
								var el = n.ddel;
								Ext.fly(el).removeClass(
										[ "x-tree-drag-insert-above",
												"x-tree-drag-insert-below",
												"x-tree-drag-append" ]);
								this.lastInsertClass = "_noclass";
							}
						},
						beforeDragDrop : function(_41, e, id) {
							this.cancelExpand();
							return true;
						},
						afterRepair : function(_44) {
							if (_44 && Ext.enableFx) {
								_44.node.ui.highlight();
							}
							this.hideProxy();
						}
					});
}

if (Ext.dd.DragZone) {
	Ext.tree.TreeDragZone = function(_1, _2) {
		Ext.tree.TreeDragZone.superclass.constructor.call(this, _1.getEl(), _2);
		this.tree = _1;
	};
	Ext.extend(Ext.tree.TreeDragZone, Ext.dd.DragZone, {
		ddGroup : "TreeDD",
		onBeforeDrag : function(_3, e) {
			var n = _3.node;
			return n && n.draggable && !n.disabled;
		},
		onInitDrag : function(e) {
			var _7 = this.dragData;
			this.tree.getSelectionModel().select(_7.node);
			this.proxy.update("");
			_7.node.ui.appendDDGhost(this.proxy.ghost.dom);
			this.tree.fireEvent("startdrag", this.tree, _7.node, e);
		},
		getRepairXY : function(e, _9) {
			return _9.node.ui.getDDRepairXY();
		},
		onEndDrag : function(_a, e) {
			this.tree.fireEvent("enddrag", this.tree, _a.node, e);
		},
		onValidDrop : function(dd, e, id) {
			this.tree.fireEvent("dragdrop", this.tree, this.dragData.node, dd,
					e);
			this.hideProxy();
		},
		beforeInvalidDrop : function(e, id) {
			var sm = this.tree.getSelectionModel();
			sm.clearSelections();
			sm.select(this.dragData.node);
		}
	});
}

Ext.tree.TreeEditor = function(_1, _2) {
	_2 = _2 || {};
	var _3 = _2.events ? _2 : new Ext.form.TextField(_2);
	Ext.tree.TreeEditor.superclass.constructor.call(this, _3);
	this.tree = _1;
	_1.on("beforeclick", this.beforeNodeClick, this);
	_1.el.on("mousedown", this.hide, this);
	this.on("complete", this.updateNode, this);
	this.on("beforestartedit", this.fitToTree, this);
	this.on("startedit", this.bindScroll, this, {
		delay : 10
	});
	this.on("specialkey", this.onSpecialKey, this);
};
Ext.extend(Ext.tree.TreeEditor, Ext.Editor, {
	alignment : "l-l",
	autoSize : false,
	hideEl : false,
	cls : "x-small-editor x-tree-editor",
	shim : false,
	shadow : "frame",
	maxWidth : 250,
	fitToTree : function(ed, el) {
		var td = this.tree.el.dom, nd = el.dom;
		if (td.scrollLeft > nd.offsetLeft) {
			td.scrollLeft = nd.offsetLeft;
		}
		var w = Math.min(this.maxWidth, td.clientWidth
				- Math.max(0, nd.offsetLeft - td.scrollLeft) - 5);
		this.setSize(w, "");
	},
	triggerEdit : function(_9) {
		this.completeEdit();
		this.editNode = _9;
		this.startEdit(_9.ui.textNode, _9.text);
	},
	bindScroll : function() {
		this.tree.el.on("scroll", this.cancelEdit, this);
	},
	beforeNodeClick : function(_a) {
		if (this.tree.getSelectionModel().isSelected(_a)) {
			this.triggerEdit(_a);
			return false;
		}
	},
	updateNode : function(ed, _c) {
		this.tree.el.un("scroll", this.cancelEdit, this);
		this.editNode.setText(_c);
	},
	onSpecialKey : function(_d, e) {
		var k = e.getKey();
		if (k == e.ESC) {
			this.cancelEdit();
			e.stopEvent();
		} else {
			if (k == e.ENTER && !e.hasModifier()) {
				this.completeEdit();
				e.stopEvent();
			}
		}
	}
});

Ext.menu.Menu = function(_1) {
	Ext.apply(this, _1);
	this.id = this.id || Ext.id();
	this.events = {
		beforeshow : true,
		beforehide : true,
		show : true,
		hide : true,
		click : true,
		mouseover : true,
		mouseout : true,
		itemclick : true
	};
	Ext.menu.MenuMgr.register(this);
	var _2 = this.items;
	this.items = new Ext.util.MixedCollection();
	if (_2) {
		this.add.apply(this, _2);
	}
};
Ext.extend(Ext.menu.Menu, Ext.util.Observable, {
	minWidth : 120,
	shadow : "sides",
	subMenuAlign : "tl-tr?",
	defaultAlign : "tl-bl?",
	allowOtherMenus : false,
	render : function() {
		if (this.el) {
			return;
		}
		var el = this.el = new Ext.Layer( {
			cls : "x-menu",
			shadow : this.shadow,
			constrain : false,
			parentEl : this.parentEl || document.body,
			zindex : 15000
		});
		this.keyNav = new Ext.menu.MenuNav(this);
		if (this.plain) {
			el.addClass("x-menu-plain");
		}
		if (this.cls) {
			el.addClass(this.cls);
		}
		this.focusEl = el.createChild( {
			tag : "a",
			cls : "x-menu-focus",
			href : "#",
			onclick : "return false;",
			tabIndex : "-1"
		});
		var ul = el.createChild( {
			tag : "ul",
			cls : "x-menu-list"
		});
		ul.on("click", this.onClick, this);
		ul.on("mouseover", this.onMouseOver, this);
		ul.on("mouseout", this.onMouseOut, this);
		this.items.each(function(_5) {
			var li = document.createElement("li");
			li.className = "x-menu-list-item";
			ul.dom.appendChild(li);
			_5.render(li, this);
		}, this);
		this.ul = ul;
		this.autoWidth();
	},
	autoWidth : function() {
		var el = this.el, ul = this.ul;
		if (!el) {
			return;
		}
		var w = this.width;
		if (w) {
			el.setWidth(w);
		} else {
			if (Ext.isIE) {
				el.setWidth(this.minWidth);
				var t = el.dom.offsetWidth;
				el.setWidth(ul.getWidth() + el.getFrameWidth("lr"));
			}
		}
	},
	delayAutoWidth : function() {
		if (this.rendered) {
			if (!this.awTask) {
				this.awTask = new Ext.util.DelayedTask(this.autoWidth, this);
			}
			this.awTask.delay(20);
		}
	},
	findTargetItem : function(e) {
		var t = e.getTarget(".x-menu-list-item", this.ul, true);
		if (t && t.menuItemId) {
			return this.items.get(t.menuItemId);
		}
	},
	onClick : function(e) {
		var t;
		if (t = this.findTargetItem(e)) {
			t.onClick(e);
			this.fireEvent("click", this, t, e);
		}
	},
	setActiveItem : function(_f, _10) {
		if (_f != this.activeItem) {
			if (this.activeItem) {
				this.activeItem.deactivate();
			}
			this.activeItem = _f;
			_f.activate(_10);
		} else {
			if (_10) {
				_f.expandMenu();
			}
		}
	},
	tryActivate : function(_11, _12) {
		var _13 = this.items;
		for ( var i = _11, len = _13.length; i >= 0 && i < len; i += _12) {
			var _16 = _13.get(i);
			if (!_16.disabled && _16.canActivate) {
				this.setActiveItem(_16, false);
				return _16;
			}
		}
		return false;
	},
	onMouseOver : function(e) {
		var t;
		if (t = this.findTargetItem(e)) {
			if (t.canActivate && !t.disabled) {
				this.setActiveItem(t, true);
			}
		}
		this.fireEvent("mouseover", this, e, t);
	},
	onMouseOut : function(e) {
		var t;
		if (t = this.findTargetItem(e)) {
			if (t == this.activeItem && t.shouldDeactivate(e)) {
				this.activeItem.deactivate();
				delete this.activeItem;
			}
		}
		this.fireEvent("mouseout", this, e, t);
	},
	isVisible : function() {
		return this.el && this.el.isVisible();
	},
	show : function(el, pos, _1d) {
		this.parentMenu = _1d;
		if (!this.el) {
			this.render();
		}
		this.fireEvent("beforeshow", this);
		this.showAt(this.el.getAlignToXY(el, pos || this.defaultAlign), _1d,
				false);
	},
	showAt : function(xy, _1f, _20) {
		this.parentMenu = _1f;
		if (!this.el) {
			this.render();
		}
		if (_20 !== false) {
			this.fireEvent("beforeshow", this);
		}
		this.el.setXY(xy);
		this.el.show();
		this.focusEl.focus.defer(50, this.focusEl);
		this.fireEvent("show", this);
	},
	hide : function(_21) {
		if (this.el && this.isVisible()) {
			this.fireEvent("beforehide", this);
			if (this.activeItem) {
				this.activeItem.deactivate();
				this.activeItem = null;
			}
			this.el.hide();
			this.fireEvent("hide", this);
		}
		if (_21 === true && this.parentMenu) {
			this.parentMenu.hide(true);
		}
	},
	add : function() {
		var a = arguments, l = a.length, _24;
		for ( var i = 0; i < l; i++) {
			var el = a[i];
			if (el.render) {
				_24 = this.addItem(el);
			} else {
				if (typeof el == "string") {
					if (el == "separator" || el == "-") {
						_24 = this.addSeparator();
					} else {
						_24 = this.addText(el);
					}
				} else {
					if (el.tagName || el.el) {
						_24 = this.addElement(el);
					} else {
						if (typeof el == "object") {
							_24 = this.addMenuItem(el);
						}
					}
				}
			}
		}
		return _24;
	},
	getEl : function() {
		if (!this.el) {
			this.render();
		}
		return this.el;
	},
	addSeparator : function() {
		return this.addItem(new Ext.menu.Separator());
	},
	addElement : function(el) {
		return this.addItem(new Ext.menu.BaseItem(el));
	},
	addItem : function(_28) {
		this.items.add(_28);
		if (this.ul) {
			var li = document.createElement("li");
			li.className = "x-menu-list-item";
			this.ul.dom.appendChild(li);
			_28.render(li, this);
			this.delayAutoWidth();
		}
		return _28;
	},
	addMenuItem : function(_2a) {
		if (!(_2a instanceof Ext.menu.Item)) {
			_2a = new Ext.menu.Item(_2a);
		}
		return this.addItem(_2a);
	},
	addText : function(_2b) {
		return this.addItem(new Ext.menu.TextItem(_2b));
	},
	insert : function(_2c, _2d) {
		this.items.insert(_2c, _2d);
		if (this.ul) {
			var li = document.createElement("li");
			li.className = "x-menu-list-item";
			this.ul.dom.insertBefore(li, this.ul.dom.childNodes[_2c]);
			_2d.render(li, this);
			this.delayAutoWidth();
		}
		return _2d;
	},
	remove : function(_2f) {
		this.items.removeKey(_2f.id);
		_2f.destroy();
	},
	removeAll : function() {
		var f;
		while (f = this.items.first()) {
			this.remove(f);
		}
	}
});
Ext.menu.MenuNav = function(_31) {
	Ext.menu.MenuNav.superclass.constructor.call(this, _31.el);
	this.scope = this.menu = _31;
};
Ext.extend(Ext.menu.MenuNav, Ext.KeyNav, {
	doRelay : function(e, h) {
		var k = e.getKey();
		if (!this.menu.activeItem && e.isNavKeyPress() && k != e.SPACE
				&& k != e.RETURN) {
			this.menu.tryActivate(0, 1);
			return false;
		}
		return h.call(this.scope || this, e, this.menu);
	},
	up : function(e, m) {
		if (!m.tryActivate(m.items.indexOf(m.activeItem) - 1, -1)) {
			m.tryActivate(m.items.length - 1, -1);
		}
	},
	down : function(e, m) {
		if (!m.tryActivate(m.items.indexOf(m.activeItem) + 1, 1)) {
			m.tryActivate(0, 1);
		}
	},
	right : function(e, m) {
		if (m.activeItem) {
			m.activeItem.expandMenu(true);
		}
	},
	left : function(e, m) {
		m.hide();
		if (m.parentMenu && m.parentMenu.activeItem) {
			m.parentMenu.activeItem.activate();
		}
	},
	enter : function(e, m) {
		if (m.activeItem) {
			e.stopPropagation();
			m.activeItem.onClick(e);
			m.fireEvent("click", this, m.activeItem);
			return true;
		}
	}
});

Ext.menu.MenuMgr = function() {
	var _1, _2, _3 = {};
	function init() {
		_1 = {}, _2 = new Ext.util.MixedCollection();
		Ext.get(document).addKeyListener(27, function() {
			if (_2.length > 0) {
				hideAll();
			}
		});
	}
	function hideAll() {
		if (_2.length > 0) {
			var c = _2.clone();
			c.each(function(m) {
				m.hide();
			});
		}
	}
	function onHide(m) {
		_2.remove(m);
		if (_2.length < 1) {
			Ext.get(document).un("mousedown", onMouseDown);
		}
	}
	function onShow(m) {
		var _8 = _2.last();
		_2.add(m);
		if (_2.length == 1) {
			Ext.get(document).on("mousedown", onMouseDown);
		}
		if (m.parentMenu) {
			m.getEl().setZIndex(
					parseInt(m.parentMenu.getEl().getStyle("z-index"), 10) + 3);
			m.parentMenu.activeChild = m;
		} else {
			if (_8 && _8.isVisible()) {
				m.getEl().setZIndex(
						parseInt(_8.getEl().getStyle("z-index"), 10) + 3);
			}
		}
	}
	function onBeforeHide(m) {
		if (m.activeChild) {
			m.activeChild.hide();
		}
		if (m.autoHideTimer) {
			clearTimeout(m.autoHideTimer);
			delete m.autoHideTimer;
		}
	}
	function onBeforeShow(m) {
		var pm = m.parentMenu;
		if (!pm && !m.allowOtherMenus) {
			hideAll();
		} else {
			if (pm && pm.activeChild) {
				pm.activeChild.hide();
			}
		}
	}
	function onMouseDown(e) {
		if (_2.length > 0 && !e.getTarget(".x-menu")) {
			hideAll();
		}
	}
	function onBeforeCheck(mi, _e) {
		if (_e) {
			var g = _3[mi.group];
			for ( var i = 0, l = g.length; i < l; i++) {
				if (g[i] != mi) {
					g[i].setChecked(false);
				}
			}
		}
	}
	return {
		hideAll : function() {
			hideAll();
		},
		register : function(_12) {
			if (!_1) {
				init();
			}
			_1[_12.id] = _12;
			_12.on("beforehide", onBeforeHide);
			_12.on("hide", onHide);
			_12.on("beforeshow", onBeforeShow);
			_12.on("show", onShow);
			var g = _12.group;
			if (g && _12.events["checkchange"]) {
				if (!_3[g]) {
					_3[g] = [];
				}
				_3[g].push(_12);
				_12.on("checkchange", onCheck);
			}
		},
		get : function(_14) {
			if (typeof _14 == "string") {
				return _1[_14];
			} else {
				if (_14.events) {
					return _14;
				} else {
					return new Ext.menu.Menu(_14);
				}
			}
		},
		unregister : function(_15) {
			delete _1[_15.id];
			_15.un("beforehide", onBeforeHide);
			_15.un("hide", onHide);
			_15.un("beforeshow", onBeforeShow);
			_15.un("show", onShow);
			var g = _15.group;
			if (g && _15.events["checkchange"]) {
				_3[g].remove(_15);
				_15.un("checkchange", onCheck);
			}
		},
		registerCheckable : function(_17) {
			var g = _17.group;
			if (g) {
				if (!_3[g]) {
					_3[g] = [];
				}
				_3[g].push(_17);
				_17.on("beforecheckchange", onBeforeCheck);
			}
		},
		unregisterCheckable : function(_19) {
			var g = _19.group;
			if (g) {
				_3[g].remove(_19);
				_19.un("beforecheckchange", onBeforeCheck);
			}
		}
	};
}();

Ext.menu.BaseItem = function(_1) {
	Ext.menu.BaseItem.superclass.constructor.call(this, _1);
	this.addEvents( {
		click : true,
		activate : true,
		deactivate : true
	});
	if (this.handler) {
		this.on("click", this.handler, this.scope, true);
	}
};
Ext.extend(Ext.menu.BaseItem, Ext.Component, {
	canActivate : false,
	activeClass : "x-menu-item-active",
	hideOnClick : true,
	hideDelay : 100,
	ctype : "Ext.menu.BaseItem",
	actionMode : "container",
	render : function(_2, _3) {
		this.parentMenu = _3;
		Ext.menu.BaseItem.superclass.render.call(this, _2);
		this.container.menuItemId = this.id;
	},
	onRender : function(_4) {
		this.el = Ext.get(this.el);
		_4.dom.appendChild(this.el.dom);
	},
	onClick : function(e) {
		if (!this.disabled && this.fireEvent("click", this, e) !== false
				&& this.parentMenu.fireEvent("itemclick", this, e) !== false) {
			this.handleClick(e);
		} else {
			e.stopEvent();
		}
	},
	activate : function() {
		if (this.disabled) {
			return false;
		}
		var li = this.container;
		li.addClass(this.activeClass);
		this.region = li.getRegion().adjust(2, 2, -2, -2);
		this.fireEvent("activate", this);
		return true;
	},
	deactivate : function() {
		this.container.removeClass(this.activeClass);
		this.fireEvent("deactivate", this);
	},
	shouldDeactivate : function(e) {
		return !this.region || !this.region.contains(e.getPoint());
	},
	handleClick : function(e) {
		if (this.hideOnClick) {
			this.parentMenu.hide.defer(this.hideDelay, this.parentMenu,
					[ true ]);
		}
	},
	expandMenu : function(_9) {
	},
	hideMenu : function() {
	}
});

Ext.menu.TextItem = function(_1) {
	this.text = _1;
	Ext.menu.TextItem.superclass.constructor.call(this);
};
Ext.extend(Ext.menu.TextItem, Ext.menu.BaseItem, {
	hideOnClick : false,
	itemCls : "x-menu-text",
	onRender : function() {
		var s = document.createElement("span");
		s.className = this.itemCls;
		s.innerHTML = this.text;
		this.el = s;
		Ext.menu.TextItem.superclass.onRender.apply(this, arguments);
	}
});

Ext.menu.Separator = function(_1) {
	Ext.menu.Separator.superclass.constructor.call(this, _1);
};
Ext.extend(Ext.menu.Separator, Ext.menu.BaseItem, {
	itemCls : "x-menu-sep",
	hideOnClick : false,
	onRender : function(li) {
		var s = document.createElement("span");
		s.className = this.itemCls;
		s.innerHTML = "&#160;";
		this.el = s;
		li.addClass("x-menu-sep-li");
		Ext.menu.Separator.superclass.onRender.apply(this, arguments);
	}
});

Ext.menu.Item = function(_1) {
	Ext.menu.Item.superclass.constructor.call(this, _1);
	if (this.menu) {
		this.menu = Ext.menu.MenuMgr.get(this.menu);
	}
};
Ext.extend(Ext.menu.Item, Ext.menu.BaseItem, {
	itemCls : "x-menu-item",
	canActivate : true,
	ctype : "Ext.menu.Item",
	onRender : function(_2) {
		var el = document.createElement("a");
		el.hideFocus = true;
		el.unselectable = "on";
		el.href = this.href || "#";
		if (this.hrefTarget) {
			el.target = this.hrefTarget;
		}
		el.className = this.itemCls + (this.menu ? " x-menu-item-arrow" : "")
				+ (this.cls ? " " + this.cls : "");
		el.innerHTML = String.format(
				"<img src=\"{0}\" class=\"x-menu-item-icon\">{1}", this.icon
						|| Ext.BLANK_IMAGE_URL, this.text);
		this.el = el;
		Ext.menu.Item.superclass.onRender.call(this, _2);
	},
	setText : function(_4) {
		this.text = _4;
		if (this.rendered) {
			this.el.update(String.format(
					"<img src=\"{0}\" class=\"x-menu-item-icon\">{1}",
					this.icon || Ext.BLANK_IMAGE_URL, this.text));
			this.parentMenu.autoWidth();
		}
	},
	handleClick : function(e) {
		if (!this.href) {
			e.stopEvent();
		}
		Ext.menu.Item.superclass.handleClick.apply(this, arguments);
	},
	activate : function(_6) {
		if (Ext.menu.Item.superclass.activate.apply(this, arguments)) {
			this.focus();
			if (_6) {
				this.expandMenu();
			}
		}
		return true;
	},
	shouldDeactivate : function(e) {
		if (Ext.menu.Item.superclass.shouldDeactivate.call(this, e)) {
			if (this.menu && this.menu.isVisible()) {
				return !this.menu.getEl().getRegion().contains(e.getPoint());
			}
			return true;
		}
		return false;
	},
	deactivate : function() {
		Ext.menu.Item.superclass.deactivate.apply(this, arguments);
		this.hideMenu();
	},
	expandMenu : function(_8) {
		if (!this.disabled && this.menu) {
			if (!this.menu.isVisible()) {
				this.menu.show(this.container, this.parentMenu.subMenuAlign
						|| "tl-tr?", this.parentMenu);
			}
			if (_8) {
				this.menu.tryActivate(0, 1);
			}
		}
	},
	hideMenu : function() {
		if (this.menu && this.menu.isVisible()) {
			this.menu.hide();
		}
	}
});

Ext.menu.CheckItem = function(_1) {
	Ext.menu.CheckItem.superclass.constructor.call(this, _1);
	this.addEvents( {
		"beforecheckchange" : true,
		"checkchange" : true
	});
	if (this.checkHandler) {
		this.on("checkchange", this.checkHandler, this.scope);
	}
};
Ext.extend(Ext.menu.CheckItem, Ext.menu.Item, {
	itemCls : "x-menu-item x-menu-check-item",
	groupClass : "x-menu-group-item",
	checked : false,
	ctype : "Ext.menu.CheckItem",
	onRender : function(c) {
		Ext.menu.CheckItem.superclass.onRender.apply(this, arguments);
		if (this.group) {
			this.el.addClass(this.groupClass);
		}
		Ext.menu.MenuMgr.registerCheckable(this);
		if (this.checked) {
			this.checked = false;
			this.setChecked(true, true);
		}
	},
	destroy : function() {
		if (this.rendered) {
			Ext.menu.MenuMgr.unregisterCheckable(this);
		}
		Ext.menu.CheckItem.superclass.destroy.apply(this, arguments);
	},
	setChecked : function(_3, _4) {
		if (this.checked != _3
				&& this.fireEvent("beforecheckchange", this, _3) !== false) {
			if (this.container) {
				this.container[_3 ? "addClass" : "removeClass"]
						("x-menu-item-checked");
			}
			this.checked = _3;
			if (_4 !== true) {
				this.fireEvent("checkchange", this, _3);
			}
		}
	},
	handleClick : function(e) {
		if (!this.disabled && !(this.checked && this.group)) {
			this.setChecked(!this.checked);
		}
		Ext.menu.CheckItem.superclass.handleClick.apply(this, arguments);
	}
});

Ext.menu.Adapter = function(_1, _2) {
	Ext.menu.Adapter.superclass.constructor.call(this, _2);
	this.component = _1;
};
Ext.extend(Ext.menu.Adapter, Ext.menu.BaseItem, {
	canActivate : true,
	onRender : function(_3) {
		this.component.render(_3);
		this.el = this.component.getEl();
	},
	activate : function() {
		if (this.disabled) {
			return false;
		}
		this.component.focus();
		this.fireEvent("activate", this);
		return true;
	},
	deactivate : function() {
		this.fireEvent("deactivate", this);
	},
	disable : function() {
		this.component.disable();
		Ext.menu.Adapter.superclass.disable.call(this);
	},
	enable : function() {
		this.component.enable();
		Ext.menu.Adapter.superclass.enable.call(this);
	}
});

Ext.menu.DateItem = function(_1) {
	Ext.menu.DateItem.superclass.constructor.call(this, new Ext.DatePicker(_1),
			_1);
	this.picker = this.component;
	this.addEvents( {
		select : true
	});
	this.picker.on("render", function(_2) {
		_2.getEl().swallowEvent("click");
		_2.container.addClass("x-menu-date-item");
	});
	this.picker.on("select", this.onSelect, this);
};
Ext.extend(Ext.menu.DateItem, Ext.menu.Adapter, {
	onSelect : function(_3, _4) {
		this.fireEvent("select", this, _4, _3);
		Ext.menu.DateItem.superclass.handleClick.call(this);
	}
});

Ext.menu.ColorItem = function(_1) {
	Ext.menu.ColorItem.superclass.constructor.call(this, new Ext.ColorPalette(
			_1), _1);
	this.palette = this.component;
	this.relayEvents(this.palette, [ "select" ]);
	if (this.selectHandler) {
		this.on("select", this.selectHandler, this.scope);
	}
};
Ext.extend(Ext.menu.ColorItem, Ext.menu.Adapter);

Ext.menu.DateMenu = function(_1) {
	Ext.menu.DateMenu.superclass.constructor.call(this, _1);
	this.plain = true;
	var di = new Ext.menu.DateItem(_1);
	this.add(di);
	this.picker = di.picker;
	this.relayEvents(di, [ "select" ]);
};
Ext.extend(Ext.menu.DateMenu, Ext.menu.Menu);

Ext.menu.ColorMenu = function(_1) {
	Ext.menu.ColorMenu.superclass.constructor.call(this, _1);
	this.plain = true;
	var ci = new Ext.menu.ColorItem(_1);
	this.add(ci);
	this.palette = ci.palette;
	this.relayEvents(ci, [ "select" ]);
};
Ext.extend(Ext.menu.ColorMenu, Ext.menu.Menu);

Ext.form.Field = function(_1) {
	Ext.form.Field.superclass.constructor.call(this, _1);
	this.addEvents( {
		focus : true,
		blur : true,
		specialkey : true,
		change : true,
		invalid : true,
		valid : true
	});
};
Ext.extend(Ext.form.Field, Ext.Component, {
	invalidClass : "x-form-invalid",
	invalidText : "The value in this field is invalid",
	focusClass : "x-form-focus",
	validationEvent : "keyup",
	validationDelay : 250,
	defaultAutoCreate : {
		tag : "input",
		type : "text",
		size : "20",
		autocomplete : "off"
	},
	fieldClass : "x-form-field",
	msgTarget : "qtip",
	msgFx : "normal",
	inputType : undefined,
	isFormField : true,
	hasFocus : false,
	getName : function() {
		return this.rendered && this.el.dom.name ? this.el.dom.name
				: (this.hiddenName || "");
	},
	applyTo : function(_2) {
		this.target = _2;
		this.el = Ext.get(_2);
		this.render(this.el.dom.parentNode);
		return this;
	},
	onRender : function(ct) {
		if (this.el) {
			this.el = Ext.get(this.el);
			if (!this.target) {
				ct.dom.appendChild(this.el.dom);
			}
		} else {
			var _4 = this.getAutoCreate();
			if (!_4.name) {
				_4.name = this.name || this.id;
			}
			if (this.inputType) {
				_4.type = this.inputType;
			}
			if (this.tabIndex !== undefined) {
				_4.tabIndex = this.tabIndex;
			}
			this.el = ct.createChild(_4);
		}
		var _5 = this.el.dom.type;
		if (_5) {
			if (_5 == "password") {
				_5 = "text";
			}
			this.el.addClass("x-form-" + _5);
		}
		if (!this.customSize && (this.width || this.height)) {
			this.setSize(this.width || "", this.height || "");
		}
		if (this.style) {
			this.el.applyStyles(this.style);
			delete this.style;
		}
		if (this.readOnly) {
			this.el.dom.readOnly = true;
		}
		this.el.addClass( [ this.fieldClass, this.cls ]);
		this.initValue();
	},
	initValue : function() {
		if (this.value !== undefined) {
			this.setValue(this.value);
		} else {
			if (this.el.dom.value.length > 0) {
				this.setValue(this.el.dom.value);
			}
		}
	},
	afterRender : function() {
		this.initEvents();
	},
	fireKey : function(e) {
		if (e.isNavKeyPress()) {
			this.fireEvent("specialkey", this, e);
		}
	},
	reset : function() {
		this.setValue(this.originalValue);
		this.clearInvalid();
	},
	initEvents : function() {
		this.el.on(Ext.isIE ? "keydown" : "keypress", this.fireKey, this);
		this.el.on("focus", this.onFocus, this);
		this.el.on("blur", this.onBlur, this);
		this.originalValue = this.getValue();
	},
	onFocus : function() {
		if (!Ext.isOpera) {
			this.el.addClass(this.focusClass);
		}
		this.hasFocus = true;
		this.startValue = this.getValue();
		this.fireEvent("focus", this);
	},
	onBlur : function() {
		this.el.removeClass(this.focusClass);
		this.hasFocus = false;
		if (this.validationEvent != "blur") {
			this.validate();
		}
		var v = this.getValue();
		if (v != this.startValue) {
			this.fireEvent("change", this, v, this.startValue);
		}
		this.fireEvent("blur", this);
	},
	setSize : function(w, h) {
		if (!this.rendered || !this.el) {
			this.width = w;
			this.height = h;
			return;
		}
		if (w) {
			w = this.adjustWidth(this.el.dom.tagName, w);
			this.el.setWidth(w);
		}
		if (h) {
			this.el.setHeight(h);
		}
		var h = this.el.dom.offsetHeight;
	},
	isValid : function() {
		return this.validateValue(this.getRawValue());
	},
	validate : function() {
		if (this.validateValue(this.getRawValue())) {
			this.clearInvalid();
			return true;
		}
		return false;
	},
	validateValue : function(_a) {
		return true;
	},
	markInvalid : function(_b) {
		if (!this.rendered) {
			return;
		}
		this.el.addClass(this.invalidClass);
		_b = _b || this.invalidText;
		switch (this.msgTarget) {
		case "qtip":
			this.el.dom.qtip = _b;
			this.el.dom.qclass = "x-form-invalid-tip";
			break;
		case "title":
			this.el.dom.title = _b;
			break;
		case "under":
			if (!this.errorEl) {
				var _c = this.el.findParent(".x-form-element", 5, true);
				this.errorEl = _c.createChild( {
					cls : "x-form-invalid-msg"
				});
				this.errorEl.setWidth(_c.getWidth(true) - 20);
			}
			this.errorEl.update(_b);
			Ext.form.Field.msgFx[this.msgFx].show(this.errorEl, this);
			break;
		case "side":
			if (!this.errorIcon) {
				var _c = this.el.findParent(".x-form-element", 5, true);
				this.errorIcon = _c.createChild( {
					cls : "x-form-invalid-icon"
				});
			}
			this.alignErrorIcon();
			this.errorIcon.dom.qtip = _b;
			this.errorIcon.dom.qclass = "x-form-invalid-tip";
			this.errorIcon.show();
			break;
		default:
			var t = Ext.getDom(this.msgTarget);
			t.innerHTML = _b;
			t.style.display = this.msgDisplay;
			break;
		}
		this.fireEvent("invalid", this, _b);
	},
	alignErrorIcon : function() {
		this.errorIcon.alignTo(this.el, "tl-tr", [ 2, 0 ]);
	},
	clearInvalid : function() {
		if (!this.rendered) {
			return;
		}
		this.el.removeClass(this.invalidClass);
		switch (this.msgTarget) {
		case "qtip":
			this.el.dom.qtip = "";
			break;
		case "title":
			this.el.dom.title = "";
			break;
		case "under":
			if (this.errorEl) {
				Ext.form.Field.msgFx[this.msgFx].hide(this.errorEl, this);
			}
			break;
		case "side":
			if (this.errorIcon) {
				this.errorIcon.dom.qtip = "";
				this.errorIcon.hide();
			}
			break;
		default:
			var t = Ext.getDom(this.msgTarget);
			t.innerHTML = "";
			t.style.display = "none";
			break;
		}
		this.fireEvent("valid", this);
	},
	getRawValue : function() {
		return this.el.getValue();
	},
	getValue : function() {
		var v = this.el.getValue();
		if (v == this.emptyText || v === undefined) {
			v = "";
		}
		return v;
	},
	setRawValue : function(v) {
		return this.el.dom.value = v;
	},
	setValue : function(v) {
		this.value = v;
		if (this.rendered) {
			this.el.dom.value = v;
			this.validate();
		}
	},
	adjustWidth : function(tag, w) {
		tag = tag.toLowerCase();
		if (typeof w == "number" && Ext.isStrict && !Ext.isSafari) {
			if (Ext.isIE && (tag == "input" || tag == "textarea")) {
				if (tag == "input") {
					return w + 2;
				}
				if (tag = "textarea") {
					return w - 2;
				}
			} else {
				if (Ext.isGecko && tag == "textarea") {
					return w - 6;
				} else {
					if (Ext.isOpera) {
						if (tag == "input") {
							return w + 2;
						}
						if (tag = "textarea") {
							return w - 2;
						}
					}
				}
			}
		}
		return w;
	}
});
Ext.form.Field.msgFx = {
	normal : {
		show : function(_14, f) {
			_14.setDisplayed("block");
		},
		hide : function(_16, f) {
			_16.setDisplayed(false).update("");
		}
	},
	slide : {
		show : function(_18, f) {
			_18.slideIn("t", {
				stopFx : true
			});
		},
		hide : function(_1a, f) {
			_1a.slideOut("t", {
				stopFx : true,
				useDisplay : true
			});
		}
	},
	slideRight : {
		show : function(_1c, f) {
			_1c.fixDisplay();
			_1c.alignTo(f.el, "tl-tr");
			_1c.slideIn("l", {
				stopFx : true
			});
		},
		hide : function(_1e, f) {
			_1e.slideOut("l", {
				stopFx : true,
				useDisplay : true
			});
		}
	}
};

Ext.form.TextField = function(_1) {
	Ext.form.TextField.superclass.constructor.call(this, _1);
	this.addEvents( {
		autosize : true
	});
};
Ext
		.extend(
				Ext.form.TextField,
				Ext.form.Field,
				{
					grow : false,
					growMin : 30,
					growMax : 800,
					vtype : null,
					maskRe : null,
					disableKeyFilter : false,
					allowBlank : true,
					minLength : 0,
					maxLength : Number.MAX_VALUE,
					minLengthText : "The minimum length for this field is {0}",
					maxLengthText : "The maximum length for this field is {0}",
					selectOnFocus : false,
					blankText : "This field is required",
					validator : null,
					regex : null,
					regexText : "",
					emptyText : null,
					emptyClass : "x-form-empty-field",
					initEvents : function() {
						Ext.form.TextField.superclass.initEvents.call(this);
						if (this.validationEvent == "keyup") {
							this.validationTask = new Ext.util.DelayedTask(
									this.validate, this);
							this.el.on("keyup", this.filterValidation, this);
						} else {
							if (this.validationEvent !== false) {
								this.el.on(this.validationEvent, this.validate,
										this, {
											buffer : this.validationDelay
										});
							}
						}
						if (this.selectOnFocus || this.emptyText) {
							this.on("focus", this.preFocus, this);
							if (this.emptyText) {
								this.on("blur", this.postBlur, this);
								if (!this.value
										&& this.getRawValue().length < 1) {
									this.setRawValue(this.emptyText);
									this.el.addClass(this.emptyClass);
								}
							}
						}
						if (this.maskRe
								|| (this.vtype
										&& this.disableKeyFilter !== true && (this.maskRe = Ext.form.VTypes[this.vtype
										+ "Mask"]))) {
							this.el.on("keypress", this.filterKeys, this);
						}
						if (this.grow) {
							this.el.on("keyup", this.onKeyUp, this, {
								buffer : 50
							});
							this.el.on("click", this.autoSize, this);
						}
					},
					filterValidation : function(e) {
						if (!e.isNavKeyPress()) {
							this.validationTask.delay(this.validationDelay);
						}
					},
					onKeyUp : function(e) {
						if (!e.isNavKeyPress()) {
							this.autoSize();
						}
					},
					reset : function() {
						Ext.form.TextField.superclass.reset.call(this);
						if (this.emptyText && this.getRawValue().length < 1) {
							this.setRawValue(this.emptyText);
							this.el.addClass(this.emptyClass);
						}
					},
					preFocus : function() {
						if (this.emptyText) {
							if (this.getRawValue() == this.emptyText) {
								this.setRawValue("");
							}
							this.el.removeClass(this.emptyClass);
						}
						if (this.selectOnFocus) {
							this.el.dom.select();
						}
					},
					postBlur : function() {
						if (this.emptyText && this.getRawValue().length < 1) {
							this.setRawValue(this.emptyText);
							this.el.addClass(this.emptyClass);
						}
					},
					filterKeys : function(e) {
						var k = e.getKey();
						if (!Ext.isIE
								&& (e.isNavKeyPress() || k == e.BACKSPACE || (k == e.DELETE && e.button == -1))) {
							return;
						}
						var c = e.getCharCode();
						if (!this.maskRe.test(String.fromCharCode(c) || "")) {
							e.stopEvent();
						}
					},
					setValue : function(v) {
						if (this.emptyText && v !== undefined && v !== null
								&& v !== "") {
							this.el.removeClass(this.emptyClass);
						}
						Ext.form.TextField.superclass.setValue.apply(this,
								arguments);
					},
					validateValue : function(_8) {
						if (_8.length < 1 || _8 === this.emptyText) {
							if (this.allowBlank) {
								this.clearInvalid();
								return true;
							} else {
								this.markInvalid(this.blankText);
								return false;
							}
						}
						if (_8.length < this.minLength) {
							this.markInvalid(String.format(this.minLengthText,
									this.minLength));
							return false;
						}
						if (_8.length > this.maxLength) {
							this.markInvalid(String.format(this.maxLengthText,
									this.maxLength));
							return false;
						}
						if (this.vtype) {
							var vt = Ext.form.VTypes;
							if (!vt[this.vtype](_8)) {
								this.markInvalid(this.vtypeText
										|| vt[this.vtype + "Text"]);
								return false;
							}
						}
						if (typeof this.validator == "function") {
							var _a = this.validator(_8);
							if (_a !== true) {
								this.markInvalid(_a);
								return false;
							}
						}
						if (this.regex && !this.regex.test(_8)) {
							this.markInvalid(this.regexText);
							return false;
						}
						return true;
					},
					selectText : function(_b, _c) {
						var v = this.getRawValue();
						if (v.length > 0) {
							_b = _b === undefined ? 0 : _b;
							_c = _c === undefined ? v.length : _c;
							var d = this.el.dom;
							if (d.setSelectionRange) {
								d.setSelectionRange(_b, _c);
							} else {
								if (d.createTextRange) {
									var _f = d.createTextRange();
									_f.moveStart("character", _b);
									_f.moveEnd("character", v.length - _c);
									_f.select();
								}
							}
						}
					},
					autoSize : function() {
						if (!this.grow || !this.rendered) {
							return;
						}
						if (!this.metrics) {
							this.metrics = Ext.util.TextMetrics
									.createInstance(this.el);
						}
						var el = this.el;
						var v = el.dom.value + "&#160;";
						var w = Math.min(this.growMax, Math.max(this.metrics
								.getWidth(v) + 10, this.growMin));
						this.el.setWidth(w);
						this.fireEvent("autosize", this, w);
					}
				});

Ext.form.TriggerField = function(_1) {
	Ext.form.TriggerField.superclass.constructor.call(this, _1);
	this.mimicing = false;
	this.on("disable", this.disableWrapper, this);
	this.on("enable", this.enableWrapper, this);
};
Ext.extend(Ext.form.TriggerField, Ext.form.TextField, {
	defaultAutoCreate : {
		tag : "input",
		type : "text",
		size : "16",
		autocomplete : "off"
	},
	hideTrigger : false,
	autoSize : Ext.emptyFn,
	customSize : true,
	setSize : function(w, h) {
		if (!this.wrap) {
			this.width = w;
			this.height = h;
			return;
		}
		if (w) {
			var _4 = w;
			w = w - this.trigger.getWidth();
			Ext.form.TriggerField.superclass.setSize.call(this, w, h);
			this.wrap.setWidth(_4);
			if (this.onResize) {
				this.onResize(_4, h);
			}
		} else {
			Ext.form.TriggerField.superclass.setSize.call(this, w, h);
			this.wrap.setWidth(this.el.getWidth() + this.trigger.getWidth());
		}
	},
	alignErrorIcon : function() {
		this.errorIcon.alignTo(this.wrap, "tl-tr", [ 2, 0 ]);
	},
	onRender : function(ct) {
		Ext.form.TriggerField.superclass.onRender.call(this, ct);
		this.wrap = this.el.wrap( {
			cls : "x-form-field-wrap"
		});
		this.trigger = this.wrap.createChild( {
			tag : "img",
			src : Ext.BLANK_IMAGE_URL,
			cls : "x-form-trigger " + this.triggerClass
		});
		this.trigger.on("click", this.onTriggerClick, this, {
			preventDefault : true
		});
		this.trigger.addClassOnOver("x-form-trigger-over");
		this.trigger.addClassOnClick("x-form-trigger-click");
		if (this.hideTrigger) {
			this.trigger.setDisplayed(false);
		}
		this.setSize(this.width || "", this.height || "");
	},
	onDestroy : function() {
		if (this.trigger) {
			this.trigger.removeAllListeners();
			this.trigger.remove();
		}
		if (this.wrap) {
			this.wrap.remove();
		}
		Ext.form.TriggerField.superclass.onDestroy.call(this);
	},
	onFocus : function() {
		Ext.form.TriggerField.superclass.onFocus.call(this);
		if (!this.mimicing) {
			this.mimicing = true;
			Ext.get(document).on("mousedown", this.mimicBlur, this);
			this.el.on("keydown", this.checkTab, this);
		}
	},
	checkTab : function(e) {
		if (e.getKey() == e.TAB) {
			this.triggerBlur();
		}
	},
	onBlur : function() {
	},
	mimicBlur : function(e, t) {
		if (!this.wrap.contains(t) && this.validateBlur()) {
			this.triggerBlur();
		}
	},
	triggerBlur : function() {
		this.mimicing = false;
		Ext.get(document).un("mousedown", this.mimicBlur);
		this.el.un("keydown", this.checkTab, this);
		Ext.form.TriggerField.superclass.onBlur.call(this);
	},
	validateBlur : function(e, t) {
		return true;
	},
	disableWrapper : function() {
		if (this.wrap) {
			this.wrap.addClass("x-item-disabled");
		}
	},
	enableWrapper : function() {
		if (this.wrap) {
			this.wrap.removeClass("x-item-disabled");
		}
	},
	onShow : function() {
		if (this.wrap) {
			this.wrap.dom.style.display = "";
			this.wrap.dom.style.visibility = "visible";
		}
	},
	onHide : function() {
		this.wrap.dom.style.display = "none";
	},
	onTriggerClick : Ext.emptyFn
});

Ext.form.TextArea = function(_1) {
	Ext.form.TextArea.superclass.constructor.call(this, _1);
	if (this.minHeight !== undefined) {
		this.growMin = this.minHeight;
	}
	if (this.maxHeight !== undefined) {
		this.growMax = this.maxHeight;
	}
};
Ext.extend(Ext.form.TextArea, Ext.form.TextField,
		{
			growMin : 60,
			growMax : 1000,
			preventScrollbars : false,
			onRender : function(ct) {
				if (!this.el) {
					this.defaultAutoCreate = {
						tag : "textarea",
						style : "width:300px;height:60px;",
						autocomplete : "off"
					};
				}
				Ext.form.TextArea.superclass.onRender.call(this, ct);
				if (this.grow) {
					this.textSizeEl = Ext.DomHelper.append(document.body, {
						tag : "pre",
						cls : "x-form-grow-sizer"
					});
					if (this.preventScrollbars) {
						this.el.setStyle("overflow", "hidden");
					}
					this.el.setHeight(this.growMin);
				}
			},
			onKeyUp : function(e) {
				if (!e.isNavKeyPress() || e.getKey() == e.ENTER) {
					this.autoSize();
				}
			},
			autoSize : function() {
				if (!this.grow || !this.textSizeEl) {
					return;
				}
				var el = this.el;
				var v = el.dom.value;
				var ts = this.textSizeEl;
				Ext.fly(ts).setWidth(this.el.getWidth());
				if (v.length < 1) {
					v = "&#160;&#160;";
				} else {
					v += "&#160;\n&#160;";
				}
				if (Ext.isIE) {
					v = v.replace(/\n/g, "<br />");
				}
				ts.innerHTML = v;
				var h = Math.min(this.growMax, Math.max(ts.offsetHeight,
						this.growMin));
				this.el.setHeight(h);
				this.fireEvent("autosize", this, h);
			},
			setValue : function(v) {
				Ext.form.TextArea.superclass.setValue.call(this, v);
				this.autoSize();
			}
		});

Ext.form.NumberField = function(_1) {
	Ext.form.NumberField.superclass.constructor.call(this, _1);
};
Ext
		.extend(
				Ext.form.NumberField,
				Ext.form.TextField,
				{
					fieldClass : "x-form-field x-form-num-field",
					allowDecimals : true,
					decimalSeparator : ".",
					decimalPrecision : 2,
					allowNegative : true,
					minValue : Number.NEGATIVE_INFINITY,
					maxValue : Number.MAX_VALUE,
					minText : "The minimum value for this field is {0}",
					maxText : "The maximum value for this field is {0}",
					nanText : "{0} is not a valid number",
					initEvents : function() {
						Ext.form.NumberField.superclass.initEvents.call(this);
						var _2 = "0123456789";
						if (this.allowDecimals) {
							_2 += this.decimalSeparator;
						}
						if (this.allowNegative) {
							_2 += "-";
						}
						var _3 = function(e) {
							var k = e.getKey();
							if (!Ext.isIE
									&& (e.isNavKeyPress() || k == e.BACKSPACE || (k == e.DELETE && e.button == -1))) {
								return;
							}
							var c = e.getCharCode();
							if (_2.indexOf(String.fromCharCode(c)) === -1) {
								e.stopEvent();
							}
						};
						this.el.on("keypress", _3, this);
					},
					validateValue : function(_7) {
						if (!Ext.form.NumberField.superclass.validateValue
								.call(this, _7)) {
							return false;
						}
						if (_7.length < 1) {
							return true;
						}
						if (isNaN(_7)) {
							this.markInvalid(String.format(this.nanText, _7));
							return false;
						}
						var _8 = this.parseValue(_7);
						if (_8 < this.minValue) {
							this.markInvalid(String.format(this.minText,
									this.minValue));
							return false;
						}
						if (_8 > this.maxValue) {
							this.markInvalid(String.format(this.maxText,
									this.maxValue));
							return false;
						}
						return true;
					},
					parseValue : function(_9) {
						return parseFloat(String(_9).replace(
								this.decimalSeparator, "."));
					},
					fixPrecision : function(_a) {
						if (!this.allowDecimals || this.decimalPrecision == -1
								|| isNaN(_a) || _a == 0 || !_a) {
							return _a;
						}
						var _b = Math.pow(10, this.decimalPrecision + 1);
						var _c = this.decimalPrecisionFcn(_a * _b);
						_c = this.decimalPrecisionFcn(_c / 10);
						return _c / (_b / 10);
					},
					decimalPrecisionFcn : function(v) {
						return Math.floor(v);
					}
				});

Ext.form.DateField = function(_1) {
	Ext.form.DateField.superclass.constructor.call(this, _1);
	if (typeof this.minValue == "string") {
		this.minValue = this.parseDate(this.minValue);
	}
	if (typeof this.maxValue == "string") {
		this.maxValue = this.parseDate(this.maxValue);
	}
	this.ddMatch = null;
	if (this.disabledDates) {
		var dd = this.disabledDates;
		var re = "(?:";
		for ( var i = 0; i < dd.length; i++) {
			re += dd[i];
			if (i != dd.length - 1) {
				re += "|";
			}
		}
		this.ddMatch = new RegExp(re + ")");
	}
};
Ext
		.extend(
				Ext.form.DateField,
				Ext.form.TriggerField,
				{
					format : "m/d/y",
					disabledDays : null,
					disabledDaysText : "Disabled",
					disabledDates : null,
					disabledDatesText : "Disabled",
					minValue : null,
					maxValue : null,
					minText : "The date in this field must be after {0}",
					maxText : "The date in this field must be before {0}",
					invalidText : "{0} is not a valid date - it must be in the format {1}",
					triggerClass : "x-form-date-trigger",
					defaultAutoCreate : {
						tag : "input",
						type : "text",
						size : "10",
						autocomplete : "off"
					},
					validateValue : function(_5) {
						_5 = this.formatDate(_5);
						if (!Ext.form.DateField.superclass.validateValue.call(
								this, _5)) {
							return false;
						}
						if (_5.length < 1) {
							return true;
						}
						var _6 = _5;
						_5 = this.parseDate(_5);
						if (!_5) {
							this.markInvalid(String.format(this.invalidText,
									_6, this.format));
							return false;
						}
						var _7 = _5.getTime();
						if (this.minValue && _7 < this.minValue.getTime()) {
							this.markInvalid(String.format(this.minText, this
									.formatDate(this.minValue)));
							return false;
						}
						if (this.maxValue && _7 > this.maxValue.getTime()) {
							this.markInvalid(String.format(this.maxText, this
									.formatDate(this.maxValue)));
							return false;
						}
						if (this.disabledDays) {
							var _8 = _5.getDay();
							for ( var i = 0; i < this.disabledDays.length; i++) {
								if (_8 === this.disabledDays[i]) {
									this.markInvalid(this.disabledDaysText);
									return false;
								}
							}
						}
						var _a = this.formatDate(_5);
						if (this.ddMatch && this.ddMatch.test(_a)) {
							this.markInvalid(String.format(
									this.disabledDatesText, _a));
							return false;
						}
						return true;
					},
					validateBlur : function() {
						return !this.menu || !this.menu.isVisible();
					},
					getValue : function() {
						return this
								.parseDate(Ext.form.DateField.superclass.getValue
										.call(this))
								|| "";
					},
					setValue : function(_b) {
						Ext.form.DateField.superclass.setValue.call(this, this
								.formatDate(this.parseDate(_b)));
					},
					parseDate : function(_c) {
						return (!_c || _c instanceof Date) ? _c : Date
								.parseDate(_c, this.format);
					},
					formatDate : function(_d) {
						return (!_d || !(_d instanceof Date)) ? _d : _d
								.dateFormat(this.format);
					},
					menuListeners : {
						select : function(m, d) {
							this.setValue(d);
						},
						show : function() {
							this.onFocus();
						},
						hide : function() {
							this.focus();
							var ml = this.menuListeners;
							this.menu.un("select", ml.select, this);
							this.menu.un("show", ml.show, this);
							this.menu.un("hide", ml.hide, this);
						}
					},
					onTriggerClick : function() {
						if (this.disabled) {
							return;
						}
						if (this.menu == null) {
							this.menu = new Ext.menu.DateMenu();
						}
						Ext.apply(this.menu, {
							minDate : this.minValue,
							maxDate : this.maxValue,
							disabledDatesRE : this.ddMatch,
							disabledDatesText : this.disabledDatesText,
							disabledDays : this.disabledDays,
							disabledDaysText : this.disabledDaysText,
							format : this.format,
							minText : String.format(this.minText, this
									.formatDate(this.minValue)),
							maxText : String.format(this.maxText, this
									.formatDate(this.maxValue))
						});
						this.menu.on(Ext.apply( {}, this.menuListeners, {
							scope : this
						}));
						this.menu.picker
								.setValue(this.getValue() || new Date());
						this.menu.show(this.el, "tl-bl?");
					}
				});

Ext.form.ComboBox = function(_1) {
	Ext.form.ComboBox.superclass.constructor.call(this, _1);
	this.addEvents( {
		"expand" : true,
		"collapse" : true,
		"beforeselect" : true,
		"select" : true,
		"beforequery" : true
	});
	if (this.transform) {
		var s = Ext.getDom(this.transform);
		if (!this.hiddenName) {
			this.hiddenName = s.name;
		}
		if (!this.store) {
			this.mode = "local";
			var d = [], _4 = s.options;
			for ( var i = 0, _6 = _4.length; i < _6; i++) {
				var o = _4[i];
				var _8 = (Ext.isIE ? o.getAttributeNode("value").specified : o
						.hasAttribute("value")) ? o.value : o.text;
				if (o.selected) {
					this.value = _8;
				}
				d.push( [ _8, o.text ]);
			}
			this.store = new Ext.data.SimpleStore( {
				"id" : 0,
				fields : [ "value", "text" ],
				data : d
			});
			this.valueField = "value";
			this.displayField = "text";
		}
		s.name = Ext.id();
		if (!this.lazyRender) {
			this.target = true;
			this.el = Ext.DomHelper.insertBefore(s, this.autoCreate
					|| this.defaultAutoCreate);
			s.parentNode.removeChild(s);
			this.render(this.el.parentNode);
		} else {
			s.parentNode.removeChild(s);
		}
	}
	this.selectedIndex = -1;
	if (this.mode == "local") {
		if (_1.queryDelay === undefined) {
			this.queryDelay = 10;
		}
		if (_1.minChars === undefined) {
			this.minChars = 0;
		}
	}
};
Ext
		.extend(
				Ext.form.ComboBox,
				Ext.form.TriggerField,
				{
					defaultAutoCreate : {
						tag : "input",
						type : "text",
						size : "24",
						autocomplete : "off"
					},
					listWidth : undefined,
					displayField : undefined,
					valueField : undefined,
					hiddenName : undefined,
					listClass : "",
					selectedClass : "x-combo-selected",
					triggerClass : "x-form-arrow-trigger",
					shadow : "sides",
					listAlign : "tl-bl?",
					maxHeight : 300,
					triggerAction : "query",
					minChars : 4,
					typeAhead : false,
					queryDelay : 500,
					pageSize : 0,
					selectOnFocus : false,
					queryParam : "query",
					loadingText : "Loading...",
					resizable : false,
					handleHeight : 8,
					editable : true,
					allQuery : "",
					mode : "remote",
					minListWidth : 70,
					forceSelection : false,
					typeAheadDelay : 250,
					valueNotFoundText : undefined,
					onRender : function(ct) {
						Ext.form.ComboBox.superclass.onRender.call(this, ct);
						if (this.hiddenName) {
							this.hiddenField = this.el.insertSibling( {
								tag : "input",
								type : "hidden",
								name : this.hiddenName,
								id : this.hiddenName
							}, "before", true);
							this.hiddenField.value = this.hiddenValue !== undefined ? this.hiddenValue
									: this.value !== undefined ? this.value
											: "";
							this.el.dom.removeAttribute("name");
						}
						if (Ext.isGecko) {
							this.el.dom.setAttribute("autocomplete", "off");
						}
						var _a = "x-combo-list";
						this.list = new Ext.Layer( {
							shadow : this.shadow,
							cls : [ _a, this.listClass ].join(" "),
							constrain : false
						});
						this.list.setWidth(this.listWidth
								|| Math.max(this.wrap.getWidth(),
										this.minListWidth));
						this.list.swallowEvent("mousewheel");
						this.assetHeight = 0;
						if (this.title) {
							this.header = this.list.createChild( {
								cls : _a + "-hd",
								html : this.title
							});
							this.assetHeight += this.header.getHeight();
						}
						this.innerList = this.list.createChild( {
							cls : _a + "-inner"
						});
						this.innerList.on("mouseover", this.onViewOver, this);
						this.innerList.on("mousemove", this.onViewMove, this);
						if (this.pageSize) {
							this.footer = this.list.createChild( {
								cls : _a + "-ft"
							});
							this.pageTb = new Ext.PagingToolbar(this.footer,
									this.store, {
										pageSize : this.pageSize
									});
							this.assetHeight += this.footer.getHeight();
						}
						if (!this.tpl) {
							this.tpl = "<div class=\"" + _a + "-item\">{"
									+ this.displayField + "}</div>";
						}
						this.view = new Ext.View(this.innerList, this.tpl, {
							singleSelect : true,
							store : this.store,
							selectedClass : this.selectedClass
						});
						this.view.on("click", this.onViewClick, this);
						this.store.on("beforeload", this.onBeforeLoad, this);
						this.store.on("load", this.onLoad, this);
						this.store.on("loadexception", this.collapse, this);
						if (this.resizable) {
							this.resizer = new Ext.Resizable(this.list, {
								pinned : true,
								handles : "se"
							});
							this.resizer.on("resize", function(r, w, h) {
								this.maxHeight = h - this.handleHeight
										- this.list.getFrameWidth("tb")
										- this.assetHeight;
								this.listWidth = w;
								this.restrictHeight();
							}, this);
							this[this.pageSize ? "footer" : "innerList"]
									.setStyle("margin-bottom",
											this.handleHeight + "px");
						}
						if (!this.editable) {
							this.editable = true;
							this.setEditable(false);
						}
					},
					initEvents : function() {
						Ext.form.ComboBox.superclass.initEvents.call(this);
						this.keyNav = new Ext.KeyNav(this.el, {
							"up" : function(e) {
								this.inKeyMode = true;
								this.selectPrev();
							},
							"down" : function(e) {
								if (!this.isExpanded()) {
									this.onTriggerClick();
								} else {
									this.inKeyMode = true;
									this.selectNext();
								}
							},
							"enter" : function(e) {
								this.onViewClick();
							},
							"esc" : function(e) {
								this.collapse();
							},
							"tab" : function(e) {
								this.onViewClick(false);
								return true;
							},
							scope : this,
							doRelay : function(foo, bar, _15) {
								if (_15 == "down" || this.scope.isExpanded()) {
									return Ext.KeyNav.prototype.doRelay.apply(
											this, arguments);
								}
								return true;
							}
						});
						this.queryDelay = Math.max(this.queryDelay || 10,
								this.mode == "local" ? 10 : 250);
						this.dqTask = new Ext.util.DelayedTask(this.initQuery,
								this);
						if (this.typeAhead) {
							this.taTask = new Ext.util.DelayedTask(
									this.onTypeAhead, this);
						}
						if (this.editable !== false) {
							this.el.on("keyup", this.onKeyUp, this);
						}
						if (this.forceSelection) {
							this.on("blur", this.doForce, this);
						}
					},
					onDestroy : function() {
						if (this.view) {
							this.view.setStore(null);
							this.view.el.removeAllListeners();
							this.view.el.remove();
							this.view.purgeListeners();
						}
						if (this.list) {
							this.list.destroy();
						}
						if (this.store) {
							this.store
									.un("beforeload", this.onBeforeLoad, this);
							this.store.un("load", this.onLoad, this);
							this.store.un("loadexception", this.collapse, this);
						}
						Ext.form.ComboBox.superclass.onDestroy.call(this);
					},
					fireKey : function(e) {
						if (e.isNavKeyPress() && !this.list.isVisible()) {
							this.fireEvent("specialkey", this, e);
						}
					},
					onResize : function(w, h) {
						if (this.list && this.listWidth === undefined) {
							this.list.setWidth(Math.max(w, this.minListWidth));
						}
					},
					setEditable : function(_19) {
						if (_19 == this.editable) {
							return;
						}
						this.editable = _19;
						if (!_19) {
							this.el.dom.setAttribute("readOnly", true);
							this.el.on("mousedown", this.onTriggerClick, this);
							this.el.addClass("x-combo-noedit");
						} else {
							this.el.dom.setAttribute("readOnly", false);
							this.el.un("mousedown", this.onTriggerClick, this);
							this.el.removeClass("x-combo-noedit");
						}
					},
					onBeforeLoad : function() {
						if (!this.hasFocus) {
							return;
						}
						this.innerList
								.update(this.loadingText ? "<div class=\"loading-indicator\">"
										+ this.loadingText + "</div>"
										: "");
						this.restrictHeight();
						this.selectedIndex = -1;
					},
					onLoad : function() {
						if (!this.hasFocus) {
							return;
						}
						if (this.store.getCount() > 0) {
							this.expand();
							this.restrictHeight();
							if (this.lastQuery == this.allQuery) {
								if (this.editable) {
									this.el.dom.select();
								}
								if (!this.selectByValue(this.value, true)) {
									this.select(0, true);
								}
							} else {
								this.selectNext();
								if (this.typeAhead
										&& this.lastKey != Ext.EventObject.BACKSPACE
										&& this.lastKey != Ext.EventObject.DELETE) {
									this.taTask.delay(this.typeAheadDelay);
								}
							}
						} else {
							this.onEmptyResults();
						}
					},
					onTypeAhead : function() {
						if (this.store.getCount() > 0) {
							var r = this.store.getAt(0);
							var _1b = r.data[this.displayField];
							var len = _1b.length;
							var _1d = this.getRawValue().length;
							if (_1d != len) {
								this.setRawValue(_1b);
								this.selectText(_1d, _1b.length);
							}
						}
					},
					onSelect : function(_1e, _1f) {
						if (this.fireEvent("beforeselect", this, _1e, _1f) !== false) {
							this.setValue(_1e.data[this.valueField
									|| this.displayField]);
							this.collapse();
							this.fireEvent("select", this, _1e, _1f);
						}
					},
					getValue : function() {
						if (this.valueField) {
							return typeof this.value != "undefined" ? this.value
									: "";
						} else {
							return Ext.form.ComboBox.superclass.getValue
									.call(this);
						}
					},
					clearValue : function() {
						if (this.hiddenField) {
							this.hiddenField.value = "";
						}
						this.setRawValue("");
						this.lastSelectionText = "";
					},
					setValue : function(v) {
						var _21 = v;
						if (this.valueField) {
							var r = this.findRecord(this.valueField, v);
							if (r) {
								_21 = r.data[this.displayField];
							} else {
								if (this.valueNotFoundText) {
									_21 = this.valueNotFoundText;
								}
							}
						}
						this.lastSelectionText = _21;
						if (this.hiddenField) {
							this.hiddenField.value = v;
						}
						Ext.form.ComboBox.superclass.setValue.call(this, _21);
						this.value = v;
					},
					findRecord : function(_23, _24) {
						var _25;
						if (this.store.getCount() > 0) {
							this.store.each(function(r) {
								if (r.data[_23] == _24) {
									_25 = r;
									return false;
								}
							});
						}
						return _25;
					},
					onViewMove : function(e, t) {
						this.inKeyMode = false;
					},
					onViewOver : function(e, t) {
						if (this.inKeyMode) {
							return;
						}
						var _2b = this.view.findItemFromChild(t);
						if (_2b) {
							var _2c = this.view.indexOf(_2b);
							this.select(_2c, false);
						}
					},
					onViewClick : function(_2d) {
						var _2e = this.view.getSelectedIndexes()[0];
						var r = this.store.getAt(_2e);
						if (r) {
							this.onSelect(r, _2e);
						}
						if (_2d !== false) {
							this.el.focus();
						}
					},
					restrictHeight : function() {
						this.innerList.dom.style.height = "";
						var _30 = this.innerList.dom;
						var h = Math.max(_30.clientHeight, _30.offsetHeight,
								_30.scrollHeight);
						this.innerList.setHeight(h < this.maxHeight ? "auto"
								: this.maxHeight);
						this.list.beginUpdate();
						this.list.setHeight(this.innerList.getHeight()
								+ this.list.getFrameWidth("tb")
								+ (this.resizable ? this.handleHeight : 0)
								+ this.assetHeight);
						this.list.alignTo(this.el, this.listAlign);
						this.list.endUpdate();
					},
					onEmptyResults : function() {
						this.collapse();
					},
					isExpanded : function() {
						return this.list.isVisible();
					},
					selectByValue : function(v, _33) {
						if (v !== undefined && v !== null) {
							var r = this.findRecord(this.valueField
									|| this.displayField, v);
							if (r) {
								this.select(this.store.indexOf(r), _33);
								return true;
							}
						}
						return false;
					},
					select : function(_35, _36) {
						this.selectedIndex = _35;
						this.view.select(_35);
						if (_36 !== false) {
							var el = this.view.getNode(_35);
							if (el) {
								this.innerList.scrollChildIntoView(el);
							}
						}
					},
					selectNext : function() {
						var ct = this.store.getCount();
						if (ct > 0) {
							if (this.selectedIndex == -1) {
								this.select(0);
							} else {
								if (this.selectedIndex < ct - 1) {
									this.select(this.selectedIndex + 1);
								}
							}
						}
					},
					selectPrev : function() {
						var ct = this.store.getCount();
						if (ct > 0) {
							if (this.selectedIndex == -1) {
								this.select(0);
							} else {
								if (this.selectedIndex != 0) {
									this.select(this.selectedIndex - 1);
								}
							}
						}
					},
					onKeyUp : function(e) {
						if (this.editable !== false && !e.isSpecialKey()) {
							this.lastKey = e.getKey();
							this.dqTask.delay(this.queryDelay);
						}
					},
					validateBlur : function() {
						return !this.list || !this.list.isVisible();
					},
					initQuery : function() {
						this.doQuery(this.getRawValue());
					},
					doForce : function() {
						if (this.el.dom.value.length > 0) {
							this.el.dom.value = this.lastSelectionText === undefined ? ""
									: this.lastSelectionText;
						}
					},
					doQuery : function(q, _3c) {
						if (q === undefined || q === null) {
							q = "";
						}
						var qe = {
							query : q,
							forceAll : _3c,
							combo : this,
							cancel : false
						};
						if (this.fireEvent("beforequery", qe) === false
								|| qe.cancel) {
							return false;
						}
						q = qe.query;
						_3c = qe.forceAll;
						if (_3c === true || (q.length >= this.minChars)) {
							if (this.lastQuery != q) {
								this.lastQuery = q;
								if (this.mode == "local") {
									this.selectedIndex = -1;
									if (_3c) {
										this.store.clearFilter();
									} else {
										this.store.filter(this.displayField, q);
									}
									this.onLoad();
								} else {
									this.store.baseParams[this.queryParam] = q;
									this.store.load( {
										params : this.getParams(q)
									});
									this.expand();
								}
							} else {
								this.selectedIndex = -1;
								this.onLoad();
							}
						}
					},
					getParams : function(q) {
						var p = {};
						if (this.pageSize) {
							p.start = 0;
							p.limit = this.pageSize;
						}
						return p;
					},
					collapse : function() {
						if (!this.isExpanded()) {
							return;
						}
						this.list.hide();
						Ext.get(document)
								.un("mousedown", this.collapseIf, this);
						this.fireEvent("collapse", this);
					},
					collapseIf : function(e) {
						if (!e.within(this.wrap) && !e.within(this.list)) {
							this.collapse();
						}
					},
					expand : function() {
						if (this.isExpanded()) {
							return;
						}
						this.list.alignTo(this.el, this.listAlign);
						this.list.show();
						Ext.get(document)
								.on("mousedown", this.collapseIf, this);
						this.fireEvent("expand", this);
					},
					onTriggerClick : function() {
						if (this.disabled) {
							return;
						}
						if (this.isExpanded()) {
							this.collapse();
							this.el.focus();
						} else {
							this.hasFocus = true;
							this.doQuery(this.triggerAction == "all" ? this
									.doQuery(this.allQuery, true) : this
									.doQuery(this.getRawValue()));
							this.el.focus();
						}
					}
				});

Ext.form.Checkbox = function(_1) {
	Ext.form.Checkbox.superclass.constructor.call(this, _1);
	this.addEvents( {
		check : true
	});
};
Ext.extend(Ext.form.Checkbox, Ext.form.Field, {
	focusClass : "x-form-check-focus",
	fieldClass : "x-form-field",
	checked : false,
	defaultAutoCreate : {
		tag : "input",
		type : "checkbox",
		autocomplete : "off"
	},
	boxLabel : undefined,
	setSize : function(w, h) {
		if (!this.wrap) {
			this.width = w;
			this.height = h;
			return;
		}
		this.wrap.setSize(w, h);
		if (!this.boxLabel) {
			this.el.alignTo(this.wrap, "c-c");
		}
	},
	initEvents : function() {
		Ext.form.Checkbox.superclass.initEvents.call(this);
		this.el.on("click", this.onClick, this);
		this.el.on("change", this.onClick, this);
	},
	onRender : function(ct) {
		Ext.form.Checkbox.superclass.onRender.call(this, ct);
		if (this.inputValue !== undefined) {
			this.el.dom.value = this.inputValue;
		}
		this.wrap = this.el.wrap( {
			cls : "x-form-check-wrap"
		});
		if (this.boxLabel) {
			this.wrap.createChild( {
				tag : "label",
				htmlFor : this.el.id,
				cls : "x-form-cb-label",
				html : this.boxLabel
			});
		}
		if (this.checked) {
			this.setValue(true);
		}
	},
	initValue : Ext.emptyFn,
	getValue : function() {
		if (this.rendered) {
			return this.el.dom.checked;
		}
		return false;
	},
	onClick : function() {
		if (this.el.dom.checked != this.checked) {
			this.setValue(this.el.dom.checked);
		}
	},
	setValue : function(v) {
		this.checked = (v === true || v === "true" || v == "1");
		if (this.el && this.el.dom) {
			this.el.dom.checked = this.checked;
		}
		this.fireEvent("check", this, this.checked);
	}
});

Ext.form.Radio = function() {
	Ext.form.Radio.superclass.constructor.apply(this, arguments);
};
Ext.extend(Ext.form.Radio, Ext.form.Checkbox, {
	inputType : "radio"
});

Ext.form.BasicForm = function(el, _2) {
	Ext.apply(this, _2);
	this.items = new Ext.util.MixedCollection(false, function(o) {
		return o.id || (o.id = Ext.id());
	});
	this.addEvents( {
		beforeaction : true,
		actionfailed : true,
		actioncomplete : true
	});
	if (el) {
		this.initEl(el);
	}
	Ext.form.BasicForm.superclass.constructor.call(this);
};
Ext.extend(Ext.form.BasicForm, Ext.util.Observable,
		{
			timeout : 30,
			activeAction : null,
			initEl : function(el) {
				this.el = Ext.get(el);
				this.id = this.el.id || Ext.id();
				this.el.on("submit", this.onSubmit, this);
				this.el.addClass("x-form");
			},
			onSubmit : function(e) {
				e.stopEvent();
			},
			isValid : function() {
				var _6 = true;
				this.items.each(function(f) {
					if (!f.validate()) {
						_6 = false;
					}
				});
				return _6;
			},
			doAction : function(_8, _9) {
				if (typeof _8 == "string") {
					_8 = new Ext.form.Action.ACTION_TYPES[_8](this, _9);
				}
				if (this.fireEvent("beforeaction", this, _8) !== false) {
					this.beforeAction(_8);
					_8.run.defer(100, _8);
				}
			},
			submit : function(_a) {
				this.doAction("submit", _a);
			},
			load : function(_b) {
				this.doAction("load", _b);
			},
			updateRecord : function(_c) {
				_c.beginEdit();
				var fs = _c.fields;
				fs.each(function(f) {
					var _f = this.fieldField(f.name);
					if (_f) {
						_c.set(f.name, _f.getValue());
					}
				}, this);
				_c.endEdit();
			},
			beforeAction : function(_10) {
				var o = _10.options;
				if (o.waitMsg) {
					Ext.MessageBox.wait(o.waitMsg, o.waitTitle
							|| this.waitTitle || "Please Wait...");
				}
			},
			afterAction : function(_12, _13) {
				this.activeAction = null;
				var o = _12.options;
				if (o.waitMsg) {
					Ext.MessageBox.updateProgress(1);
					Ext.MessageBox.hide();
				}
				if (_13) {
					if (o.reset) {
						this.reset();
					}
					Ext.callback(o.success, o.scope, [ this, _12 ]);
					this.fireEvent("actioncomplete", this, _12);
				} else {
					Ext.callback(o.failure, o.scope, [ this, _12 ]);
					this.fireEvent("actionfailed", this, _12);
				}
			},
			findField : function(id) {
				var _16 = this.items.get(id);
				if (!_16) {
					this.items.each(function(f) {
						if (f.isFormField
								&& (f.dataIndex == id || f.id == id || f
										.getName() == id)) {
							_16 = f;
							return false;
						}
					});
				}
				return _16 || null;
			},
			markInvalid : function(_18) {
				if (_18 instanceof Array) {
					for ( var i = 0, len = _18.length; i < len; i++) {
						var _1b = _18[i];
						var f = this.findField(_1b.id);
						if (f) {
							f.markInvalid(_1b.msg);
						}
					}
				} else {
					var _1d, id;
					for (id in _18) {
						if (typeof _18[id] != "function"
								&& (_1d = this.findField(id))) {
							_1d.markInvalid(_18[id]);
						}
					}
				}
			},
			setValues : function(_1f) {
				if (_1f instanceof Array) {
					for ( var i = 0, len = _1f.length; i < len; i++) {
						var v = _1f[i];
						var f = this.findField(v.id);
						if (f) {
							f.setValue(v.value);
						}
					}
				} else {
					var _24, id;
					for (id in _1f) {
						if (typeof _1f[id] != "function"
								&& (_24 = this.findField(id))) {
							_24.setValue(_1f[id]);
						}
					}
				}
			},
			getValues : function() {
				var fs = Ext.lib.Ajax.serializeForm(this.el.dom);
				return Ext.urlDecode(fs);
			},
			clearInvalid : function() {
				this.items.each(function(f) {
					f.clearInvalid();
				});
			},
			reset : function() {
				this.items.each(function(f) {
					f.reset();
				});
			},
			add : function() {
				this.items.addAll(Array.prototype.slice.call(arguments, 0));
			},
			remove : function(_29) {
				this.items.remove(_29);
			},
			render : function() {
				this.items.each(function(f) {
					if (f.isFormField && !f.rendered
							&& document.getElementById(f.id)) {
						f.applyTo(f.id);
					}
				});
			},
			applyToFields : function(o) {
				this.items.each(function(f) {
					Ext.apply(f, o);
				});
			},
			applyIfToFields : function(o) {
				this.items.each(function(f) {
					Ext.applyIf(f, o);
				});
			}
		});
Ext.BasicForm = Ext.form.BasicForm;

Ext.form.Form = function(_1) {
	Ext.form.Form.superclass.constructor.call(this, null, _1);
	this.url = this.url || this.action;
	if (!this.root) {
		this.root = new Ext.form.Layout(_1);
	}
	this.active = this.root;
	this.buttons = [];
};
Ext
		.extend(
				Ext.form.Form,
				Ext.form.BasicForm,
				{
					buttonPosition : "bottom",
					buttonAlign : "center",
					minButtonWidth : 75,
					labelAlign : "left",
					column : function(c) {
						var _3 = new Ext.form.Column(c);
						this.start(_3);
						if (arguments.length > 1) {
							this.add.apply(this, Array.prototype.slice.call(
									arguments, 1));
							this.end();
						}
						return _3;
					},
					fieldset : function(c) {
						var fs = new Ext.form.FieldSet(c);
						this.start(fs);
						if (arguments.length > 1) {
							this.add.apply(this, Array.prototype.slice.call(
									arguments, 1));
							this.end();
						}
						return fs;
					},
					container : function(c) {
						var l = new Ext.form.Layout(c);
						this.start(l);
						if (arguments.length > 1) {
							this.add.apply(this, Array.prototype.slice.call(
									arguments, 1));
							this.end();
						}
						return l;
					},
					start : function(c) {
						Ext.applyIf(c, {
							"labelAlign" : this.active.labelAlign,
							"labelWidth" : this.active.labelWidth,
							"itemCls" : this.active.itemCls
						});
						this.active.stack.push(c);
						c.ownerCt = this.active;
						this.active = c;
						return this;
					},
					end : function() {
						if (this.active == this.root) {
							return this;
						}
						this.active = this.active.ownerCt;
						return this;
					},
					add : function() {
						this.active.stack.push.apply(this.active.stack,
								arguments);
						var r = [];
						for ( var i = 0, a = arguments, _c = a.length; i < _c; i++) {
							if (a[i].isFormField) {
								r.push(a[i]);
							}
						}
						if (r.length > 0) {
							Ext.form.Form.superclass.add.apply(this, r);
						}
						return this;
					},
					render : function(ct) {
						ct = Ext.get(ct);
						var o = this.autoCreate || {
							tag : "form",
							method : this.method || "POST",
							id : this.id || Ext.id()
						};
						this.initEl(ct.createChild(o));
						this.root.render(this.el);
						this.items.each(function(f) {
							f.render("x-form-el-" + f.id);
						});
						if (this.buttons.length > 0) {
							var tb = this.el
									.createChild(
											{
												cls : "x-form-btns-ct",
												cn : {
													cls : "x-form-btns x-form-btns-"
															+ this.buttonAlign,
													html : "<table cellspacing=\"0\"><tbody><tr></tr></tbody></table><div class=\"x-clear\"></div>"
												}
											}, null, true);
							var tr = tb.getElementsByTagName("tr")[0];
							for ( var i = 0, len = this.buttons.length; i < len; i++) {
								var b = this.buttons[i];
								var td = document.createElement("td");
								td.className = "x-form-btn-td";
								b.render(tr.appendChild(td));
							}
						}
						return this;
					},
					addButton : function(_16, _17, _18) {
						var bc = {
							handler : _17,
							scope : _18,
							minWidth : this.minButtonWidth,
							hideParent : true
						};
						if (typeof _16 == "string") {
							bc.text = _16;
						} else {
							Ext.apply(bc, _16);
						}
						var btn = new Ext.Button(null, bc);
						this.buttons.push(btn);
						return btn;
					}
				});
Ext.Form = Ext.form.Form;

Ext.form.Action = function(_1, _2) {
	this.form = _1;
	this.options = _2 || {};
};
Ext.form.Action.CLIENT_INVALID = "client";
Ext.form.Action.SERVER_INVALID = "server";
Ext.form.Action.CONNECT_FAILURE = "connect";
Ext.form.Action.LOAD_FAILURE = "load";
Ext.form.Action.prototype = {
	type : "default",
	failureType : undefined,
	response : undefined,
	result : undefined,
	run : function(_3) {
	},
	success : function(_4) {
	},
	handleResponse : function(_5) {
	},
	failure : function(_6) {
		this.failureType = Ext.form.Action.CONNECT_FAILURE;
		this.form.afterAction(this, false);
	},
	processResponse : function(_7) {
		this.response = _7;
		if (!_7.responseText) {
			return true;
		}
		this.result = this.handleResponse(_7);
		return this.result;
	},
	getUrl : function(_8) {
		var _9 = this.options.url || this.form.url || this.form.el.dom.action;
		if (_8) {
			var p = this.getParams();
			if (p) {
				_9 += (_9.indexOf("?") != -1 ? "&" : "?") + p;
			}
		}
		return _9;
	},
	getMethod : function() {
		return (this.options.method || this.form.method
				|| this.form.el.dom.method || "POST").toUpperCase();
	},
	getParams : function() {
		var bp = this.form.baseParams;
		var p = this.options.params;
		if (p) {
			if (typeof p == "object") {
				p = Ext.urlEncode(Ext.applyIf(p, bp));
			} else {
				if (typeof p == "string" && bp) {
					p += "&" + Ext.urlEncode(bp);
				}
			}
		} else {
			if (bp) {
				p = Ext.urlEncode(bp);
			}
		}
		return p;
	},
	createCallback : function() {
		return {
			success : this.success,
			failure : this.failure,
			scope : this,
			timeout : (this.form.timeout * 1000),
			upload : this.form.fileUpload ? this.success : undefined
		};
	}
};
Ext.form.Action.Submit = function(_d, _e) {
	Ext.form.Action.Submit.superclass.constructor.call(this, _d, _e);
};
Ext.extend(Ext.form.Action.Submit, Ext.form.Action, {
	type : "submit",
	run : function() {
		var o = this.options;
		var _10 = this.getMethod() == "POST";
		if (o.clientValidation === false || this.form.isValid()) {
			Ext.lib.Ajax.formRequest(this.form.el.dom, this.getUrl(!_10), this
					.createCallback(), _10 ? this.getParams() : null,
					this.form.fileUpload, Ext.SSL_SECURE_URL);
		} else {
			if (o.clientValidation !== false) {
				this.failureType = Ext.form.Action.CLIENT_INVALID;
				this.form.afterAction(this, false);
			}
		}
	},
	success : function(_11) {
		var _12 = this.processResponse(_11);
		if (_12 === true || _12.success) {
			this.form.afterAction(this, true);
			return;
		}
		if (_12.errors) {
			this.form.markInvalid(_12.errors);
			this.failureType = Ext.form.Action.SERVER_INVALID;
			this.form.afterAction(this, false);
		}
	},
	handleResponse : function(_13) {
		if (this.form.errorReader) {
			var rs = this.form.errorReader.read(_13);
			var _15 = [];
			if (rs.records) {
				for ( var i = 0, len = rs.records.length; i < len; i++) {
					var r = rs.records[i];
					_15[i] = r.data;
				}
			}
			if (_15.length < 1) {
				_15 = null;
			}
			return {
				success : rs.success,
				errors : _15
			};
		}
		return Ext.decode(_13.responseText);
	}
});
Ext.form.Action.Load = function(_19, _1a) {
	Ext.form.Action.Load.superclass.constructor.call(this, _19, _1a);
	this.reader = this.form.reader;
};
Ext.extend(Ext.form.Action.Load, Ext.form.Action, {
	type : "load",
	run : function() {
		Ext.lib.Ajax.request(this.getMethod(), this.getUrl(false), this
				.createCallback(), this.getParams());
	},
	success : function(_1b) {
		var _1c = this.processResponse(_1b);
		if (_1c === true || !_1c.success || !_1c.data) {
			this.failureType = Ext.form.Action.LOAD_FAILURE;
			this.form.afterAction(this, false);
			return;
		}
		this.form.clearInvalid();
		this.form.setValues(_1c.data);
		this.form.afterAction(this, true);
	},
	handleResponse : function(_1d) {
		if (this.form.reader) {
			var rs = this.form.reader.read(_1d);
			var _1f = rs.records && rs.records[0] ? rs.records[0].data : null;
			return {
				success : rs.success,
				data : _1f
			};
		}
		return Ext.decode(_1d.responseText);
	}
});
Ext.form.Action.ACTION_TYPES = {
	"load" : Ext.form.Action.Load,
	"submit" : Ext.form.Action.Submit
};

Ext.form.Layout = function(_1) {
	Ext.form.Layout.superclass.constructor.call(this, _1);
	this.stack = [];
};
Ext
		.extend(
				Ext.form.Layout,
				Ext.Component,
				{
					clear : true,
					labelSeparator : ":",
					hideLabels : false,
					defaultAutoCreate : {
						tag : "div",
						cls : "x-form-ct"
					},
					onRender : function(ct) {
						if (this.el) {
							this.el = Ext.get(this.el);
						} else {
							var _3 = this.getAutoCreate();
							this.el = ct.createChild(_3);
						}
						if (this.style) {
							this.el.applyStyles(this.style);
						}
						if (this.labelAlign) {
							this.el.addClass("x-form-label-" + this.labelAlign);
						}
						if (this.hideLabels) {
							this.labelStyle = "display:none";
							this.elementStyle = "padding-left:0;";
						} else {
							if (typeof this.labelWidth == "number") {
								this.labelStyle = "width:" + this.labelWidth
										+ "px;";
								this.elementStyle = "padding-left:"
										+ ((this.labelWidth + (typeof this.labelPad == "number" ? this.labelPad
												: 5)) + "px") + ";";
							}
							if (this.labelAlign == "top") {
								this.labelStyle = "width:auto;";
								this.elementStyle = "padding-left:0;";
							}
						}
						var _4 = this.stack;
						var _5 = _4.length;
						if (_5 > 0) {
							if (!this.fieldTpl) {
								var t = new Ext.Template(
										"<div class=\"x-form-item {5}\">",
										"<label for=\"{0}\" style=\"{2}\">{1}{4}</label>",
										"<div class=\"x-form-element\" id=\"x-form-el-{0}\" style=\"{3}\">",
										"</div>",
										"</div><div class=\"x-form-clear-left\"></div>");
								t.disableFormats = true;
								t.compile();
								Ext.form.Layout.prototype.fieldTpl = t;
							}
							for ( var i = 0; i < _5; i++) {
								if (_4[i].isFormField) {
									this.renderField(_4[i]);
								} else {
									this.renderComponent(_4[i]);
								}
							}
						}
						if (this.clear) {
							this.el.createChild( {
								cls : "x-form-clear"
							});
						}
					},
					renderField : function(f) {
						this.fieldTpl.append(this.el, [ f.id, f.fieldLabel,
								f.labelStyle || this.labelStyle || "",
								this.elementStyle || "",
								f.labelSeparator || this.labelSeparator,
								f.itemCls || this.itemCls || "" ]);
					},
					renderComponent : function(c) {
						c.render(this.el);
					}
				});
Ext.form.Column = function(_a) {
	Ext.form.Column.superclass.constructor.call(this, _a);
};
Ext.extend(Ext.form.Column, Ext.form.Layout, {
	defaultAutoCreate : {
		tag : "div",
		cls : "x-form-ct x-form-column"
	},
	onRender : function(ct) {
		Ext.form.Column.superclass.onRender.call(this, ct);
		if (this.width) {
			this.el.setWidth(this.width);
		}
	}
});
Ext.form.FieldSet = function(_c) {
	Ext.form.FieldSet.superclass.constructor.call(this, _c);
};
Ext.extend(Ext.form.FieldSet, Ext.form.Layout, {
	defaultAutoCreate : {
		tag : "fieldset",
		cn : {
			tag : "legend"
		}
	},
	onRender : function(ct) {
		Ext.form.FieldSet.superclass.onRender.call(this, ct);
		if (this.legend) {
			this.setLegend(this.legend);
		}
	},
	setLegend : function(_e) {
		if (this.rendered) {
			this.el.child("legend").update(_e);
		}
	}
});

Ext.form.VTypes = function() {
	var _1 = /^[a-zA-Z_]+$/;
	var _2 = /^[a-zA-Z0-9_]+$/;
	var _3 = /^([\w]+)(.[\w]+)*@([\w]+)(.[\w]{2,4}){1,2}$/;
	var _4 = /(((https?)|(ftp)):\/\/([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i;
	return {
		"email" : function(v) {
			return _3.test(v);
		},
		"emailText" : "This field should be an e-mail address in the format \"user@domain.com\"",
		"emailMask" : /[a-z0-9_\.\-@]/i,
		"url" : function(v) {
			return _4.test(v);
		},
		"urlText" : "This field should be a URL in the format \"http:/"
				+ "/www.domain.com\"",
		"alpha" : function(v) {
			return _1.test(v);
		},
		"alphaText" : "This field should only contain letters and _",
		"alphaMask" : /[a-z_]/i,
		"alphanum" : function(v) {
			return _2.test(v);
		},
		"alphanumText" : "This field should only contain letters, numbers and _",
		"alphanumMask" : /[a-z0-9_]/i
	};
}();

Ext.LayoutManager = function(_1) {
	Ext.LayoutManager.superclass.constructor.call(this);
	this.el = Ext.get(_1);
	if (this.el.dom == document.body && Ext.isIE) {
		document.body.scroll = "no";
	} else {
		if (this.el.dom != document.body
				&& this.el.getStyle("position") == "static") {
			this.el.position("relative");
		}
	}
	this.id = this.el.id;
	this.el.addClass("x-layout-container");
	this.monitorWindowResize = true;
	this.regions = {};
	this.events = {
		"layout" : true,
		"regionresized" : true,
		"regioncollapsed" : true,
		"regionexpanded" : true
	};
	this.updating = false;
	Ext.EventManager.onWindowResize(this.onWindowResize, this, true);
};
Ext.extend(Ext.LayoutManager, Ext.util.Observable, {
	isUpdating : function() {
		return this.updating;
	},
	beginUpdate : function() {
		this.updating = true;
	},
	endUpdate : function(_2) {
		this.updating = false;
		if (!_2) {
			this.layout();
		}
	},
	layout : function() {
	},
	onRegionResized : function(_3, _4) {
		this.fireEvent("regionresized", _3, _4);
		this.layout();
	},
	onRegionCollapsed : function(_5) {
		this.fireEvent("regioncollapsed", _5);
	},
	onRegionExpanded : function(_6) {
		this.fireEvent("regionexpanded", _6);
	},
	getViewSize : function() {
		var _7;
		if (this.el.dom != document.body) {
			_7 = this.el.getSize();
		} else {
			_7 = {
				width : Ext.lib.Dom.getViewWidth(),
				height : Ext.lib.Dom.getViewHeight()
			};
		}
		_7.width -= this.el.getBorderWidth("lr") - this.el.getPadding("lr");
		_7.height -= this.el.getBorderWidth("tb") - this.el.getPadding("tb");
		return _7;
	},
	getEl : function() {
		return this.el;
	},
	getRegion : function(_8) {
		return this.regions[_8.toLowerCase()];
	},
	onWindowResize : function() {
		if (this.monitorWindowResize) {
			this.layout();
		}
	}
});

Ext.BorderLayout = function(_1, _2) {
	_2 = _2 || {};
	Ext.BorderLayout.superclass.constructor.call(this, _1);
	this.factory = _2.factory || Ext.BorderLayout.RegionFactory;
	for ( var i = 0, _4 = this.factory.validRegions.length; i < _4; i++) {
		var _5 = this.factory.validRegions[i];
		if (_2[_5]) {
			this.addRegion(_5, _2[_5]);
		}
	}
};
Ext
		.extend(
				Ext.BorderLayout,
				Ext.LayoutManager,
				{
					addRegion : function(_6, _7) {
						if (!this.regions[_6]) {
							var r = this.factory.create(_6, this, _7);
							this.regions[_6] = r;
							r.on("visibilitychange", this.layout, this);
							r.on("paneladded", this.layout, this);
							r.on("panelremoved", this.layout, this);
							r.on("invalidated", this.layout, this);
							r.on("resized", this.onRegionResized, this);
							r.on("collapsed", this.onRegionCollapsed, this);
							r.on("expanded", this.onRegionExpanded, this);
						}
						return this.regions[_6];
					},
					layout : function() {
						if (this.updating) {
							return;
						}
						var _9 = this.getViewSize();
						var w = _9.width, h = _9.height;
						var _c = w, _d = h, _e = 0, _f = 0;
						var rs = this.regions;
						var n = rs["north"], s = rs["south"], _13 = rs["west"], e = rs["east"], c = rs["center"];
						if (this.hideOnLayout) {
							c.el.setStyle("display", "none");
						}
						if (n && n.isVisible()) {
							var b = n.getBox();
							var m = n.getMargins();
							b.width = w - (m.left + m.right);
							b.x = m.left;
							b.y = m.top;
							_e = b.height + b.y + m.bottom;
							_d -= _e;
							n.updateBox(this.safeBox(b));
						}
						if (s && s.isVisible()) {
							var b = s.getBox();
							var m = s.getMargins();
							b.width = w - (m.left + m.right);
							b.x = m.left;
							var _18 = (b.height + m.top + m.bottom);
							b.y = h - _18 + m.top;
							_d -= _18;
							s.updateBox(this.safeBox(b));
						}
						if (_13 && _13.isVisible()) {
							var b = _13.getBox();
							var m = _13.getMargins();
							b.height = _d - (m.top + m.bottom);
							b.x = m.left;
							b.y = _e + m.top;
							var _19 = (b.width + m.left + m.right);
							_f += _19;
							_c -= _19;
							_13.updateBox(this.safeBox(b));
						}
						if (e && e.isVisible()) {
							var b = e.getBox();
							var m = e.getMargins();
							b.height = _d - (m.top + m.bottom);
							var _19 = (b.width + m.left + m.right);
							b.x = w - _19 + m.left;
							b.y = _e + m.top;
							_c -= _19;
							e.updateBox(this.safeBox(b));
						}
						if (c) {
							var m = c.getMargins();
							var _1a = {
								x : _f + m.left,
								y : _e + m.top,
								width : _c - (m.left + m.right),
								height : _d - (m.top + m.bottom)
							};
							if (this.hideOnLayout) {
								c.el.setStyle("display", "block");
							}
							c.updateBox(this.safeBox(_1a));
						}
						this.el.repaint();
						this.fireEvent("layout", this);
					},
					safeBox : function(box) {
						box.width = Math.max(0, box.width);
						box.height = Math.max(0, box.height);
						return box;
					},
					add : function(_1c, _1d) {
						_1c = _1c.toLowerCase();
						return this.regions[_1c].add(_1d);
					},
					remove : function(_1e, _1f) {
						_1e = _1e.toLowerCase();
						return this.regions[_1e].remove(_1f);
					},
					findPanel : function(_20) {
						var rs = this.regions;
						for ( var _22 in rs) {
							if (typeof rs[_22] != "function") {
								var p = rs[_22].getPanel(_20);
								if (p) {
									return p;
								}
							}
						}
						return null;
					},
					showPanel : function(_24) {
						var rs = this.regions;
						for ( var _26 in rs) {
							var r = rs[_26];
							if (typeof r != "function") {
								if (r.hasPanel(_24)) {
									return r.showPanel(_24);
								}
							}
						}
						return null;
					},
					restoreState : function(_28) {
						if (!_28) {
							_28 = Ext.state.Manager;
						}
						var sm = new Ext.LayoutStateManager();
						sm.init(this, _28);
					},
					batchAdd : function(_2a) {
						this.beginUpdate();
						for ( var _2b in _2a) {
							var lr = this.regions[_2b];
							if (lr) {
								this.addTypedPanels(lr, _2a[_2b]);
							}
						}
						this.endUpdate();
					},
					addTypedPanels : function(lr, ps) {
						if (typeof ps == "string") {
							lr.add(new Ext.ContentPanel(ps));
						} else {
							if (ps instanceof Array) {
								for ( var i = 0, len = ps.length; i < len; i++) {
									this.addTypedPanels(lr, ps[i]);
								}
							} else {
								if (!ps.events) {
									var el = ps.el;
									delete ps.el;
									lr.add(new Ext.ContentPanel(el || Ext.id(),
											ps));
								} else {
									lr.add(ps);
								}
							}
						}
					}
				});
Ext.BorderLayout.create = function(_32, _33) {
	var _34 = new Ext.BorderLayout(_33 || document.body, _32);
	_34.beginUpdate();
	var _35 = Ext.BorderLayout.RegionFactory.validRegions;
	for ( var j = 0, _37 = _35.length; j < _37; j++) {
		var lr = _35[j];
		if (_34.regions[lr] && _32[lr].panels) {
			var r = _34.regions[lr];
			var ps = _32[lr].panels;
			_34.addTypedPanels(r, ps);
		}
	}
	_34.endUpdate();
	return _34;
};
Ext.BorderLayout.RegionFactory = {
	validRegions : [ "north", "south", "east", "west", "center" ],
	create : function(_3b, mgr, _3d) {
		_3b = _3b.toLowerCase();
		if (_3d.lightweight || _3d.basic) {
			return new Ext.BasicLayoutRegion(mgr, _3d, _3b);
		}
		switch (_3b) {
		case "north":
			return new Ext.NorthLayoutRegion(mgr, _3d);
		case "south":
			return new Ext.SouthLayoutRegion(mgr, _3d);
		case "east":
			return new Ext.EastLayoutRegion(mgr, _3d);
		case "west":
			return new Ext.WestLayoutRegion(mgr, _3d);
		case "center":
			return new Ext.CenterLayoutRegion(mgr, _3d);
		}
		throw "Layout region \"" + _3b + "\" not supported.";
	}
};

Ext.BasicLayoutRegion = function(_1, _2, _3, _4) {
	this.mgr = _1;
	this.position = _3;
	this.events = {
		"beforeremove" : true,
		"invalidated" : true,
		"visibilitychange" : true,
		"paneladded" : true,
		"panelremoved" : true,
		"collapsed" : true,
		"expanded" : true,
		"slideshow" : true,
		"slidehide" : true,
		"panelactivated" : true,
		"resized" : true
	};
	this.panels = new Ext.util.MixedCollection();
	this.panels.getKey = this.getPanelId.createDelegate(this);
	this.box = null;
	this.activePanel = null;
	if (_4 !== true) {
		this.applyConfig(_2);
	}
};
Ext.extend(Ext.BasicLayoutRegion, Ext.util.Observable, {
	getPanelId : function(p) {
		return p.getId();
	},
	applyConfig : function(_6) {
		this.margins = _6.margins || this.margins || {
			top : 0,
			left : 0,
			right : 0,
			bottom : 0
		};
		this.config = _6;
	},
	resizeTo : function(_7) {
		var el = this.el ? this.el : (this.activePanel ? this.activePanel
				.getEl() : null);
		if (el) {
			switch (this.position) {
			case "east":
			case "west":
				el.setWidth(_7);
				this.fireEvent("resized", this, _7);
				break;
			case "north":
			case "south":
				el.setHeight(_7);
				this.fireEvent("resized", this, _7);
				break;
			}
		}
	},
	getBox : function() {
		return this.activePanel ? this.activePanel.getEl().getBox(false, true)
				: null;
	},
	getMargins : function() {
		return this.margins;
	},
	updateBox : function(_9) {
		this.box = _9;
		var el = this.activePanel.getEl();
		el.dom.style.left = _9.x + "px";
		el.dom.style.top = _9.y + "px";
		el.setSize(_9.width, _9.height);
	},
	getEl : function() {
		return this.activePanel;
	},
	isVisible : function() {
		return this.activePanel ? true : false;
	},
	setActivePanel : function(_b) {
		_b = this.getPanel(_b);
		if (this.activePanel && this.activePanel != _b) {
			this.activePanel.setActiveState(false);
			this.activePanel.getEl().setStyle( {
				left : -10000,
				right : -10000
			});
		}
		this.activePanel = _b;
		_b.setActiveState(true);
		if (this.box) {
			_b.setSize(this.box.width, this.box.height);
		}
		this.fireEvent("panelactivated", this, _b);
		this.fireEvent("invalidated");
	},
	showPanel : function(_c) {
		if (_c = this.getPanel(_c)) {
			this.setActivePanel(_c);
		}
		return _c;
	},
	getActivePanel : function() {
		return this.activePanel;
	},
	add : function(_d) {
		if (arguments.length > 1) {
			for ( var i = 0, _f = arguments.length; i < _f; i++) {
				this.add(arguments[i]);
			}
			return null;
		}
		if (this.hasPanel(_d)) {
			this.showPanel(_d);
			return _d;
		}
		var el = _d.getEl();
		if (el.dom.parentNode != this.mgr.el.dom) {
			this.mgr.el.dom.appendChild(el.dom);
		}
		_d.setRegion(this);
		this.panels.add(_d);
		el.setStyle("position", "absolute");
		if (!_d.background) {
			this.setActivePanel(_d);
			if (this.config.initialSize && this.panels.getCount() == 1) {
				this.resizeTo(this.config.initialSize);
			}
		}
		this.fireEvent("paneladded", this, _d);
		return _d;
	},
	hasPanel : function(_11) {
		if (typeof _11 == "object") {
			_11 = _11.getId();
		}
		return this.getPanel(_11) ? true : false;
	},
	remove : function(_12, _13) {
		_12 = this.getPanel(_12);
		if (!_12) {
			return null;
		}
		var e = {};
		this.fireEvent("beforeremove", this, _12, e);
		if (e.cancel === true) {
			return null;
		}
		var _15 = _12.getId();
		this.panels.removeKey(_15);
		return _12;
	},
	getPanel : function(id) {
		if (typeof id == "object") {
			return id;
		}
		return this.panels.get(id);
	},
	getPosition : function() {
		return this.position;
	}
});

Ext.LayoutRegion = function(_1, _2, _3) {
	Ext.LayoutRegion.superclass.constructor.call(this, _1, _2, _3, true);
	var dh = Ext.DomHelper;
	this.el = dh.append(_1.el.dom, {
		tag : "div",
		cls : "x-layout-panel x-layout-panel-" + this.position
	}, true);
	this.titleEl = dh.append(this.el.dom, {
		tag : "div",
		unselectable : "on",
		cls : "x-unselectable x-layout-panel-hd x-layout-title-"
				+ this.position,
		children : [ {
			tag : "span",
			cls : "x-unselectable x-layout-panel-hd-text",
			unselectable : "on",
			html : "&#160;"
		}, {
			tag : "div",
			cls : "x-unselectable x-layout-panel-hd-tools",
			unselectable : "on"
		} ]
	}, true);
	this.titleEl.enableDisplayMode();
	this.titleTextEl = this.titleEl.dom.firstChild;
	this.tools = Ext.get(this.titleEl.dom.childNodes[1], true);
	this.closeBtn = this.createTool(this.tools.dom, "x-layout-close");
	this.closeBtn.enableDisplayMode();
	this.closeBtn.on("click", this.closeClicked, this);
	this.closeBtn.hide();
	this.bodyEl = dh.append(this.el.dom, {
		tag : "div",
		cls : "x-layout-panel-body"
	}, true);
	this.visible = true;
	this.collapsed = false;
	if (_2.hideWhenEmpty) {
		this.hide();
		this.on("paneladded", this.validateVisibility, this);
		this.on("panelremoved", this.validateVisibility, this);
	}
	this.applyConfig(_2);
};
Ext
		.extend(
				Ext.LayoutRegion,
				Ext.BasicLayoutRegion,
				{
					applyConfig : function(c) {
						if (c.collapsible && this.position != "center"
								&& !this.collapsedEl) {
							var dh = Ext.DomHelper;
							this.collapseBtn = this.createTool(this.tools.dom,
									"x-layout-collapse-" + this.position);
							this.collapseBtn.on("click", this.collapse, this);
							this.collapseBtn.enableDisplayMode();
							this.collapsedEl = dh.append(this.mgr.el.dom, {
								cls : "x-layout-collapsed x-layout-collapsed-"
										+ this.position,
								children : [ {
									cls : "x-layout-collapsed-tools",
									children : [ {
										cls : "x-layout-ctools-inner"
									} ]
								} ]
							}, true);
							if (c.floatable !== false) {
								this.collapsedEl
										.addClassOnOver("x-layout-collapsed-over");
								this.collapsedEl.on("click",
										this.collapseClick, this);
							}
							if (c.showPin === true || this.showPin == true) {
								this.stickBtn = this.createTool(this.tools.dom,
										"x-layout-stick");
								this.stickBtn.enableDisplayMode();
								this.stickBtn.on("click", this.expand, this);
								this.stickBtn.hide();
							}
							if (c.collapsedTitle
									&& (this.position == "north" || this.position == "south")) {
								this.collapsedTitleTextEl = dh
										.append(
												this.collapsedEl.dom,
												{
													tag : "div",
													cls : "x-unselectable x-layout-panel-hd-text",
													id : "message",
													unselectable : "on",
													style : {
														"float" : "left"
													}
												});
								this.collapsedTitleTextEl.innerHTML = c.collapsedTitle;
							}
							this.expandBtn = this.createTool(
									this.collapsedEl.dom.firstChild.firstChild,
									"x-layout-expand-" + this.position);
							this.expandBtn.on("click", this.expand, this);
						}
						if (this.collapseBtn) {
							this.collapseBtn.setVisible(c.collapsible == true);
						}
						this.cmargins = c.cmargins
								|| this.cmargins
								|| (this.position == "west"
										|| this.position == "east" ? {
									top : 0,
									left : 2,
									right : 2,
									bottom : 0
								} : {
									top : 2,
									left : 0,
									right : 0,
									bottom : 2
								});
						this.margins = c.margins || this.margins || {
							top : 0,
							left : 0,
							right : 0,
							bottom : 0
						};
						this.bottomTabs = c.tabPosition != "top";
						this.autoScroll = c.autoScroll || false;
						if (this.autoScroll) {
							this.bodyEl.setStyle("overflow", "auto");
						} else {
							this.bodyEl.setStyle("overflow", "hidden");
						}
						if ((!c.titlebar && !c.title) || c.titlebar === false) {
							this.titleEl.hide();
						} else {
							this.titleEl.show();
							if (c.title) {
								this.titleTextEl.innerHTML = c.title;
							}
						}
						this.duration = c.duration || 0.3;
						this.slideDuration = c.slideDuration || 0.45;
						this.config = c;
						if (c.collapsed) {
							this.collapse(true);
						}
						if (c.hidden) {
							this.hide();
						}
					},
					isVisible : function() {
						return this.visible;
					},
					setCollapsedTitle : function(_7) {
						_7 = _7 || "&#160;";
						if (this.collapsedTitleTextEl) {
							this.collapsedTitleTextEl.innerHTML = _7;
						}
					},
					getBox : function() {
						var b;
						if (!this.collapsed) {
							b = this.el.getBox(false, true);
						} else {
							b = this.collapsedEl.getBox(false, true);
						}
						return b;
					},
					getMargins : function() {
						return this.collapsed ? this.cmargins : this.margins;
					},
					highlight : function() {
						this.el.addClass("x-layout-panel-dragover");
					},
					unhighlight : function() {
						this.el.removeClass("x-layout-panel-dragover");
					},
					updateBox : function(_9) {
						this.box = _9;
						if (!this.collapsed) {
							this.el.dom.style.left = _9.x + "px";
							this.el.dom.style.top = _9.y + "px";
							this.updateBody(_9.width, _9.height);
						} else {
							this.collapsedEl.dom.style.left = _9.x + "px";
							this.collapsedEl.dom.style.top = _9.y + "px";
							this.collapsedEl.setSize(_9.width, _9.height);
						}
						if (this.tabs) {
							this.tabs.autoSizeTabs();
						}
					},
					updateBody : function(w, h) {
						if (w !== null) {
							this.el.setWidth(w);
							w -= this.el.getBorderWidth("rl");
						}
						if (h !== null) {
							this.el.setHeight(h);
							h = this.titleEl.isDisplayed() ? h
									- (this.titleEl.getHeight() || 0) : h;
							h -= this.el.getBorderWidth("tb");
							this.bodyEl.setHeight(h);
							if (this.tabs) {
								h = this.tabs.syncHeight(h);
							}
						}
						if (this.panelSize) {
							w = w !== null ? w : this.panelSize.width;
							h = h !== null ? h : this.panelSize.height;
						}
						if (this.activePanel) {
							var el = this.activePanel.getEl();
							w = w !== null ? w : el.getWidth();
							h = h !== null ? h : el.getHeight();
							this.panelSize = {
								width : w,
								height : h
							};
							this.activePanel.setSize(w, h);
						}
						if (Ext.isIE && this.tabs) {
							this.tabs.el.repaint();
						}
					},
					getEl : function() {
						return this.el;
					},
					hide : function() {
						if (!this.collapsed) {
							this.el.dom.style.left = "-2000px";
							this.el.hide();
						} else {
							this.collapsedEl.dom.style.left = "-2000px";
							this.collapsedEl.hide();
						}
						this.visible = false;
						this.fireEvent("visibilitychange", this, false);
					},
					show : function() {
						if (!this.collapsed) {
							this.el.show();
						} else {
							this.collapsedEl.show();
						}
						this.visible = true;
						this.fireEvent("visibilitychange", this, true);
					},
					closeClicked : function() {
						if (this.activePanel) {
							this.remove(this.activePanel);
						}
					},
					collapseClick : function(e) {
						if (this.isSlid) {
							e.stopPropagation();
							this.slideIn();
						} else {
							e.stopPropagation();
							this.slideOut();
						}
					},
					collapse : function(_e) {
						if (this.collapsed) {
							return;
						}
						this.collapsed = true;
						if (this.split) {
							this.split.el.hide();
						}
						if (this.config.animate && _e !== true) {
							this.fireEvent("invalidated", this);
							this.animateCollapse();
						} else {
							this.el.setLocation(-20000, -20000);
							this.el.hide();
							this.collapsedEl.show();
							this.fireEvent("collapsed", this);
							this.fireEvent("invalidated", this);
						}
					},
					animateCollapse : function() {
					},
					expand : function(e, _10) {
						if (e) {
							e.stopPropagation();
						}
						if (!this.collapsed || this.el.hasActiveFx()) {
							return;
						}
						if (this.isSlid) {
							this.afterSlideIn();
							_10 = true;
						}
						this.collapsed = false;
						if (this.config.animate && _10 !== true) {
							this.animateExpand();
						} else {
							this.el.show();
							if (this.split) {
								this.split.el.show();
							}
							this.collapsedEl.setLocation(-2000, -2000);
							this.collapsedEl.hide();
							this.fireEvent("invalidated", this);
							this.fireEvent("expanded", this);
						}
					},
					animateExpand : function() {
					},
					initTabs : function() {
						this.bodyEl.setStyle("overflow", "hidden");
						var ts = new Ext.TabPanel(this.bodyEl.dom, {
							tabPosition : this.bottomTabs ? "bottom" : "top",
							disableTooltips : this.config.disableTabTips
						});
						if (this.config.hideTabs) {
							ts.stripWrap.setDisplayed(false);
						}
						this.tabs = ts;
						ts.resizeTabs = this.config.resizeTabs === true;
						ts.minTabWidth = this.config.minTabWidth || 40;
						ts.maxTabWidth = this.config.maxTabWidth || 250;
						ts.preferredTabWidth = this.config.preferredTabWidth || 150;
						ts.monitorResize = false;
						ts.bodyEl.setStyle("overflow",
								this.config.autoScroll ? "auto" : "hidden");
						ts.bodyEl.addClass("x-layout-tabs-body");
						this.panels.each(this.initPanelAsTab, this);
					},
					initPanelAsTab : function(_12) {
						var ti = this.tabs.addTab(_12.getEl().id, _12
								.getTitle(), null, this.config.closeOnTab
								&& _12.isClosable());
						if (_12.tabTip !== undefined) {
							ti.setTooltip(_12.tabTip);
						}
						ti.on("activate", function() {
							this.setActivePanel(_12);
						}, this);
						if (this.config.closeOnTab) {
							ti.on("beforeclose", function(t, e) {
								e.cancel = true;
								this.remove(_12);
							}, this);
						}
						return ti;
					},
					updatePanelTitle : function(_16, _17) {
						if (this.activePanel == _16) {
							this.updateTitle(_17);
						}
						if (this.tabs) {
							var ti = this.tabs.getTab(_16.getEl().id);
							ti.setText(_17);
							if (_16.tabTip !== undefined) {
								ti.setTooltip(_16.tabTip);
							}
						}
					},
					updateTitle : function(_19) {
						if (this.titleTextEl && !this.config.title) {
							this.titleTextEl.innerHTML = (typeof _19 != "undefined"
									&& _19.length > 0 ? _19 : "&#160;");
						}
					},
					setActivePanel : function(_1a) {
						_1a = this.getPanel(_1a);
						if (this.activePanel && this.activePanel != _1a) {
							this.activePanel.setActiveState(false);
						}
						this.activePanel = _1a;
						_1a.setActiveState(true);
						if (this.panelSize) {
							_1a.setSize(this.panelSize.width,
									this.panelSize.height);
						}
						this.closeBtn.setVisible(!this.config.closeOnTab
								&& !this.isSlid && _1a.isClosable());
						this.updateTitle(_1a.getTitle());
						if (this.tabs) {
							this.fireEvent("invalidated", this);
						}
						this.fireEvent("panelactivated", this, _1a);
					},
					showPanel : function(_1b) {
						if (_1b = this.getPanel(_1b)) {
							if (this.tabs) {
								var tab = this.tabs.getTab(_1b.getEl().id);
								if (tab.isHidden()) {
									this.tabs.unhideTab(tab.id);
								}
								tab.activate();
							} else {
								this.setActivePanel(_1b);
							}
						}
						return _1b;
					},
					getActivePanel : function() {
						return this.activePanel;
					},
					validateVisibility : function() {
						if (this.panels.getCount() < 1) {
							this.updateTitle("&#160;");
							this.closeBtn.hide();
							this.hide();
						} else {
							if (!this.isVisible()) {
								this.show();
							}
						}
					},
					add : function(_1d) {
						if (arguments.length > 1) {
							for ( var i = 0, len = arguments.length; i < len; i++) {
								this.add(arguments[i]);
							}
							return null;
						}
						if (this.hasPanel(_1d)) {
							this.showPanel(_1d);
							return _1d;
						}
						_1d.setRegion(this);
						this.panels.add(_1d);
						if (this.panels.getCount() == 1
								&& !this.config.alwaysShowTabs) {
							this.bodyEl.dom.appendChild(_1d.getEl().dom);
							if (_1d.background !== true) {
								this.setActivePanel(_1d);
							}
							this.fireEvent("paneladded", this, _1d);
							return _1d;
						}
						if (!this.tabs) {
							this.initTabs();
						} else {
							this.initPanelAsTab(_1d);
						}
						if (_1d.background !== true) {
							this.tabs.activate(_1d.getEl().id);
						}
						this.fireEvent("paneladded", this, _1d);
						return _1d;
					},
					hidePanel : function(_20) {
						if (this.tabs && (_20 = this.getPanel(_20))) {
							this.tabs.hideTab(_20.getEl().id);
						}
					},
					unhidePanel : function(_21) {
						if (this.tabs && (_21 = this.getPanel(_21))) {
							this.tabs.unhideTab(_21.getEl().id);
						}
					},
					clearPanels : function() {
						while (this.panels.getCount() > 0) {
							this.remove(this.panels.first());
						}
					},
					remove : function(_22, _23) {
						_22 = this.getPanel(_22);
						if (!_22) {
							return null;
						}
						var e = {};
						this.fireEvent("beforeremove", this, _22, e);
						if (e.cancel === true) {
							return null;
						}
						_23 = (typeof _23 != "undefined" ? _23
								: (this.config.preservePanels === true || _22.preserve === true));
						var _25 = _22.getId();
						this.panels.removeKey(_25);
						if (_23) {
							document.body.appendChild(_22.getEl().dom);
						}
						if (this.tabs) {
							this.tabs.removeTab(_22.getEl().id);
						} else {
							if (!_23) {
								this.bodyEl.dom.removeChild(_22.getEl().dom);
							}
						}
						if (this.panels.getCount() == 1 && this.tabs
								&& !this.config.alwaysShowTabs) {
							var p = this.panels.first();
							var _27 = document.createElement("div");
							_27.appendChild(p.getEl().dom);
							this.bodyEl.update("");
							this.bodyEl.dom.appendChild(p.getEl().dom);
							_27 = null;
							this.updateTitle(p.getTitle());
							this.tabs = null;
							this.bodyEl.setStyle("overflow",
									this.config.autoScroll ? "auto" : "hidden");
							this.setActivePanel(p);
						}
						_22.setRegion(null);
						if (this.activePanel == _22) {
							this.activePanel = null;
						}
						if (this.config.autoDestroy !== false && _23 !== true) {
							try {
								_22.destroy();
							} catch (e) {
							}
						}
						this.fireEvent("panelremoved", this, _22);
						return _22;
					},
					getTabs : function() {
						return this.tabs;
					},
					createTool : function(_28, _29) {
						var btn = Ext.DomHelper.append(_28, {
							tag : "div",
							cls : "x-layout-tools-button",
							children : [ {
								tag : "div",
								cls : "x-layout-tools-button-inner " + _29,
								html : "&#160;"
							} ]
						}, true);
						btn.addClassOnOver("x-layout-tools-button-over");
						return btn;
					}
				});

Ext.SplitLayoutRegion = function(_1, _2, _3, _4) {
	this.cursor = _4;
	Ext.SplitLayoutRegion.superclass.constructor.call(this, _1, _2, _3);
};
Ext
		.extend(
				Ext.SplitLayoutRegion,
				Ext.LayoutRegion,
				{
					splitTip : "Drag to resize.",
					collapsibleSplitTip : "Drag to resize. Double click to hide.",
					useSplitTips : false,
					applyConfig : function(_5) {
						Ext.SplitLayoutRegion.superclass.applyConfig.call(this,
								_5);
						if (_5.split) {
							if (!this.split) {
								var _6 = Ext.DomHelper
										.append(
												this.mgr.el.dom,
												{
													tag : "div",
													id : this.el.id + "-split",
													cls : "x-layout-split x-layout-split-"
															+ this.position,
													html : "&#160;"
												});
								this.split = new Ext.SplitBar(_6, this.el,
										this.orientation);
								this.split.on("moved", this.onSplitMove, this);
								this.split.useShim = _5.useShim === true;
								this.split.getMaximumSize = this[this.position == "north"
										|| this.position == "south" ? "getVMaxSize"
										: "getHMaxSize"].createDelegate(this);
								if (this.useSplitTips) {
									this.split.el.dom.title = _5.collapsible ? this.collapsibleSplitTip
											: this.splitTip;
								}
								if (_5.collapsible) {
									this.split.el.on("dblclick", this.collapse,
											this);
								}
							}
							if (typeof _5.minSize != "undefined") {
								this.split.minSize = _5.minSize;
							}
							if (typeof _5.maxSize != "undefined") {
								this.split.maxSize = _5.maxSize;
							}
							if (_5.hideWhenEmpty || _5.hidden) {
								this.hideSplitter();
							}
						}
					},
					getHMaxSize : function() {
						var _7 = this.config.maxSize || 10000;
						var _8 = this.mgr.getRegion("center");
						return Math.min(_7, (this.el.getWidth() + _8.getEl()
								.getWidth())
								- _8.getMinWidth());
					},
					getVMaxSize : function() {
						var _9 = this.config.maxSize || 10000;
						var _a = this.mgr.getRegion("center");
						return Math.min(_9, (this.el.getHeight() + _a.getEl()
								.getHeight())
								- _a.getMinHeight());
					},
					onSplitMove : function(_b, _c) {
						this.fireEvent("resized", this, _c);
					},
					getSplitBar : function() {
						return this.split;
					},
					hide : function() {
						this.hideSplitter();
						Ext.SplitLayoutRegion.superclass.hide.call(this);
					},
					hideSplitter : function() {
						if (this.split) {
							this.split.el.setLocation(-2000, -2000);
							this.split.el.hide();
						}
					},
					show : function() {
						if (this.split) {
							this.split.el.show();
						}
						Ext.SplitLayoutRegion.superclass.show.call(this);
					},
					beforeSlide : function() {
						if (Ext.isGecko) {
							this.bodyEl.clip();
							if (this.tabs) {
								this.tabs.bodyEl.clip();
							}
							if (this.activePanel) {
								this.activePanel.getEl().clip();
								if (this.activePanel.beforeSlide) {
									this.activePanel.beforeSlide();
								}
							}
						}
					},
					afterSlide : function() {
						if (Ext.isGecko) {
							this.bodyEl.unclip();
							if (this.tabs) {
								this.tabs.bodyEl.unclip();
							}
							if (this.activePanel) {
								this.activePanel.getEl().unclip();
								if (this.activePanel.afterSlide) {
									this.activePanel.afterSlide();
								}
							}
						}
					},
					initAutoHide : function() {
						if (this.autoHide !== false) {
							if (!this.autoHideHd) {
								var st = new Ext.util.DelayedTask(this.slideIn,
										this);
								this.autoHideHd = {
									"mouseout" : function(e) {
										if (!e.within(this.el, true)) {
											st.delay(500);
										}
									},
									"mouseover" : function(e) {
										st.cancel();
									},
									scope : this
								};
							}
							this.el.on(this.autoHideHd);
						}
					},
					clearAutoHide : function() {
						if (this.autoHide !== false) {
							this.el.un("mouseout", this.autoHideHd.mouseout);
							this.el.un("mouseover", this.autoHideHd.mouseover);
						}
					},
					clearMonitor : function() {
						Ext.get(document).un("click", this.slideInIf, this);
					},
					slideOut : function() {
						if (this.isSlid || this.el.hasActiveFx()) {
							return;
						}
						this.isSlid = true;
						if (this.collapseBtn) {
							this.collapseBtn.hide();
						}
						this.closeBtnState = this.closeBtn.getStyle("display");
						this.closeBtn.hide();
						if (this.stickBtn) {
							this.stickBtn.show();
						}
						this.el.show();
						this.el.alignTo(this.collapsedEl, this
								.getCollapseAnchor());
						this.beforeSlide();
						this.el.setStyle("z-index", 20000);
						this.el.slideIn(this.getSlideAnchor(), {
							callback : function() {
								this.afterSlide();
								this.initAutoHide();
								Ext.get(document).on("click", this.slideInIf,
										this);
								this.fireEvent("slideshow", this);
							},
							scope : this,
							block : true
						});
					},
					afterSlideIn : function() {
						this.clearAutoHide();
						this.isSlid = false;
						this.clearMonitor();
						this.el.setStyle("z-index", "");
						if (this.collapseBtn) {
							this.collapseBtn.show();
						}
						this.closeBtn.setStyle("display", this.closeBtnState);
						if (this.stickBtn) {
							this.stickBtn.hide();
						}
						this.fireEvent("slidehide", this);
					},
					slideIn : function(cb) {
						if (!this.isSlid || this.el.hasActiveFx()) {
							Ext.callback(cb);
							return;
						}
						this.isSlid = false;
						this.beforeSlide();
						this.el.slideOut(this.getSlideAnchor(), {
							callback : function() {
								this.el.setLeftTop(-10000, -10000);
								this.afterSlide();
								this.afterSlideIn();
								Ext.callback(cb);
							},
							scope : this,
							block : true
						});
					},
					slideInIf : function(e) {
						if (!e.within(this.el)) {
							this.slideIn();
						}
					},
					animateCollapse : function() {
						this.beforeSlide();
						this.el.setStyle("z-index", 20000);
						var _12 = this.getSlideAnchor();
						this.el.slideOut(_12, {
							callback : function() {
								this.el.setStyle("z-index", "");
								this.collapsedEl.slideIn(_12, {
									duration : 0.3
								});
								this.afterSlide();
								this.el.setLocation(-10000, -10000);
								this.el.hide();
								this.fireEvent("collapsed", this);
							},
							scope : this,
							block : true
						});
					},
					animateExpand : function() {
						this.beforeSlide();
						this.el.alignTo(this.collapsedEl, this
								.getCollapseAnchor(), this.getExpandAdj());
						this.el.setStyle("z-index", 20000);
						this.collapsedEl.hide( {
							duration : 0.1
						});
						this.el.slideIn(this.getSlideAnchor(), {
							callback : function() {
								this.el.setStyle("z-index", "");
								this.afterSlide();
								if (this.split) {
									this.split.el.show();
								}
								this.fireEvent("invalidated", this);
								this.fireEvent("expanded", this);
							},
							scope : this,
							block : true
						});
					},
					anchors : {
						"west" : "left",
						"east" : "right",
						"north" : "top",
						"south" : "bottom"
					},
					sanchors : {
						"west" : "l",
						"east" : "r",
						"north" : "t",
						"south" : "b"
					},
					canchors : {
						"west" : "tl-tr",
						"east" : "tr-tl",
						"north" : "tl-bl",
						"south" : "bl-tl"
					},
					getAnchor : function() {
						return this.anchors[this.position];
					},
					getCollapseAnchor : function() {
						return this.canchors[this.position];
					},
					getSlideAnchor : function() {
						return this.sanchors[this.position];
					},
					getAlignAdj : function() {
						var cm = this.cmargins;
						switch (this.position) {
						case "west":
							return [ 0, 0 ];
							break;
						case "east":
							return [ 0, 0 ];
							break;
						case "north":
							return [ 0, 0 ];
							break;
						case "south":
							return [ 0, 0 ];
							break;
						}
					},
					getExpandAdj : function() {
						var c = this.collapsedEl, cm = this.cmargins;
						switch (this.position) {
						case "west":
							return [ -(cm.right + c.getWidth() + cm.left), 0 ];
							break;
						case "east":
							return [ cm.right + c.getWidth() + cm.left, 0 ];
							break;
						case "north":
							return [ 0, -(cm.top + cm.bottom + c.getHeight()) ];
							break;
						case "south":
							return [ 0, cm.top + cm.bottom + c.getHeight() ];
							break;
						}
					}
				});

Ext.CenterLayoutRegion = function(_1, _2) {
	Ext.CenterLayoutRegion.superclass.constructor.call(this, _1, _2, "center");
	this.visible = true;
	this.minWidth = _2.minWidth || 20;
	this.minHeight = _2.minHeight || 20;
};
Ext.extend(Ext.CenterLayoutRegion, Ext.LayoutRegion, {
	hide : function() {
	},
	show : function() {
	},
	getMinWidth : function() {
		return this.minWidth;
	},
	getMinHeight : function() {
		return this.minHeight;
	}
});
Ext.NorthLayoutRegion = function(_3, _4) {
	Ext.NorthLayoutRegion.superclass.constructor.call(this, _3, _4, "north",
			"n-resize");
	if (this.split) {
		this.split.placement = Ext.SplitBar.TOP;
		this.split.orientation = Ext.SplitBar.VERTICAL;
		this.split.el.addClass("x-layout-split-v");
	}
	var _5 = _4.initialSize || _4.height;
	if (typeof _5 != "undefined") {
		this.el.setHeight(_5);
	}
};
Ext.extend(Ext.NorthLayoutRegion, Ext.SplitLayoutRegion, {
	orientation : Ext.SplitBar.VERTICAL,
	getBox : function() {
		if (this.collapsed) {
			return this.collapsedEl.getBox();
		}
		var _6 = this.el.getBox();
		if (this.split) {
			_6.height += this.split.el.getHeight();
		}
		return _6;
	},
	updateBox : function(_7) {
		if (this.split && !this.collapsed) {
			_7.height -= this.split.el.getHeight();
			this.split.el.setLeft(_7.x);
			this.split.el.setTop(_7.y + _7.height);
			this.split.el.setWidth(_7.width);
		}
		if (this.collapsed) {
			this.updateBody(_7.width, null);
		}
		Ext.NorthLayoutRegion.superclass.updateBox.call(this, _7);
	}
});
Ext.SouthLayoutRegion = function(_8, _9) {
	Ext.SouthLayoutRegion.superclass.constructor.call(this, _8, _9, "south",
			"s-resize");
	if (this.split) {
		this.split.placement = Ext.SplitBar.BOTTOM;
		this.split.orientation = Ext.SplitBar.VERTICAL;
		this.split.el.addClass("x-layout-split-v");
	}
	var _a = _9.initialSize || _9.height;
	if (typeof _a != "undefined") {
		this.el.setHeight(_a);
	}
};
Ext.extend(Ext.SouthLayoutRegion, Ext.SplitLayoutRegion, {
	orientation : Ext.SplitBar.VERTICAL,
	getBox : function() {
		if (this.collapsed) {
			return this.collapsedEl.getBox();
		}
		var _b = this.el.getBox();
		if (this.split) {
			var sh = this.split.el.getHeight();
			_b.height += sh;
			_b.y -= sh;
		}
		return _b;
	},
	updateBox : function(_d) {
		if (this.split && !this.collapsed) {
			var sh = this.split.el.getHeight();
			_d.height -= sh;
			_d.y += sh;
			this.split.el.setLeft(_d.x);
			this.split.el.setTop(_d.y - sh);
			this.split.el.setWidth(_d.width);
		}
		if (this.collapsed) {
			this.updateBody(_d.width, null);
		}
		Ext.SouthLayoutRegion.superclass.updateBox.call(this, _d);
	}
});
Ext.EastLayoutRegion = function(_f, _10) {
	Ext.EastLayoutRegion.superclass.constructor.call(this, _f, _10, "east",
			"e-resize");
	if (this.split) {
		this.split.placement = Ext.SplitBar.RIGHT;
		this.split.orientation = Ext.SplitBar.HORIZONTAL;
		this.split.el.addClass("x-layout-split-h");
	}
	var _11 = _10.initialSize || _10.width;
	if (typeof _11 != "undefined") {
		this.el.setWidth(_11);
	}
};
Ext.extend(Ext.EastLayoutRegion, Ext.SplitLayoutRegion, {
	orientation : Ext.SplitBar.HORIZONTAL,
	getBox : function() {
		if (this.collapsed) {
			return this.collapsedEl.getBox();
		}
		var box = this.el.getBox();
		if (this.split) {
			var sw = this.split.el.getWidth();
			box.width += sw;
			box.x -= sw;
		}
		return box;
	},
	updateBox : function(box) {
		if (this.split && !this.collapsed) {
			var sw = this.split.el.getWidth();
			box.width -= sw;
			this.split.el.setLeft(box.x);
			this.split.el.setTop(box.y);
			this.split.el.setHeight(box.height);
			box.x += sw;
		}
		if (this.collapsed) {
			this.updateBody(null, box.height);
		}
		Ext.EastLayoutRegion.superclass.updateBox.call(this, box);
	}
});
Ext.WestLayoutRegion = function(mgr, _17) {
	Ext.WestLayoutRegion.superclass.constructor.call(this, mgr, _17, "west",
			"w-resize");
	if (this.split) {
		this.split.placement = Ext.SplitBar.LEFT;
		this.split.orientation = Ext.SplitBar.HORIZONTAL;
		this.split.el.addClass("x-layout-split-h");
	}
	var _18 = _17.initialSize || _17.width;
	if (typeof _18 != "undefined") {
		this.el.setWidth(_18);
	}
};
Ext.extend(Ext.WestLayoutRegion, Ext.SplitLayoutRegion, {
	orientation : Ext.SplitBar.HORIZONTAL,
	getBox : function() {
		if (this.collapsed) {
			return this.collapsedEl.getBox();
		}
		var box = this.el.getBox();
		if (this.split) {
			box.width += this.split.el.getWidth();
		}
		return box;
	},
	updateBox : function(box) {
		if (this.split && !this.collapsed) {
			var sw = this.split.el.getWidth();
			box.width -= sw;
			this.split.el.setLeft(box.x + box.width);
			this.split.el.setTop(box.y);
			this.split.el.setHeight(box.height);
		}
		if (this.collapsed) {
			this.updateBody(null, box.height);
		}
		Ext.WestLayoutRegion.superclass.updateBox.call(this, box);
	}
});

Ext.LayoutStateManager = function(_1) {
	this.state = {
		north : {},
		south : {},
		east : {},
		west : {}
	};
};
Ext.LayoutStateManager.prototype = {
	init : function(_2, _3) {
		this.provider = _3;
		var _4 = _3.get(_2.id + "-layout-state");
		if (_4) {
			var _5 = _2.isUpdating();
			if (!_5) {
				_2.beginUpdate();
			}
			for ( var _6 in _4) {
				if (typeof _4[_6] != "function") {
					var _7 = _4[_6];
					var r = _2.getRegion(_6);
					if (r && _7) {
						if (_7.size) {
							r.resizeTo(_7.size);
						}
						if (_7.collapsed == true) {
							r.collapse(true);
						} else {
							r.expand(null, true);
						}
					}
				}
			}
			if (!_5) {
				_2.endUpdate();
			}
			this.state = _4;
		}
		this.layout = _2;
		_2.on("regionresized", this.onRegionResized, this);
		_2.on("regioncollapsed", this.onRegionCollapsed, this);
		_2.on("regionexpanded", this.onRegionExpanded, this);
	},
	storeState : function() {
		this.provider.set(this.layout.id + "-layout-state", this.state);
	},
	onRegionResized : function(_9, _a) {
		this.state[_9.getPosition()].size = _a;
		this.storeState();
	},
	onRegionCollapsed : function(_b) {
		this.state[_b.getPosition()].collapsed = true;
		this.storeState();
	},
	onRegionExpanded : function(_c) {
		this.state[_c.getPosition()].collapsed = false;
		this.storeState();
	}
};

Ext.ContentPanel = function(el, _2, _3) {
	Ext.ContentPanel.superclass.constructor.call(this);
	if (el.autoCreate) {
		_2 = el;
		el = Ext.id();
	}
	this.el = Ext.get(el);
	if (!this.el && _2 && _2.autoCreate) {
		if (typeof _2.autoCreate == "object") {
			if (!_2.autoCreate.id) {
				_2.autoCreate.id = _2.id || el;
			}
			this.el = Ext.DomHelper.append(document.body, _2.autoCreate, true);
		} else {
			this.el = Ext.DomHelper.append(document.body, {
				tag : "div",
				cls : "x-layout-inactive-content",
				id : _2.id || el
			}, true);
		}
	}
	this.closable = false;
	this.loaded = false;
	this.active = false;
	if (typeof _2 == "string") {
		this.title = _2;
	} else {
		Ext.apply(this, _2);
	}
	if (this.resizeEl) {
		this.resizeEl = Ext.get(this.resizeEl, true);
	} else {
		this.resizeEl = this.el;
	}
	this.events = {
		"activate" : true,
		"deactivate" : true,
		"resize" : true
	};
	if (this.autoScroll) {
		this.resizeEl.setStyle("overflow", "auto");
	}
	_3 = _3 || this.content;
	if (_3) {
		this.setContent(_3);
	}
	if (_2 && _2.url) {
		this.setUrl(this.url, this.params, this.loadOnce);
	}
};
Ext.extend(Ext.ContentPanel, Ext.util.Observable, {
	tabTip : "",
	setRegion : function(_4) {
		this.region = _4;
		if (_4) {
			this.el.replaceClass("x-layout-inactive-content",
					"x-layout-active-content");
		} else {
			this.el.replaceClass("x-layout-active-content",
					"x-layout-inactive-content");
		}
	},
	getToolbar : function() {
		return this.toolbar;
	},
	setActiveState : function(_5) {
		this.active = _5;
		if (!_5) {
			this.fireEvent("deactivate", this);
		} else {
			this.fireEvent("activate", this);
		}
	},
	setContent : function(_6, _7) {
		this.el.update(_6, _7);
	},
	ignoreResize : function(w, h) {
		if (this.lastSize && this.lastSize.width == w
				&& this.lastSize.height == h) {
			return true;
		} else {
			this.lastSize = {
				width : w,
				height : h
			};
			return false;
		}
	},
	getUpdateManager : function() {
		return this.el.getUpdateManager();
	},
	load : function() {
		var um = this.el.getUpdateManager();
		um.update.apply(um, arguments);
		return this;
	},
	setUrl : function(_b, _c, _d) {
		if (this.refreshDelegate) {
			this.removeListener("activate", this.refreshDelegate);
		}
		this.refreshDelegate = this._handleRefresh.createDelegate(this, [ _b,
				_c, _d ]);
		this.on("activate", this._handleRefresh.createDelegate(this, [ _b, _c,
				_d ]));
		return this.el.getUpdateManager();
	},
	_handleRefresh : function(_e, _f, _10) {
		if (!_10 || !this.loaded) {
			var _11 = this.el.getUpdateManager();
			_11.update(_e, _f, this._setLoaded.createDelegate(this));
		}
	},
	_setLoaded : function() {
		this.loaded = true;
	},
	getId : function() {
		return this.el.id;
	},
	getEl : function() {
		return this.el;
	},
	adjustForComponents : function(_12, _13) {
		if (this.resizeEl != this.el) {
			_12 -= this.el.getFrameWidth("lr");
			_13 -= this.el.getFrameWidth("tb");
		}
		if (this.toolbar) {
			var te = this.toolbar.getEl();
			_13 -= te.getHeight();
			te.setWidth(_12);
		}
		if (this.adjustments) {
			_12 += this.adjustments[0];
			_13 += this.adjustments[1];
		}
		return {
			"width" : _12,
			"height" : _13
		};
	},
	setSize : function(_15, _16) {
		if (this.fitToFrame && !this.ignoreResize(_15, _16)) {
			if (this.fitContainer && this.resizeEl != this.el) {
				this.el.setSize(_15, _16);
			}
			var _17 = this.adjustForComponents(_15, _16);
			this.resizeEl.setSize(this.autoWidth ? "auto" : _17.width,
					_17.height);
			this.fireEvent("resize", this, _17.width, _17.height);
		}
	},
	getTitle : function() {
		return this.title;
	},
	setTitle : function(_18) {
		this.title = _18;
		if (this.region) {
			this.region.updatePanelTitle(this, _18);
		}
	},
	isClosable : function() {
		return this.closable;
	},
	beforeSlide : function() {
		this.el.clip();
		this.resizeEl.clip();
	},
	afterSlide : function() {
		this.el.unclip();
		this.resizeEl.unclip();
	},
	refresh : function() {
		if (this.refreshDelegate) {
			this.loaded = false;
			this.refreshDelegate();
		}
	},
	destroy : function() {
		this.el.removeAllListeners();
		var _19 = document.createElement("span");
		_19.appendChild(this.el.dom);
		_19.innerHTML = "";
		this.el.remove();
		this.el = null;
	}
});
Ext.GridPanel = function(_1a, _1b) {
	this.wrapper = Ext.DomHelper.append(document.body, {
		tag : "div",
		cls : "x-layout-grid-wrapper x-layout-inactive-content"
	}, true);
	this.wrapper.dom.appendChild(_1a.container.dom);
	Ext.GridPanel.superclass.constructor.call(this, this.wrapper, _1b);
	if (this.toolbar) {
		this.toolbar.el.insertBefore(this.wrapper.dom.firstChild);
	}
	_1a.monitorWindowResize = false;
	_1a.autoHeight = false;
	_1a.autoWidth = false;
	this.grid = _1a;
	this.grid.container.replaceClass("x-layout-inactive-content",
			"x-layout-component-panel");
};
Ext.extend(Ext.GridPanel, Ext.ContentPanel, {
	getId : function() {
		return this.grid.id;
	},
	getGrid : function() {
		return this.grid;
	},
	setSize : function(_1c, _1d) {
		if (!this.ignoreResize(_1c, _1d)) {
			var _1e = this.grid;
			var _1f = this.adjustForComponents(_1c, _1d);
			_1e.container.setSize(_1f.width, _1f.height);
			_1e.autoSize();
		}
	},
	beforeSlide : function() {
		this.grid.getView().scroller.clip();
	},
	afterSlide : function() {
		this.grid.getView().scroller.unclip();
	},
	destroy : function() {
		this.grid.destroy();
		delete this.grid;
		Ext.GridPanel.superclass.destroy.call(this);
	}
});
Ext.NestedLayoutPanel = function(_20, _21) {
	Ext.NestedLayoutPanel.superclass.constructor.call(this, _20.getEl(), _21);
	_20.monitorWindowResize = false;
	this.layout = _20;
	this.layout.getEl().addClass("x-layout-nested-layout");
};
Ext.extend(Ext.NestedLayoutPanel, Ext.ContentPanel, {
	setSize : function(_22, _23) {
		if (!this.ignoreResize(_22, _23)) {
			var _24 = this.adjustForComponents(_22, _23);
			var el = this.layout.getEl();
			el.setSize(_24.width, _24.height);
			var _26 = el.dom.offsetWidth;
			this.layout.layout();
			if (Ext.isIE && !this.initialized) {
				this.initialized = true;
				this.layout.layout();
			}
		}
	},
	getLayout : function() {
		return this.layout;
	}
});
Ext.ScrollPanel = function(el, _28, _29) {
	_28 = _28 || {};
	_28.fitToFrame = true;
	Ext.ScrollPanel.superclass.constructor.call(this, el, _28, _29);
	this.el.dom.style.overflow = "hidden";
	var _2a = this.el.wrap( {
		cls : "x-scroller x-layout-inactive-content"
	});
	this.el.removeClass("x-layout-inactive-content");
	this.el.on("mousewheel", this.onWheel, this);
	var up = _2a.createChild( {
		cls : "x-scroller-up",
		html : "&#160;"
	}, this.el.dom);
	var _2c = _2a.createChild( {
		cls : "x-scroller-down",
		html : "&#160;"
	});
	up.unselectable();
	_2c.unselectable();
	up.on("click", this.scrollUp, this);
	_2c.on("click", this.scrollDown, this);
	up.addClassOnOver("x-scroller-btn-over");
	_2c.addClassOnOver("x-scroller-btn-over");
	up.addClassOnClick("x-scroller-btn-click");
	_2c.addClassOnClick("x-scroller-btn-click");
	this.adjustments = [ 0, -(up.getHeight() + _2c.getHeight()) ];
	this.resizeEl = this.el;
	this.el = _2a;
	this.up = up;
	this.down = _2c;
};
Ext
		.extend(
				Ext.ScrollPanel,
				Ext.ContentPanel,
				{
					increment : 100,
					wheelIncrement : 5,
					scrollUp : function() {
						this.resizeEl.scroll("up", this.increment, {
							callback : this.afterScroll,
							scope : this
						});
					},
					scrollDown : function() {
						this.resizeEl.scroll("down", this.increment, {
							callback : this.afterScroll,
							scope : this
						});
					},
					afterScroll : function() {
						var el = this.resizeEl;
						var t = el.dom.scrollTop, h = el.dom.scrollHeight, ch = el.dom.clientHeight;
						this.up[t == 0 ? "addClass" : "removeClass"]
								("x-scroller-btn-disabled");
						this.down[h - t <= ch ? "addClass" : "removeClass"]
								("x-scroller-btn-disabled");
					},
					setSize : function() {
						Ext.ScrollPanel.superclass.setSize.apply(this,
								arguments);
						this.afterScroll();
					},
					onWheel : function(e) {
						var d = e.getWheelDelta();
						this.resizeEl.dom.scrollTop -= (d * this.wheelIncrement);
						this.afterScroll();
						e.stopEvent();
					},
					setContent : function(_33, _34) {
						this.resizeEl.update(_33, _34);
					}
				});

Ext.ReaderLayout = function(_1, _2) {
	var c = _1 || {
		size : {}
	};
	Ext.ReaderLayout.superclass.constructor.call(this, _2 || document.body, {
		north : c.north !== false ? Ext.apply( {
			split : false,
			initialSize : 32,
			titlebar : false
		}, c.north) : false,
		west : c.west !== false ? Ext.apply( {
			split : true,
			initialSize : 200,
			minSize : 175,
			maxSize : 400,
			titlebar : true,
			collapsible : true,
			animate : true,
			margins : {
				left : 5,
				right : 0,
				bottom : 5,
				top : 5
			},
			cmargins : {
				left : 5,
				right : 5,
				bottom : 5,
				top : 5
			}
		}, c.west) : false,
		east : c.east !== false ? Ext.apply( {
			split : true,
			initialSize : 200,
			minSize : 175,
			maxSize : 400,
			titlebar : true,
			collapsible : true,
			animate : true,
			margins : {
				left : 0,
				right : 5,
				bottom : 5,
				top : 5
			},
			cmargins : {
				left : 5,
				right : 5,
				bottom : 5,
				top : 5
			}
		}, c.east) : false,
		center : Ext.apply( {
			tabPosition : "top",
			autoScroll : false,
			closeOnTab : true,
			titlebar : false,
			margins : {
				left : c.west !== false ? 0 : 5,
				right : c.east !== false ? 0 : 5,
				bottom : 5,
				top : 2
			}
		}, c.center)
	});
	this.el.addClass("x-reader");
	this.beginUpdate();
	var _4 = new Ext.BorderLayout(Ext.get(document.body).createChild(), {
		south : c.preview !== false ? Ext.apply( {
			split : true,
			initialSize : 200,
			minSize : 100,
			autoScroll : true,
			collapsible : true,
			titlebar : true,
			cmargins : {
				top : 5,
				left : 0,
				right : 0,
				bottom : 0
			}
		}, c.preview) : false,
		center : Ext.apply( {
			autoScroll : false,
			titlebar : false,
			minHeight : 200
		}, c.listView)
	});
	this.add("center", new Ext.NestedLayoutPanel(_4, Ext.apply( {
		title : _1.mainTitle || "",
		tabTip : ""
	}, _1.innerPanelCfg)));
	this.endUpdate();
	this.regions.preview = _4.getRegion("south");
	this.regions.listView = _4.getRegion("center");
};
Ext.extend(Ext.ReaderLayout, Ext.BorderLayout);

Ext.grid.Grid = function(_1, _2) {
	this.container = Ext.get(_1);
	this.container.update("");
	this.container.setStyle("overflow", "hidden");
	this.container.addClass("x-grid-container");
	this.id = this.container.id;
	Ext.apply(this, _2);
	if (this.ds) {
		this.dataSource = this.ds;
		delete this.ds;
	}
	if (this.cm) {
		this.colModel = this.cm;
		delete this.cm;
	}
	if (this.sm) {
		this.selModel = this.sm;
		delete this.sm;
	}
	if (this.width) {
		this.container.setWidth(this.width);
	}
	if (this.height) {
		this.container.setHeight(this.height);
	}
	this.events = {
		"click" : true,
		"dblclick" : true,
		"contextmenu" : true,
		"mousedown" : true,
		"mouseup" : true,
		"mouseover" : true,
		"mouseout" : true,
		"keypress" : true,
		"keydown" : true,
		"cellclick" : true,
		"celldblclick" : true,
		"rowclick" : true,
		"rowdblclick" : true,
		"headerclick" : true,
		"headerdblclick" : true,
		"rowcontextmenu" : true,
		"cellcontextmenu" : true,
		"headercontextmenu" : true,
		"bodyscroll" : true,
		"columnresize" : true,
		"columnmove" : true,
		"startdrag" : true,
		"enddrag" : true,
		"dragdrop" : true,
		"dragover" : true,
		"dragenter" : true,
		"dragout" : true
	};
	Ext.grid.Grid.superclass.constructor.call(this);
};
Ext.extend(Ext.grid.Grid, Ext.util.Observable, {
	minColumnWidth : 25,
	autoSizeColumns : false,
	autoSizeHeaders : true,
	monitorWindowResize : true,
	maxRowsToMeasure : 0,
	trackMouseOver : true,
	enableDragDrop : false,
	enableColumnMove : true,
	enableColumnHide : true,
	enableRowHeightSync : false,
	stripeRows : true,
	autoHeight : false,
	autoExpandColumn : false,
	autoExpandMin : 50,
	autoExpandMax : 1000,
	view : null,
	allowTextSelectionPattern : /INPUT|TEXTAREA|SELECT/i,
	loadMask : false,
	rendered : false,
	render : function() {
		var c = this.container;
		if ((!c.dom.offsetHeight || c.dom.offsetHeight < 20)
				|| c.getStyle("height") == "auto") {
			this.autoHeight = true;
		}
		var _4 = this.getView();
		_4.init(this);
		c.on("click", this.onClick, this);
		c.on("dblclick", this.onDblClick, this);
		c.on("contextmenu", this.onContextMenu, this);
		c.on("keydown", this.onKeyDown, this);
		this.relayEvents(c, [ "mousedown", "mouseup", "mouseover", "mouseout",
				"keypress" ]);
		this.getSelectionModel().init(this);
		_4.render();
		if (this.loadMask) {
			this.loadMask = new Ext.LoadMask(this.container, Ext.apply( {
				store : this.dataSource
			}, this.loadMask));
		}
		this.rendered = true;
		return this;
	},
	reconfigure : function(_5, _6) {
		if (this.loadMask) {
			this.loadMask.destroy();
			this.loadMask = new Ext.LoadMask(this.container, Ext.apply( {
				store : _5
			}, this.loadMask));
		}
		this.view.bind(_5, _6);
		this.dataSource = _5;
		this.colModel = _6;
		this.view.refresh(true);
	},
	onKeyDown : function(e) {
		this.fireEvent("keydown", e);
	},
	destroy : function(_8, _9) {
		if (this.loadMask) {
			this.loadMask.destroy();
		}
		var c = this.container;
		c.removeAllListeners();
		this.view.destroy();
		this.colModel.purgeListeners();
		if (!_9) {
			this.purgeListeners();
		}
		c.update("");
		if (_8 === true) {
			c.remove();
		}
	},
	processEvent : function(_b, e) {
		this.fireEvent(_b, e);
		var t = e.getTarget();
		var v = this.view;
		var _f = v.findHeaderIndex(t);
		if (_f !== false) {
			this.fireEvent("header" + _b, this, _f, e);
		} else {
			var row = v.findRowIndex(t);
			var _11 = v.findCellIndex(t);
			if (row !== false) {
				this.fireEvent("row" + _b, this, row, e);
				if (_11 !== false) {
					this.fireEvent("cell" + _b, this, row, _11, e);
				}
			}
		}
	},
	onClick : function(e) {
		this.processEvent("click", e);
	},
	onContextMenu : function(e, t) {
		this.processEvent("contextmenu", e);
	},
	onDblClick : function(e) {
		this.processEvent("dblclick", e);
	},
	walkCells : function(row, col, _18, fn, _1a) {
		var cm = this.colModel, _1c = cm.getColumnCount();
		var ds = this.dataSource, _1e = ds.getCount(), _1f = true;
		if (_18 < 0) {
			if (col < 0) {
				row--;
				_1f = false;
			}
			while (row >= 0) {
				if (!_1f) {
					col = _1c - 1;
				}
				_1f = false;
				while (col >= 0) {
					if (fn.call(_1a || this, row, col, cm) === true) {
						return [ row, col ];
					}
					col--;
				}
				row--;
			}
		} else {
			if (col >= _1c) {
				row++;
				_1f = false;
			}
			while (row < _1e) {
				if (!_1f) {
					col = 0;
				}
				_1f = false;
				while (col < _1c) {
					if (fn.call(_1a || this, row, col, cm) === true) {
						return [ row, col ];
					}
					col++;
				}
				row++;
			}
		}
		return null;
	},
	getSelections : function() {
		return this.selModel.getSelections();
	},
	autoSize : function() {
		if (this.rendered) {
			this.view.layout();
			if (this.view.adjustForScroll) {
				this.view.adjustForScroll();
			}
		}
	},
	stopEditing : function() {
	},
	getSelectionModel : function() {
		if (!this.selModel) {
			this.selModel = new Ext.grid.RowSelectionModel();
		}
		return this.selModel;
	},
	getDataSource : function() {
		return this.dataSource;
	},
	getColumnModel : function() {
		return this.colModel;
	},
	getView : function() {
		if (!this.view) {
			this.view = new Ext.grid.GridView();
		}
		return this.view;
	},
	getDragDropText : function() {
		var _20 = this.selModel.getCount();
		return String.format(this.ddText, _20, _20 == 1 ? "" : "s");
	}
});
Ext.grid.Grid.prototype.ddText = "{0} selected row{1}";

Ext.grid.AbstractGridView = function() {
	this.grid = null;
	this.events = {
		"beforerowremoved" : true,
		"beforerowsinserted" : true,
		"beforerefresh" : true,
		"rowremoved" : true,
		"rowsinserted" : true,
		"rowupdated" : true,
		"refresh" : true
	};
	Ext.grid.AbstractGridView.superclass.constructor.call(this);
};
Ext.extend(Ext.grid.AbstractGridView, Ext.util.Observable, {
	rowClass : "x-grid-row",
	cellClass : "x-grid-cell",
	tdClass : "x-grid-td",
	hdClass : "x-grid-hd",
	splitClass : "x-grid-hd-split",
	init : function(_1) {
		this.grid = _1;
		var _2 = this.grid.container.id;
		this.colSelector = "#" + _2 + " ." + this.cellClass + "-";
		this.tdSelector = "#" + _2 + " ." + this.tdClass + "-";
		this.hdSelector = "#" + _2 + " ." + this.hdClass + "-";
		this.splitSelector = "#" + _2 + " ." + this.splitClass + "-";
	},
	getColumnRenderers : function() {
		var _3 = [];
		var cm = this.grid.colModel;
		var _5 = cm.getColumnCount();
		for ( var i = 0; i < _5; i++) {
			_3[i] = cm.getRenderer(i);
		}
		return _3;
	},
	getColumnIds : function() {
		var _7 = [];
		var cm = this.grid.colModel;
		var _9 = cm.getColumnCount();
		for ( var i = 0; i < _9; i++) {
			_7[i] = cm.getColumnId(i);
		}
		return _7;
	},
	getDataIndexes : function() {
		if (!this.indexMap) {
			this.indexMap = this.buildIndexMap();
		}
		return this.indexMap.colToData;
	},
	getColumnIndexByDataIndex : function(_b) {
		if (!this.indexMap) {
			this.indexMap = this.buildIndexMap();
		}
		return this.indexMap.dataToCol[_b];
	},
	setCSSStyle : function(_c, _d, _e) {
		var _f = "#" + this.grid.id + " .x-grid-col-" + _c;
		Ext.util.CSS.updateRule(_f, _d, _e);
	},
	generateRules : function(cm) {
		var _11 = [];
		for ( var i = 0, len = cm.getColumnCount(); i < len; i++) {
			var cid = cm.getColumnId(i);
			_11.push(this.colSelector, cid, " {\n", cm.config[i].css, "}\n",
					this.tdSelector, cid, " {\n}\n", this.hdSelector, cid,
					" {\n}\n", this.splitSelector, cid, " {\n}\n");
		}
		return Ext.util.CSS.createStyleSheet(_11.join(""));
	}
});

Ext.grid.GridView = function(_1) {
	Ext.grid.GridView.superclass.constructor.call(this);
	this.el = null;
	Ext.apply(this, _1);
};
Ext
		.extend(
				Ext.grid.GridView,
				Ext.grid.AbstractGridView,
				{
					rowClass : "x-grid-row",
					cellClass : "x-grid-col",
					tdClass : "x-grid-td",
					hdClass : "x-grid-hd",
					splitClass : "x-grid-split",
					sortClasses : [ "sort-asc", "sort-desc" ],
					enableMoveAnim : false,
					hlColor : "C3DAF9",
					dh : Ext.DomHelper,
					fly : Ext.Element.fly,
					css : Ext.util.CSS,
					borderWidth : 1,
					splitOffset : 3,
					scrollIncrement : 22,
					cellRE : /(?:.*?)x-grid-(?:hd|cell|csplit)-(?:[\d]+)-([\d]+)(?:.*?)/,
					findRE : /\s?(?:x-grid-hd|x-grid-col|x-grid-csplit)\s/,
					init : function(_2) {
						Ext.grid.GridView.superclass.init.call(this, _2);
						this.bind(_2.dataSource, _2.colModel);
						_2.on("headerclick", this.handleHeaderClick, this);
						if (_2.trackMouseOver) {
							_2.on("mouseover", this.onRowOver, this);
							_2.on("mouseout", this.onRowOut, this);
						}
						_2.cancelTextSelection = function() {
						};
						this.gridId = _2.id;
						var _3 = this.templates || {};
						if (!_3.master) {
							_3.master = new Ext.Template(
									"<div class=\"x-grid\" hidefocus=\"true\">",
									"<div class=\"x-grid-topbar\"></div>",
									"<div class=\"x-grid-scroller\"><div></div></div>",
									"<div class=\"x-grid-locked\">",
									"<div class=\"x-grid-header\">{lockedHeader}</div>",
									"<div class=\"x-grid-body\">{lockedBody}</div>",
									"</div>",
									"<div class=\"x-grid-viewport\">",
									"<div class=\"x-grid-header\">{header}</div>",
									"<div class=\"x-grid-body\">{body}</div>",
									"</div>",
									"<div class=\"x-grid-bottombar\"></div>",
									"<a href=\"#\" class=\"x-grid-focus\" tabIndex=\"-1\"></a>",
									"<div class=\"x-grid-resize-proxy\">&#160;</div>",
									"</div>");
							_3.master.disableformats = true;
						}
						if (!_3.header) {
							_3.header = new Ext.Template(
									"<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">",
									"<tbody><tr class=\"x-grid-hd-row\">{cells}</tr></tbody>",
									"</table>{splits}");
							_3.header.disableformats = true;
						}
						_3.header.compile();
						if (!_3.hcell) {
							_3.hcell = new Ext.Template(
									"<td class=\"x-grid-hd x-grid-td-{id} {cellId}\"><div title=\"{title}\" class=\"x-grid-hd-inner x-grid-hd-{id}\">",
									"<div class=\"x-grid-hd-text\" unselectable=\"on\">{value}<img class=\"x-grid-sort-icon\" src=\"",
									Ext.BLANK_IMAGE_URL, "\" /></div>",
									"</div></td>");
							_3.hcell.disableFormats = true;
						}
						_3.hcell.compile();
						if (!_3.hsplit) {
							_3.hsplit = new Ext.Template(
									"<div class=\"x-grid-split {splitId} x-grid-split-{id}\" style=\"{style}\" unselectable=\"on\">&#160;</div>");
							_3.hsplit.disableFormats = true;
						}
						_3.hsplit.compile();
						if (!_3.body) {
							_3.body = new Ext.Template(
									"<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">",
									"<tbody>{rows}</tbody>", "</table>");
							_3.body.disableFormats = true;
						}
						_3.body.compile();
						if (!_3.row) {
							_3.row = new Ext.Template(
									"<tr class=\"x-grid-row {alt}\">{cells}</tr>");
							_3.row.disableFormats = true;
						}
						_3.row.compile();
						if (!_3.cell) {
							_3.cell = new Ext.Template(
									"<td class=\"x-grid-col x-grid-td-{id} {cellId} {css}\" tabIndex=\"0\">",
									"<div class=\"x-grid-col-{id} x-grid-cell-inner\"><div class=\"x-grid-cell-text\" unselectable=\"on\" {attr}>{value}</div></div>",
									"</td>");
							_3.cell.disableFormats = true;
						}
						_3.cell.compile();
						this.templates = _3;
					},
					bind : function(ds, cm) {
						if (this.ds) {
							this.ds.un("load", this.onLoad, this);
							this.ds.un("datachanged", this.onDataChange);
							this.ds.un("add", this.onAdd);
							this.ds.un("remove", this.onRemove);
							this.ds.un("update", this.onUpdate);
							this.ds.un("clear", this.onClear);
						}
						if (ds) {
							ds.on("load", this.onLoad, this);
							ds.on("datachanged", this.onDataChange, this);
							ds.on("add", this.onAdd, this);
							ds.on("remove", this.onRemove, this);
							ds.on("update", this.onUpdate, this);
							ds.on("clear", this.onClear, this);
						}
						this.ds = ds;
						if (this.cm) {
							this.cm.un("widthchange", this.updateColumns, this);
							this.cm
									.un("headerchange", this.updateHeaders,
											this);
							this.cm.un("hiddenchange", this.handleHiddenChange,
									this);
							this.cm.un("columnmoved", this.handleColumnMove,
									this);
							this.cm.un("columnlockchange",
									this.handleLockChange, this);
						}
						if (cm) {
							this.generateRules(cm);
							cm.on("widthchange", this.updateColumns, this);
							cm.on("headerchange", this.updateHeaders, this);
							cm
									.on("hiddenchange",
											this.handleHiddenChange, this);
							cm.on("columnmoved", this.handleColumnMove, this);
							cm.on("columnlockchange", this.handleLockChange,
									this);
						}
						this.cm = cm;
					},
					onDataChange : function() {
						this.refresh();
						this.updateHeaderSortState();
					},
					onClear : function() {
						this.refresh();
					},
					onUpdate : function(ds, _7) {
						this.refreshRow(_7);
					},
					refreshRow : function(_8) {
						var ds = this.ds, _a;
						if (typeof _8 == "number") {
							_a = _8;
							_8 = ds.getAt(_a);
						} else {
							_a = ds.indexOf(_8);
						}
						var _b = this.getRowComposite(_a);
						var _c = [];
						this.insertRows(ds, _a, _a, true);
						this.onRemove(ds, _8, _a + 1, true);
						this.syncRowHeights(_a, _a);
						this.layout();
						this.fireEvent("rowupdated", this, _a, _8);
					},
					onAdd : function(ds, _e, _f) {
						this.insertRows(ds, _f, _f + (_e.length - 1));
					},
					onRemove : function(ds, _11, _12, _13) {
						if (_13 !== true) {
							this.fireEvent("beforerowremoved", this, _12, _11);
						}
						var bt = this.getBodyTable(), lt = this
								.getLockedTable();
						if (bt.rows[_12]) {
							bt.firstChild.removeChild(bt.rows[_12]);
						}
						if (lt.rows[_12]) {
							lt.firstChild.removeChild(lt.rows[_12]);
						}
						if (_13 !== true) {
							this.stripeRows(_12);
							this.syncRowHeights(_12, _12);
							this.layout();
							this.fireEvent("rowremoved", this, _12, _11);
						}
					},
					onLoad : function() {
						this.scrollToTop();
					},
					scrollToTop : function() {
						if (this.scroller) {
							this.scroller.dom.scrollTop = 0;
							this.syncScroll();
						}
					},
					getHeaderPanel : function(_16) {
						if (_16) {
							this.headerPanel.show();
						}
						return this.headerPanel;
					},
					getFooterPanel : function(_17) {
						if (_17) {
							this.footerPanel.show();
						}
						return this.footerPanel;
					},
					initElements : function() {
						var E = Ext.Element;
						var el = this.grid.container.dom.firstChild;
						var cs = el.childNodes;
						this.el = new E(el);
						this.headerPanel = new E(el.firstChild);
						this.headerPanel.enableDisplayMode("block");
						this.scroller = new E(cs[1]);
						this.scrollSizer = new E(this.scroller.dom.firstChild);
						this.lockedWrap = new E(cs[2]);
						this.lockedHd = new E(this.lockedWrap.dom.firstChild);
						this.lockedBody = new E(
								this.lockedWrap.dom.childNodes[1]);
						this.mainWrap = new E(cs[3]);
						this.mainHd = new E(this.mainWrap.dom.firstChild);
						this.mainBody = new E(this.mainWrap.dom.childNodes[1]);
						this.footerPanel = new E(cs[4]);
						this.footerPanel.enableDisplayMode("block");
						this.focusEl = new E(cs[5]);
						this.focusEl.swallowEvent("click", true);
						this.resizeProxy = new E(cs[6]);
						this.headerSelector = String.format(
								"#{0} td.x-grid-hd, #{1} td.x-grid-hd",
								this.lockedHd.id, this.mainHd.id);
						this.splitterSelector = String.format(
								"#{0} div.x-grid-split, #{1} div.x-grid-split",
								this.lockedHd.id, this.mainHd.id);
					},
					getHeaderCell : function(_1b) {
						return Ext.DomQuery.select(this.headerSelector)[_1b];
					},
					getHeaderCellMeasure : function(_1c) {
						return this.getHeaderCell(_1c).firstChild;
					},
					getHeaderCellText : function(_1d) {
						return this.getHeaderCell(_1d).firstChild.firstChild;
					},
					getLockedTable : function() {
						return this.lockedBody.dom.firstChild;
					},
					getBodyTable : function() {
						return this.mainBody.dom.firstChild;
					},
					getLockedRow : function(_1e) {
						return this.getLockedTable().rows[_1e];
					},
					getRow : function(_1f) {
						return this.getBodyTable().rows[_1f];
					},
					getRowComposite : function(_20) {
						if (!this.rowEl) {
							this.rowEl = new Ext.CompositeElementLite();
						}
						var els = [], _22, _23;
						if (_22 = this.getLockedRow(_20)) {
							els.push(_22);
						}
						if (_23 = this.getRow(_20)) {
							els.push(_23);
						}
						this.rowEl.elements = els;
						return this.rowEl;
					},
					getCell : function(_24, _25) {
						var _26 = this.cm.getLockedCount();
						var _27;
						if (_25 < _26) {
							_27 = this.lockedBody.dom.firstChild;
						} else {
							_27 = this.mainBody.dom.firstChild;
							_25 -= _26;
						}
						return _27.rows[_24].childNodes[_25];
					},
					getCellText : function(_28, _29) {
						return this.getCell(_28, _29).firstChild.firstChild;
					},
					getCellBox : function(_2a) {
						var b = this.fly(_2a).getBox();
						if (Ext.isOpera) {
							b.y = _2a.offsetTop + this.mainBody.getY();
						}
						return b;
					},
					getCellIndex : function(_2c) {
						var id = String(_2c.className).match(this.cellRE);
						if (id) {
							return parseInt(id[1], 10);
						}
						return 0;
					},
					findHeaderIndex : function(n) {
						var r = Ext.fly(n).findParent("td." + this.hdClass, 6);
						return r ? this.getCellIndex(r) : false;
					},
					findHeaderCell : function(n) {
						var r = Ext.fly(n).findParent("td." + this.hdClass, 6);
						return r ? r : false;
					},
					findRowIndex : function(n) {
						if (!n) {
							return false;
						}
						var r = Ext.fly(n).findParent("tr." + this.rowClass, 6);
						return r ? r.rowIndex : false;
					},
					findCellIndex : function(_34) {
						var _35 = this.el.dom;
						while (_34 && _34 != _35) {
							if (this.findRE.test(_34.className)) {
								return this.getCellIndex(_34);
							}
							_34 = _34.parentNode;
						}
						return false;
					},
					getColumnId : function(_36) {
						return this.cm.getColumnId(_36);
					},
					getSplitters : function() {
						if (this.splitterSelector) {
							return Ext.DomQuery.select(this.splitterSelector);
						} else {
							return null;
						}
					},
					getSplitter : function(_37) {
						return this.getSplitters()[_37];
					},
					onRowOver : function(e, t) {
						var row;
						if ((row = this.findRowIndex(t)) !== false) {
							this.getRowComposite(row).addClass(
									"x-grid-row-over");
						}
					},
					onRowOut : function(e, t) {
						var row;
						if ((row = this.findRowIndex(t)) !== false
								&& row !== this.findRowIndex(e
										.getRelatedTarget())) {
							this.getRowComposite(row).removeClass(
									"x-grid-row-over");
						}
					},
					renderHeaders : function() {
						var cm = this.cm;
						var ct = this.templates.hcell, ht = this.templates.header, st = this.templates.hsplit;
						var cb = [], lb = [], sb = [], lsb = [], p = {};
						for ( var i = 0, len = cm.getColumnCount(); i < len; i++) {
							p.cellId = "x-grid-hd-0-" + i;
							p.splitId = "x-grid-csplit-0-" + i;
							p.id = cm.getColumnId(i);
							p.title = cm.getColumnTooltip(i) || "";
							p.value = cm.getColumnHeader(i) || "";
							p.style = (this.grid.enableColumnResize === false
									|| !cm.isResizable(i) || cm.isFixed(i)) ? "cursor:default"
									: "";
							if (!cm.isLocked(i)) {
								cb[cb.length] = ct.apply(p);
								sb[sb.length] = st.apply(p);
							} else {
								lb[lb.length] = ct.apply(p);
								lsb[lsb.length] = st.apply(p);
							}
						}
						return [ ht.apply( {
							cells : lb.join(""),
							splits : lsb.join("")
						}), ht.apply( {
							cells : cb.join(""),
							splits : sb.join("")
						}) ];
					},
					updateHeaders : function() {
						var _49 = this.renderHeaders();
						this.lockedHd.update(_49[0]);
						this.mainHd.update(_49[1]);
					},
					focusRow : function(row) {
						var x = this.scroller.dom.scrollLeft;
						this.focusCell(row, 0, false);
						this.scroller.dom.scrollLeft = x;
					},
					focusCell : function(row, col, _4e) {
						var el = this.ensureVisible(row, col, _4e);
						this.focusEl.alignTo(el, "tl-tl");
						this.focusEl.focus.defer(1, this.focusEl);
					},
					ensureVisible : function(row, col, _52) {
						if (typeof row != "number") {
							row = row.rowIndex;
						}
						if (row < 0 && row >= this.ds.getCount()) {
							return;
						}
						col = (col !== undefined ? col : 0);
						var cm = this.grid.colModel;
						while (cm.isHidden(col)) {
							col++;
						}
						var el = this.getCell(row, col);
						if (!el) {
							return;
						}
						var c = this.scroller.dom;
						var _56 = parseInt(el.offsetTop, 10);
						var _57 = parseInt(el.offsetLeft, 10);
						var _58 = _56 + el.offsetHeight;
						var _59 = _57 + el.offsetWidth;
						var ch = c.clientHeight - this.mainHd.dom.offsetHeight;
						var _5b = parseInt(c.scrollTop, 10);
						var _5c = parseInt(c.scrollLeft, 10);
						var _5d = _5b + ch;
						var _5e = _5c + c.clientWidth;
						if (_56 < _5b) {
							c.scrollTop = _56;
						} else {
							if (_58 > _5d) {
								c.scrollTop = _58 - ch;
							}
						}
						if (_52 !== false) {
							if (_57 < _5c) {
								c.scrollLeft = _57;
							} else {
								if (_59 > _5e) {
									c.scrollLeft = _59 - c.clientWidth;
								}
							}
						}
						return el;
					},
					updateColumns : function() {
						this.grid.stopEditing();
						var cm = this.grid.colModel, _60 = this.getColumnIds();
						var pos = 0;
						for ( var i = 0, len = cm.getColumnCount(); i < len; i++) {
							var w = cm.getColumnWidth(i);
							this.css.updateRule(this.colSelector + _60[i],
									"width", (w - this.borderWidth) + "px");
							this.css.updateRule(this.hdSelector + _60[i],
									"width", (w - this.borderWidth) + "px");
						}
						this.updateSplitters();
					},
					updateSplitters : function() {
						var cm = this.cm, s = this.getSplitters();
						if (s) {
							var pos = 0, _68 = true;
							for ( var i = 0, len = cm.getColumnCount(); i < len; i++) {
								if (cm.isHidden(i)) {
									continue;
								}
								var w = cm.getColumnWidth(i);
								if (!cm.isLocked(i) && _68) {
									pos = 0;
									_68 = false;
								}
								pos += w;
								s[i].style.left = (pos - this.splitOffset)
										+ "px";
							}
						}
					},
					handleHiddenChange : function(_6c, _6d, _6e) {
						if (_6e) {
							this.hideColumn(_6d);
						} else {
							this.unhideColumn(_6d);
						}
					},
					hideColumn : function(_6f) {
						var cid = this.getColumnId(_6f);
						this.css.updateRule(this.tdSelector + cid, "display",
								"none");
						this.css.updateRule(this.splitSelector + cid,
								"display", "none");
						if (Ext.isSafari) {
							this.updateHeaders();
						}
						this.updateSplitters();
						this.layout();
					},
					unhideColumn : function(_71) {
						var cid = this.getColumnId(_71);
						this.css.updateRule(this.tdSelector + cid, "display",
								"");
						this.css.updateRule(this.splitSelector + cid,
								"display", "");
						if (Ext.isSafari) {
							this.updateHeaders();
						}
						this.updateSplitters();
						this.layout();
					},
					insertRows : function(dm, _74, _75, _76) {
						if (_74 == 0 && _75 == dm.getCount() - 1) {
							this.refresh();
						} else {
							if (!_76) {
								this.fireEvent("beforerowsinserted", this, _74,
										_75);
							}
							var s = this.getScrollState();
							var _78 = this.renderRows(_74, _75);
							this.bufferRows(_78[0], this.getLockedTable(), _74);
							this.bufferRows(_78[1], this.getBodyTable(), _74);
							this.restoreScroll(s);
							if (!_76) {
								this.fireEvent("rowsinserted", this, _74, _75);
								this.syncRowHeights(_74, _75);
								this.stripeRows(_74);
								this.layout();
							}
						}
					},
					bufferRows : function(_79, _7a, _7b) {
						var _7c = null, _7d = _7a.rows, _7e = _7a.tBodies[0];
						if (_7b < _7d.length) {
							_7c = _7d[_7b];
						}
						var b = document.createElement("div");
						b.innerHTML = "<table><tbody>" + _79
								+ "</tbody></table>";
						var _80 = b.firstChild.rows;
						for ( var i = 0, len = _80.length; i < len; i++) {
							if (_7c) {
								_7e.insertBefore(_80[0], _7c);
							} else {
								_7e.appendChild(_80[0]);
							}
						}
						b.innerHTML = "";
						b = null;
					},
					deleteRows : function(dm, _84, _85) {
						if (dm.getRowCount() < 1) {
							this.fireEvent("beforerefresh", this);
							this.mainBody.update("");
							this.lockedBody.update("");
							this.fireEvent("refresh", this);
						} else {
							this.fireEvent("beforerowsdeleted", this, _84, _85);
							var bt = this.getBodyTable();
							var _87 = bt.firstChild;
							var _88 = bt.rows;
							for ( var _89 = _84; _89 <= _85; _89++) {
								_87.removeChild(_88[_84]);
							}
							this.stripeRows(_84);
							this.fireEvent("rowsdeleted", this, _84, _85);
						}
					},
					updateRows : function(_8a, _8b, _8c) {
						var s = this.getScrollState();
						this.refresh();
						this.restoreScroll(s);
					},
					handleSort : function(_8e, _8f, _90, _91) {
						if (!_91) {
							this.refresh();
						}
						this.updateHeaderSortState();
					},
					getScrollState : function() {
						var sb = this.scroller.dom;
						return {
							left : sb.scrollLeft,
							top : sb.scrollTop
						};
					},
					stripeRows : function(_93) {
						if (!this.grid.stripeRows || this.ds.getCount() < 1) {
							return;
						}
						_93 = _93 || 0;
						var _94 = this.getBodyTable().rows;
						var _95 = this.getLockedTable().rows;
						var cls = " x-grid-row-alt ";
						for ( var i = _93, len = _94.length; i < len; i++) {
							var row = _94[i], _9a = _95[i];
							var _9b = ((i + 1) % 2 == 0);
							var _9c = (" " + row.className + " ").indexOf(cls) != -1;
							if (_9b == _9c) {
								continue;
							}
							if (_9b) {
								row.className += " x-grid-row-alt";
							} else {
								row.className = row.className.replace(
										"x-grid-row-alt", "");
							}
							if (_9a) {
								_9a.className = row.className;
							}
						}
					},
					restoreScroll : function(_9d) {
						var sb = this.scroller.dom;
						sb.scrollLeft = _9d.left;
						sb.scrollTop = _9d.top;
						this.syncScroll();
					},
					syncScroll : function() {
						var sb = this.scroller.dom;
						var sh = this.mainHd.dom;
						var bs = this.mainBody.dom;
						var lv = this.lockedBody.dom;
						sh.scrollLeft = bs.scrollLeft = sb.scrollLeft;
						lv.scrollTop = bs.scrollTop = sb.scrollTop;
					},
					handleScroll : function(e) {
						this.syncScroll();
						var sb = this.scroller.dom;
						this.grid.fireEvent("bodyscroll", sb.scrollLeft,
								sb.scrollTop);
						e.stopEvent();
					},
					handleWheel : function(e) {
						var d = e.getWheelDelta();
						this.scroller.dom.scrollTop -= d * 22;
						this.lockedBody.dom.scrollTop = this.mainBody.dom.scrollTop = this.scroller.dom.scrollTop;
						e.stopEvent();
					},
					renderRows : function(_a7, _a8) {
						var g = this.grid, cm = g.colModel, ds = g.dataSource, _ac = g.stripeRows;
						var _ad = cm.getColumnCount();
						if (ds.getCount() < 1) {
							return [ "", "" ];
						}
						var cs = [];
						for ( var i = 0; i < _ad; i++) {
							var _b0 = cm.getDataIndex(i);
							cs[i] = {
								name : typeof _b0 == "undefined" ? ds.fields
										.get(i).name : _b0,
								renderer : cm.getRenderer(i),
								id : cm.getColumnId(i),
								locked : cm.isLocked(i)
							};
						}
						_a7 = _a7 || 0;
						_a8 = typeof _a8 == "undefined" ? ds.getCount() - 1
								: _a8;
						var rs = ds.getRange(_a7, _a8);
						return this.doRender(cs, rs, ds, _a7, _ad, _ac);
					},
					doRender : Ext.isGecko ? function(cs, rs, ds, _b5, _b6, _b7) {
						var ts = this.templates, ct = ts.cell, rt = ts.row;
						var buf = "", _bc = "", cb, lcb, c, p = {}, rp = {}, r;
						for ( var j = 0, len = rs.length; j < len; j++) {
							r = rs[j], cb = "", lcb = "", rowIndex = (j + _b5);
							for ( var i = 0; i < _b6; i++) {
								c = cs[i];
								p.cellId = "x-grid-cell-" + rowIndex + "-" + i;
								p.id = c.id;
								p.css = p.attr = "";
								p.value = c.renderer(r.data[c.name], p, r,
										rowIndex, i, ds);
								if (p.value == undefined || p.value === "") {
									p.value = "&#160;";
								}
								if (r.dirty
										&& typeof r.modified[c.name] !== "undefined") {
									p.css += p.css ? " x-grid-dirty-cell"
											: "x-grid-dirty-cell";
								}
								var _c6 = ct.apply(p);
								if (!c.locked) {
									cb += _c6;
								} else {
									lcb += _c6;
								}
							}
							var alt = [];
							if (_b7 && ((rowIndex + 1) % 2 == 0)) {
								alt[0] = "x-grid-row-alt";
							}
							if (r.dirty) {
								alt[1] = " x-grid-dirty-row";
							}
							rp.cells = lcb;
							if (this.getRowClass) {
								alt[2] = this.getRowClass(r, rowIndex);
							}
							rp.alt = alt.join(" ");
							_bc += rt.apply(rp);
							rp.cells = cb;
							buf += rt.apply(rp);
						}
						return [ _bc, buf ];
					}
							: function(cs, rs, ds, _cb, _cc, _cd) {
								var ts = this.templates, ct = ts.cell, rt = ts.row;
								var buf = [], _d2 = [], cb, lcb, c, p = {}, rp = {}, r;
								for ( var j = 0, len = rs.length; j < len; j++) {
									r = rs[j], cb = [], lcb = [],
											rowIndex = (j + _cb);
									for ( var i = 0; i < _cc; i++) {
										c = cs[i];
										p.cellId = "x-grid-cell-" + rowIndex
												+ "-" + i;
										p.id = c.id;
										p.css = p.attr = "";
										p.value = c.renderer(r.data[c.name], p,
												r, rowIndex, i, ds);
										if (p.value == undefined
												|| p.value === "") {
											p.value = "&#160;";
										}
										if (r.dirty
												&& typeof r.modified[c.name] !== "undefined") {
											p.css += p.css ? " x-grid-dirty-cell"
													: "x-grid-dirty-cell";
										}
										var _dc = ct.apply(p);
										if (!c.locked) {
											cb[cb.length] = _dc;
										} else {
											lcb[lcb.length] = _dc;
										}
									}
									var alt = [];
									if (_cd && ((rowIndex + 1) % 2 == 0)) {
										alt[0] = "x-grid-row-alt";
									}
									if (r.dirty) {
										alt[1] = " x-grid-dirty-row";
									}
									rp.cells = lcb;
									if (this.getRowClass) {
										alt[2] = this.getRowClass(r, rowIndex);
									}
									rp.alt = alt.join(" ");
									rp.cells = lcb.join("");
									_d2[_d2.length] = rt.apply(rp);
									rp.cells = cb.join("");
									buf[buf.length] = rt.apply(rp);
								}
								return [ _d2.join(""), buf.join("") ];
							},
					renderBody : function() {
						var _de = this.renderRows();
						var bt = this.templates.body;
						return [ bt.apply( {
							rows : _de[0]
						}), bt.apply( {
							rows : _de[1]
						}) ];
					},
					refresh : function(_e0) {
						this.fireEvent("beforerefresh", this);
						this.grid.stopEditing();
						var _e1 = this.renderBody();
						this.lockedBody.update(_e1[0]);
						this.mainBody.update(_e1[1]);
						if (_e0 === true) {
							this.updateHeaders();
							this.updateColumns();
							this.updateSplitters();
							this.updateHeaderSortState();
						}
						this.syncRowHeights();
						this.layout();
						this.fireEvent("refresh", this);
					},
					handleColumnMove : function(cm, _e3, _e4) {
						this.indexMap = null;
						var s = this.getScrollState();
						this.refresh(true);
						this.restoreScroll(s);
						this.afterMove(_e4);
					},
					afterMove : function(_e6) {
						if (this.enableMoveAnim && Ext.enableFx) {
							this.fly(this.getHeaderCell(_e6).firstChild)
									.highlight(this.hlColor);
						}
					},
					updateCell : function(dm, _e8, _e9) {
						var _ea = this.getColumnIndexByDataIndex(_e9);
						if (typeof _ea == "undefined") {
							return;
						}
						var cm = this.grid.colModel;
						var _ec = this.getCell(_e8, _ea);
						var _ed = this.getCellText(_e8, _ea);
						var p = {
							cellId : "x-grid-cell-" + _e8 + "-" + _ea,
							id : cm.getColumnId(_ea),
							css : _ea == cm.getColumnCount() - 1 ? "x-grid-col-last"
									: ""
						};
						var _ef = cm.getRenderer(_ea);
						var val = _ef(dm.getValueAt(_e8, _e9), p, _e8, _ea, dm);
						if (typeof val == "undefined" || val === "") {
							val = "&#160;";
						}
						_ed.innerHTML = val;
						_ec.className = this.cellClass + " " + p.cellId + " "
								+ p.css;
						this.syncRowHeights(_e8, _e8);
					},
					calcColumnWidth : function(_f1, _f2) {
						var _f3 = 0;
						if (this.grid.autoSizeHeaders) {
							var h = this.getHeaderCellMeasure(_f1);
							_f3 = Math.max(_f3, h.scrollWidth);
						}
						var tb, _f6;
						if (this.cm.isLocked(_f1)) {
							tb = this.getLockedTable();
							_f6 = _f1;
						} else {
							tb = this.getBodyTable();
							_f6 = _f1 - this.cm.getLockedCount();
						}
						if (tb && tb.rows) {
							var _f7 = tb.rows;
							var _f8 = Math.min(_f2 || _f7.length, _f7.length);
							for ( var i = 0; i < _f8; i++) {
								var _fa = _f7[i].childNodes[_f6].firstChild;
								_f3 = Math.max(_f3, _fa.scrollWidth);
							}
						}
						return _f3 + 5;
					},
					autoSizeColumn : function(_fb, _fc, _fd) {
						if (this.cm.isHidden(_fb)) {
							return;
						}
						if (_fc) {
							var cid = this.cm.getColumnId(_fb);
							this.css.updateRule(this.colSelector + cid,
									"width", this.grid.minColumnWidth + "px");
							if (this.grid.autoSizeHeaders) {
								this.css.updateRule(this.hdSelector + cid,
										"width", this.grid.minColumnWidth
												+ "px");
							}
						}
						var _ff = this.calcColumnWidth(_fb);
						this.cm.setColumnWidth(_fb, Math.max(
								this.grid.minColumnWidth, _ff), _fd);
						if (!_fd) {
							this.grid.fireEvent("columnresize", _fb, _ff);
						}
					},
					autoSizeColumns : function() {
						var cm = this.grid.colModel;
						var _101 = cm.getColumnCount();
						for ( var i = 0; i < _101; i++) {
							this.autoSizeColumn(i, true, true);
						}
						if (cm.getTotalWidth() < this.scroller.dom.clientWidth) {
							this.fitColumns();
						} else {
							this.updateColumns();
							this.layout();
						}
					},
					fitColumns : function(_103) {
						var cm = this.grid.colModel;
						var _105 = cm.getColumnCount();
						var cols = [];
						var _107 = 0;
						var i, w;
						for (i = 0; i < _105; i++) {
							if (!cm.isHidden(i) && !cm.isFixed(i)) {
								w = cm.getColumnWidth(i);
								cols.push(i);
								cols.push(w);
								_107 += w;
							}
						}
						var _10a = Math.min(this.scroller.dom.clientWidth,
								this.el.getWidth());
						if (_103) {
							_10a -= 17;
						}
						var frac = (_10a - cm.getTotalWidth()) / _107;
						while (cols.length) {
							w = cols.pop();
							i = cols.pop();
							cm
									.setColumnWidth(i,
											Math.floor(w + w * frac), true);
						}
						this.updateColumns();
						this.layout();
					},
					onRowSelect : function(_10c) {
						var row = this.getRowComposite(_10c);
						row.addClass("x-grid-row-selected");
					},
					onRowDeselect : function(_10e) {
						var row = this.getRowComposite(_10e);
						row.removeClass("x-grid-row-selected");
					},
					onCellSelect : function(row, col) {
						var cell = this.getCell(row, col);
						if (cell) {
							Ext.fly(cell).addClass("x-grid-cell-selected");
						}
					},
					onCellDeselect : function(row, col) {
						var cell = this.getCell(row, col);
						if (cell) {
							Ext.fly(cell).removeClass("x-grid-cell-selected");
						}
					},
					updateHeaderSortState : function() {
						var _116 = this.ds.getSortState();
						if (!_116) {
							return;
						}
						this.sortState = _116;
						var _117 = this.cm.findColumnIndex(_116.field);
						if (_117 != -1) {
							var _118 = _116.direction;
							var sc = this.sortClasses;
							var hds = this.el.select(this.headerSelector)
									.removeClass(sc);
							hds.item(_117).addClass(sc[_118 == "DESC" ? 1 : 0]);
						}
					},
					handleHeaderClick : function(g, _11c) {
						if (this.headersDisabled) {
							return;
						}
						var dm = g.dataSource, cm = g.colModel;
						if (!cm.isSortable(_11c)) {
							return;
						}
						g.stopEditing();
						dm.sort(cm.getDataIndex(_11c));
					},
					destroy : function() {
						if (this.colMenu) {
							this.colMenu.removeAll();
							Ext.menu.MenuMgr.unregister(this.colMenu);
							this.colMenu.getEl().remove();
							delete this.colMenu;
						}
						if (this.hmenu) {
							this.hmenu.removeAll();
							Ext.menu.MenuMgr.unregister(this.hmenu);
							this.hmenu.getEl().remove();
							delete this.hmenu;
						}
						if (this.grid.enableColumnMove) {
							var dds = Ext.dd.DDM.ids["gridHeader"
									+ this.grid.container.id];
							if (dds) {
								for ( var dd in dds) {
									if (!dds[dd].config.isTarget
											&& dds[dd].dragElId) {
										var elid = dds[dd].dragElId;
										dds[dd].unreg();
										Ext.get(elid).remove();
									} else {
										if (dds[dd].config.isTarget) {
											dds[dd].proxyTop.remove();
											dds[dd].proxyBottom.remove();
											dds[dd].unreg();
										}
									}
									if (Ext.dd.DDM.locationCache[dd]) {
										delete Ext.dd.DDM.locationCache[dd];
									}
								}
								delete Ext.dd.DDM.ids["gridHeader"
										+ this.grid.container.id];
							}
						}
						this.bind(null, null);
						Ext.EventManager.removeResizeListener(
								this.onWindowResize, this);
					},
					handleLockChange : function() {
						this.refresh(true);
					},
					onDenyColumnLock : function() {
					},
					onDenyColumnHide : function() {
					},
					handleHdMenuClick : function(item) {
						var _123 = this.hdCtxIndex;
						var cm = this.cm, ds = this.ds;
						switch (item.id) {
						case "asc":
							ds.sort(cm.getDataIndex(_123), "ASC");
							break;
						case "desc":
							ds.sort(cm.getDataIndex(_123), "DESC");
							break;
						case "lock":
							var lc = cm.getLockedCount();
							if (cm.getColumnCount(true) <= lc + 1) {
								this.onDenyColumnLock();
								return;
							}
							if (lc != _123) {
								cm.setLocked(_123, true, true);
								cm.moveColumn(_123, lc);
								this.grid.fireEvent("columnmove", _123, lc);
							} else {
								cm.setLocked(_123, true);
							}
							break;
						case "unlock":
							var lc = cm.getLockedCount();
							if ((lc - 1) != _123) {
								cm.setLocked(_123, false, true);
								cm.moveColumn(_123, lc - 1);
								this.grid.fireEvent("columnmove", _123, lc - 1);
							} else {
								cm.setLocked(_123, false);
							}
							break;
						default:
							_123 = cm.getIndexById(item.id.substr(4));
							if (_123 != -1) {
								if (item.checked
										&& cm.getColumnCount(true) <= 1) {
									this.onDenyColumnHide();
									return false;
								}
								cm.setHidden(_123, item.checked);
							}
						}
						return true;
					},
					beforeColMenuShow : function() {
						var cm = this.cm, _128 = cm.getColumnCount();
						this.colMenu.removeAll();
						for ( var i = 0; i < _128; i++) {
							this.colMenu.add(new Ext.menu.CheckItem( {
								id : "col-" + cm.getColumnId(i),
								text : cm.getColumnHeader(i),
								checked : !cm.isHidden(i),
								hideOnClick : false
							}));
						}
					},
					handleHdCtx : function(g, _12b, e) {
						e.stopEvent();
						var hd = this.getHeaderCell(_12b);
						this.hdCtxIndex = _12b;
						var ms = this.hmenu.items, cm = this.cm;
						ms.get("asc").setDisabled(!cm.isSortable(_12b));
						ms.get("desc").setDisabled(!cm.isSortable(_12b));
						if (this.grid.enableColLock !== false) {
							ms.get("lock").setDisabled(cm.isLocked(_12b));
							ms.get("unlock").setDisabled(!cm.isLocked(_12b));
						}
						this.hmenu.show(hd, "tl-bl");
					},
					handleHdOver : function(e) {
						var hd = this.findHeaderCell(e.getTarget());
						if (hd && !this.headersDisabled) {
							if (this.grid.colModel.isSortable(this
									.getCellIndex(hd))) {
								this.fly(hd).addClass("x-grid-hd-over");
							}
						}
					},
					handleHdOut : function(e) {
						var hd = this.findHeaderCell(e.getTarget());
						if (hd) {
							this.fly(hd).removeClass("x-grid-hd-over");
						}
					},
					handleSplitDblClick : function(e, t) {
						var i = this.getCellIndex(t);
						if (this.grid.enableColumnResize !== false
								&& this.cm.isResizable(i)
								&& !this.cm.isFixed(i)) {
							this.autoSizeColumn(i, true);
							this.layout();
						}
					},
					render : function() {
						var cm = this.cm;
						var _138 = cm.getColumnCount();
						if (this.grid.monitorWindowResize === true) {
							Ext.EventManager.onWindowResize(
									this.onWindowResize, this, true);
						}
						var _139 = this.renderHeaders();
						var body = this.templates.body.apply( {
							rows : ""
						});
						var html = this.templates.master.apply( {
							lockedBody : body,
							body : body,
							lockedHeader : _139[0],
							header : _139[1]
						});
						this.updateColumns();
						this.grid.container.dom.innerHTML = html;
						this.initElements();
						this.scroller.on("scroll", this.handleScroll, this);
						this.lockedBody
								.on("mousewheel", this.handleWheel, this);
						this.mainBody.on("mousewheel", this.handleWheel, this);
						this.mainHd.on("mouseover", this.handleHdOver, this);
						this.mainHd.on("mouseout", this.handleHdOut, this);
						this.mainHd.on("dblclick", this.handleSplitDblClick,
								this, {
									delegate : "." + this.splitClass
								});
						this.lockedHd.on("mouseover", this.handleHdOver, this);
						this.lockedHd.on("mouseout", this.handleHdOut, this);
						this.lockedHd.on("dblclick", this.handleSplitDblClick,
								this, {
									delegate : "." + this.splitClass
								});
						if (this.grid.enableColumnResize !== false
								&& Ext.grid.SplitDragZone) {
							new Ext.grid.SplitDragZone(this.grid,
									this.lockedHd.dom, this.mainHd.dom);
						}
						this.updateSplitters();
						if (this.grid.enableColumnMove
								&& Ext.grid.HeaderDragZone) {
							new Ext.grid.HeaderDragZone(this.grid,
									this.lockedHd.dom, this.mainHd.dom);
							new Ext.grid.HeaderDropZone(this.grid,
									this.lockedHd.dom, this.mainHd.dom);
						}
						if (this.grid.enableCtxMenu !== false && Ext.menu.Menu) {
							this.hmenu = new Ext.menu.Menu( {
								id : this.grid.id + "-hctx"
							});
							this.hmenu.add( {
								id : "asc",
								text : this.sortAscText,
								cls : "xg-hmenu-sort-asc"
							}, {
								id : "desc",
								text : this.sortDescText,
								cls : "xg-hmenu-sort-desc"
							}, "separator");
							if (this.grid.enableColLock !== false) {
								this.hmenu.add( {
									id : "lock",
									text : this.lockText,
									cls : "xg-hmenu-lock"
								}, {
									id : "unlock",
									text : this.unlockText,
									cls : "xg-hmenu-unlock"
								}, "separator");
							}
							if (this.grid.enableColumnHide !== false) {
								this.colMenu = new Ext.menu.Menu( {
									id : this.grid.id + "-hcols-menu"
								});
								this.colMenu.on("beforeshow",
										this.beforeColMenuShow, this);
								this.colMenu.on("itemclick",
										this.handleHdMenuClick, this);
								this.hmenu.add( {
									id : "columns",
									text : this.columnsText,
									menu : this.colMenu
								});
							}
							this.hmenu.on("itemclick", this.handleHdMenuClick,
									this);
							this.grid.on("headercontextmenu", this.handleHdCtx,
									this);
						}
						if ((this.grid.enableDragDrop || this.grid.enableDrag)
								&& Ext.grid.GridDragZone) {
							var dd = new Ext.grid.GridDragZone(this.grid, {
								ddGroup : this.grid.ddGroup || "GridDD"
							});
						}
						for ( var i = 0; i < _138; i++) {
							if (cm.isHidden(i)) {
								this.hideColumn(i);
							}
							if (cm.config[i].align) {
								this.css.updateRule(this.colSelector + i,
										"textAlign", cm.config[i].align);
								this.css.updateRule(this.hdSelector + i,
										"textAlign", cm.config[i].align);
							}
						}
						this.updateHeaderSortState();
						this.beforeInitialResize();
						this.layout(true);
						this.renderPhase2.defer(1, this);
					},
					renderPhase2 : function() {
						this.refresh();
						if (this.grid.autoSizeColumns) {
							this.autoSizeColumns();
						}
					},
					beforeInitialResize : function() {
					},
					onColumnSplitterMoved : function(i, w) {
						this.userResized = true;
						var cm = this.grid.colModel;
						cm.setColumnWidth(i, w, true);
						var cid = cm.getColumnId(i);
						this.css.updateRule(this.colSelector + cid, "width",
								(w - this.borderWidth) + "px");
						this.css.updateRule(this.hdSelector + cid, "width",
								(w - this.borderWidth) + "px");
						this.updateSplitters();
						this.layout();
						this.grid.fireEvent("columnresize", i, w);
					},
					syncRowHeights : function(_142, _143) {
						if (this.grid.enableRowHeightSync === true
								&& this.cm.getLockedCount() > 0) {
							_142 = _142 || 0;
							var _144 = this.getBodyTable().rows;
							var _145 = this.getLockedTable().rows;
							var len = _144.length - 1;
							_143 = Math.min(_143 || len, len);
							for ( var i = _142; i <= _143; i++) {
								var m = _144[i], l = _145[i];
								var h = Math
										.max(m.offsetHeight, l.offsetHeight);
								m.style.height = l.style.height = h + "px";
							}
						}
					},
					layout : function(_14b, _14c) {
						var g = this.grid;
						var auto = g.autoHeight;
						var _14f = 16;
						var c = g.container, cm = this.cm, _152 = g.autoExpandColumn, gv = this;
						var _154 = this.cm.isLocked(0);
						var tbh = this.headerPanel.getHeight();
						var bbh = this.footerPanel.getHeight();
						if (auto) {
							var ch = this.getBodyTable().offsetHeight + tbh
									+ bbh + this.mainHd.getHeight();
							var _158 = ch + c.getBorderWidth("tb");
							if (g.maxHeight) {
								_158 = Math.min(g.maxHeight, _158);
							}
							c.setHeight(_158);
						}
						if (g.autoWidth) {
							c.setWidth(cm.getTotalWidth()
									+ c.getBorderWidth("lr"));
						}
						var s = this.scroller;
						var _15a = c.getSize(true);
						this.el.setSize(_15a.width, _15a.height);
						this.headerPanel.setWidth(_15a.width);
						this.footerPanel.setWidth(_15a.width);
						var _15b = this.mainHd.getHeight();
						var vw = _15a.width;
						var vh = _15a.height - (tbh + bbh);
						s.setSize(vw, vh);
						var bt = this.getBodyTable();
						var _15f = _154 ? Math.max(
								this.getLockedTable().offsetWidth,
								this.lockedHd.dom.firstChild.offsetWidth) : 0;
						var _160 = bt.offsetHeight;
						var _161 = _15f + bt.offsetWidth;
						var _162 = false, _163 = false;
						this.scrollSizer.setSize(_161, _160 + _15b);
						var lw = this.lockedWrap, mw = this.mainWrap;
						var lb = this.lockedBody, mb = this.mainBody;
						setTimeout(
								function() {
									var t = s.dom.offsetTop;
									var w = s.dom.clientWidth, h = s.dom.clientHeight;
									lw.setTop(t);
									lw.setSize(_15f, h);
									mw.setLeftTop(_15f, t);
									mw.setSize(w - _15f, h);
									lb.setHeight(h - _15b);
									mb.setHeight(h - _15b);
									if (_14c !== true && !gv.userResized
											&& _152) {
										var ci = cm.getIndexById(_152);
										var tw = cm.getTotalWidth(false);
										var _16d = cm.getColumnWidth(ci);
										var cw = Math
												.min(
														Math
																.max(
																		((w - tw)
																				+ _16d - 2)
																				- (w <= s.dom.offsetWidth ? 0
																						: 18),
																		g.autoExpandMin),
														g.autoExpandMax);
										if (_16d != cw) {
											cm.setColumnWidth(ci, cw, true);
											gv.css.updateRule(gv.colSelector
													+ _152, "width",
													(cw - gv.borderWidth)
															+ "px");
											gv.css.updateRule(gv.hdSelector
													+ _152, "width",
													(cw - gv.borderWidth)
															+ "px");
											gv.updateSplitters();
											gv.layout(false, true);
										}
									}
									if (_14b) {
										lw.show();
										mw.show();
									}
								}, 10);
					},
					onWindowResize : function() {
						if (!this.grid.monitorWindowResize
								|| this.grid.autoHeight) {
							return;
						}
						this.layout();
					},
					appendFooter : function(_16f) {
						return null;
					},
					sortAscText : "Sort Ascending",
					sortDescText : "Sort Descending",
					lockText : "Lock Column",
					unlockText : "Unlock Column",
					columnsText : "Columns"
				});

Ext.grid.HeaderDragZone = function(_1, hd, _3) {
	this.grid = _1;
	this.view = _1.getView();
	this.ddGroup = "gridHeader" + this.grid.container.id;
	Ext.grid.HeaderDragZone.superclass.constructor.call(this, hd);
	this.setHandleElId(Ext.id(hd));
	this.setOuterHandleElId(Ext.id(_3));
	this.scroll = false;
};
Ext.extend(Ext.grid.HeaderDragZone, Ext.dd.DragZone, {
	maxDragWidth : 120,
	getDragData : function(e) {
		var t = Ext.lib.Event.getTarget(e);
		var h = this.view.findHeaderCell(t);
		if (h) {
			return {
				ddel : h.firstChild,
				header : h
			};
		}
		return false;
	},
	onInitDrag : function(e) {
		var _8 = this.dragData.ddel.cloneNode(true);
		_8.style.width = Math.min(this.dragData.header.offsetWidth,
				this.maxDragWidth)
				+ "px";
		this.proxy.update(_8);
		return true;
	}
});
Ext.grid.HeaderDropZone = function(_9, hd, _b) {
	this.grid = _9;
	this.view = _9.getView();
	this.proxyTop = Ext.DomHelper.append(document.body, {
		tag : "div",
		cls : "col-move-top",
		html : "&#160;"
	}, true);
	this.proxyBottom = Ext.DomHelper.append(document.body, {
		tag : "div",
		cls : "col-move-bottom",
		html : "&#160;"
	}, true);
	this.proxyTop.hide = this.proxyBottom.hide = function() {
		this.setLeftTop(-100, -100);
		this.setStyle("visibility", "hidden");
	};
	this.ddGroup = "gridHeader" + this.grid.container.id;
	Ext.grid.HeaderDropZone.superclass.constructor.call(this, _9.container.dom);
};
Ext.extend(Ext.grid.HeaderDropZone, Ext.dd.DropZone, {
	proxyOffsets : [ -4, -9 ],
	fly : Ext.Element.fly,
	getTargetFromEvent : function(e) {
		var t = Ext.lib.Event.getTarget(e);
		var _e = this.view.findCellIndex(t);
		if (_e !== false) {
			return this.view.getHeaderCell(_e);
		}
	},
	nextVisible : function(h) {
		var v = this.view, cm = this.grid.colModel;
		h = h.nextSibling;
		while (h) {
			if (!cm.isHidden(v.getCellIndex(h))) {
				return h;
			}
			h = h.nextSibling;
		}
		return null;
	},
	prevVisible : function(h) {
		var v = this.view, cm = this.grid.colModel;
		h = h.prevSibling;
		while (h) {
			if (!cm.isHidden(v.getCellIndex(h))) {
				return h;
			}
			h = h.prevSibling;
		}
		return null;
	},
	positionIndicator : function(h, n, e) {
		var x = Ext.lib.Event.getPageX(e);
		var r = Ext.lib.Dom.getRegion(n.firstChild);
		var px, pt, py = r.top + this.proxyOffsets[1];
		if ((r.right - x) <= (r.right - r.left) / 2) {
			px = r.right + this.view.borderWidth;
			pt = "after";
		} else {
			px = r.left;
			pt = "before";
		}
		var _1d = this.view.getCellIndex(h);
		var _1e = this.view.getCellIndex(n);
		var _1f = this.grid.colModel.isLocked(_1e);
		if (pt == "after") {
			_1e++;
		}
		if (_1d < _1e) {
			_1e--;
		}
		if (_1d == _1e && (_1f == this.grid.colModel.isLocked(_1d))) {
			return false;
		}
		px += this.proxyOffsets[0];
		this.proxyTop.setLeftTop(px, py);
		this.proxyTop.show();
		if (!this.bottomOffset) {
			this.bottomOffset = this.view.mainHd.getHeight();
		}
		this.proxyBottom.setLeftTop(px, py + this.proxyTop.dom.offsetHeight
				+ this.bottomOffset);
		this.proxyBottom.show();
		return pt;
	},
	onNodeEnter : function(n, dd, e, _23) {
		if (_23.header != n) {
			this.positionIndicator(_23.header, n, e);
		}
	},
	onNodeOver : function(n, dd, e, _27) {
		var _28 = false;
		if (_27.header != n) {
			_28 = this.positionIndicator(_27.header, n, e);
		}
		if (!_28) {
			this.proxyTop.hide();
			this.proxyBottom.hide();
		}
		return _28 ? this.dropAllowed : this.dropNotAllowed;
	},
	onNodeOut : function(n, dd, e, _2c) {
		this.proxyTop.hide();
		this.proxyBottom.hide();
	},
	onNodeDrop : function(n, dd, e, _30) {
		var h = _30.header;
		if (h != n) {
			var cm = this.grid.colModel;
			var x = Ext.lib.Event.getPageX(e);
			var r = Ext.lib.Dom.getRegion(n.firstChild);
			var pt = (r.right - x) <= ((r.right - r.left) / 2) ? "after"
					: "before";
			var _36 = this.view.getCellIndex(h);
			var _37 = this.view.getCellIndex(n);
			var _38 = cm.isLocked(_37);
			if (pt == "after") {
				_37++;
			}
			if (_36 < _37) {
				_37--;
			}
			if (_36 == _37 && (_38 == cm.isLocked(_36))) {
				return false;
			}
			cm.setLocked(_36, _38, true);
			cm.moveColumn(_36, _37);
			this.grid.fireEvent("columnmove", _36, _37);
			return true;
		}
		return false;
	}
});

Ext.grid.SplitDragZone = function(_1, hd, _3) {
	this.grid = _1;
	this.view = _1.getView();
	this.proxy = this.view.resizeProxy;
	Ext.grid.SplitDragZone.superclass.constructor.call(this, hd,
			"gridSplitters" + this.grid.container.id, {
				dragElId : Ext.id(this.proxy.dom),
				resizeFrame : false
			});
	this.setHandleElId(Ext.id(hd));
	this.setOuterHandleElId(Ext.id(_3));
	this.scroll = false;
};
Ext.extend(Ext.grid.SplitDragZone, Ext.dd.DDProxy, {
	fly : Ext.Element.fly,
	b4StartDrag : function(x, y) {
		this.view.headersDisabled = true;
		this.proxy.setHeight(this.view.mainWrap.getHeight());
		var w = this.cm.getColumnWidth(this.cellIndex);
		var _7 = Math.max(w - this.grid.minColumnWidth, 0);
		this.resetConstraints();
		this.setXConstraint(_7, 1000);
		this.setYConstraint(0, 0);
		this.minX = x - _7;
		this.maxX = x + 1000;
		this.startPos = x;
		Ext.dd.DDProxy.prototype.b4StartDrag.call(this, x, y);
	},
	handleMouseDown : function(e) {
		ev = Ext.EventObject.setEvent(e);
		var t = this.fly(ev.getTarget());
		if (t.hasClass("x-grid-split")) {
			this.cellIndex = this.view.getCellIndex(t.dom);
			this.split = t.dom;
			this.cm = this.grid.colModel;
			if (this.cm.isResizable(this.cellIndex)
					&& !this.cm.isFixed(this.cellIndex)) {
				Ext.grid.SplitDragZone.superclass.handleMouseDown.apply(this,
						arguments);
			}
		}
	},
	endDrag : function(e) {
		this.view.headersDisabled = false;
		var _b = Math.max(this.minX, Ext.lib.Event.getPageX(e));
		var _c = _b - this.startPos;
		this.view.onColumnSplitterMoved(this.cellIndex, this.cm
				.getColumnWidth(this.cellIndex)
				+ _c);
	},
	autoOffset : function() {
		this.setDelta(0, 0);
	}
});

Ext.grid.GridDragZone = function(_1, _2) {
	this.view = _1.getView();
	Ext.grid.GridDragZone.superclass.constructor.call(this,
			this.view.lockedBody.dom, _2);
	this.setHandleElId(Ext.id(this.view.lockedBody.dom));
	this.setOuterHandleElId(Ext.id(this.view.mainBody.dom));
	this.scroll = false;
	this.grid = _1;
	this.ddel = document.createElement("div");
	this.ddel.className = "x-grid-dd-wrap";
};
Ext.extend(Ext.grid.GridDragZone, Ext.dd.DragZone, {
	ddGroup : "GridDD",
	getDragData : function(e) {
		var t = Ext.lib.Event.getTarget(e);
		var _5 = this.view.findRowIndex(t);
		if (_5 !== false) {
			var sm = this.grid.selModel;
			if (!sm.isSelected(_5) || e.hasModifier()) {
				sm.handleMouseDown(e, t);
			}
			return {
				grid : this.grid,
				ddel : this.ddel,
				rowIndex : _5,
				selections : sm.getSelections()
			};
		}
		return false;
	},
	onInitDrag : function(e) {
		var _8 = this.dragData;
		this.ddel.innerHTML = this.grid.getDragDropText();
		this.proxy.update(this.ddel);
	},
	afterRepair : function() {
		this.dragging = false;
	},
	getRepairXY : function(e, _a) {
		return false;
	},
	onEndDrag : function(_b, e) {
	},
	onValidDrop : function(dd, e, id) {
		this.hideProxy();
	},
	beforeInvalidDrop : function(e, id) {
	}
});

Ext.grid.ColumnModel = function(_1) {
	Ext.grid.ColumnModel.superclass.constructor.call(this);
	this.config = _1;
	this.lookup = {};
	for ( var i = 0, _3 = _1.length; i < _3; i++) {
		if (typeof _1[i].dataIndex == "undefined") {
			_1[i].dataIndex = i;
		}
		if (typeof _1[i].renderer == "string") {
			_1[i].renderer = Ext.util.Format[_1[i].renderer];
		}
		if (typeof _1[i].id == "undefined") {
			_1[i].id = i;
		}
		this.lookup[_1[i].id] = _1[i];
	}
	this.defaultWidth = 100;
	this.defaultSortable = false;
	this.events = {
		"widthchange" : true,
		"headerchange" : true,
		"hiddenchange" : true,
		"columnmoved" : true,
		"columnlockchange" : true
	};
	Ext.grid.ColumnModel.superclass.constructor.call(this);
};
Ext
		.extend(
				Ext.grid.ColumnModel,
				Ext.util.Observable,
				{
					getColumnId : function(_4) {
						return this.config[_4].id;
					},
					getColumnById : function(id) {
						return this.lookup[id];
					},
					getIndexById : function(id) {
						for ( var i = 0, _8 = this.config.length; i < _8; i++) {
							if (this.config[i].id == id) {
								return i;
							}
						}
						return -1;
					},
					moveColumn : function(_9, _a) {
						var c = this.config[_9];
						this.config.splice(_9, 1);
						this.config.splice(_a, 0, c);
						this.dataMap = null;
						this.fireEvent("columnmoved", this, _9, _a);
					},
					isLocked : function(_c) {
						return this.config[_c].locked === true;
					},
					setLocked : function(_d, _e, _f) {
						if (this.isLocked(_d) == _e) {
							return;
						}
						this.config[_d].locked = _e;
						if (!_f) {
							this.fireEvent("columnlockchange", this, _d, _e);
						}
					},
					getTotalLockedWidth : function() {
						var _10 = 0;
						for ( var i = 0; i < this.config.length; i++) {
							if (this.isLocked(i) && !this.isHidden(i)) {
								this.totalWidth += this.getColumnWidth(i);
							}
						}
						return _10;
					},
					getLockedCount : function() {
						for ( var i = 0, len = this.config.length; i < len; i++) {
							if (!this.isLocked(i)) {
								return i;
							}
						}
					},
					getColumnCount : function(_14) {
						if (_14 == true) {
							var c = 0;
							for ( var i = 0, len = this.config.length; i < len; i++) {
								if (!this.isHidden(i)) {
									c++;
								}
							}
							return c;
						}
						return this.config.length;
					},
					isSortable : function(col) {
						if (typeof this.config[col].sortable == "undefined") {
							return this.defaultSortable;
						}
						return this.config[col].sortable;
					},
					getRenderer : function(col) {
						if (!this.config[col].renderer) {
							return Ext.grid.ColumnModel.defaultRenderer;
						}
						return this.config[col].renderer;
					},
					setRenderer : function(col, fn) {
						this.config[col].renderer = fn;
					},
					getColumnWidth : function(col) {
						return this.config[col].width || this.defaultWidth;
					},
					setColumnWidth : function(col, _1e, _1f) {
						this.config[col].width = _1e;
						this.totalWidth = null;
						if (!_1f) {
							this.fireEvent("widthchange", this, col, _1e);
						}
					},
					getTotalWidth : function(_20) {
						if (!this.totalWidth) {
							this.totalWidth = 0;
							for ( var i = 0, len = this.config.length; i < len; i++) {
								if (_20 || !this.isHidden(i)) {
									this.totalWidth += this.getColumnWidth(i);
								}
							}
						}
						return this.totalWidth;
					},
					getColumnHeader : function(col) {
						return this.config[col].header;
					},
					setColumnHeader : function(col, _25) {
						this.config[col].header = _25;
						this.fireEvent("headerchange", this, col, _25);
					},
					getColumnTooltip : function(col) {
						return this.config[col].tooltip;
					},
					setColumnTooltip : function(col, _28) {
						this.config[col].tooltip = _28;
					},
					getDataIndex : function(col) {
						return this.config[col].dataIndex;
					},
					setDataIndex : function(col, _2b) {
						this.config[col].dataIndex = _2b;
					},
					findColumnIndex : function(_2c) {
						var c = this.config;
						for ( var i = 0, len = c.length; i < len; i++) {
							if (c[i].dataIndex == _2c) {
								return i;
							}
						}
						return -1;
					},
					isCellEditable : function(_30, _31) {
						return (this.config[_30].editable || (typeof this.config[_30].editable == "undefined" && this.config[_30].editor)) ? true
								: false;
					},
					getCellEditor : function(_32, _33) {
						return this.config[_32].editor;
					},
					setEditable : function(col, _35) {
						this.config[col].editable = _35;
					},
					isHidden : function(_36) {
						return this.config[_36].hidden;
					},
					isFixed : function(_37) {
						return this.config[_37].fixed;
					},
					isResizable : function(_38) {
						return this.config[_38].resizable !== false;
					},
					setHidden : function(_39, _3a) {
						this.config[_39].hidden = _3a;
						this.totalWidth = null;
						this.fireEvent("hiddenchange", this, _39, _3a);
					},
					setEditor : function(col, _3c) {
						this.config[col].editor = _3c;
					}
				});
Ext.grid.ColumnModel.defaultRenderer = function(_3d) {
	if (typeof _3d == "string" && _3d.length < 1) {
		return "&#160;";
	}
	return _3d;
};
Ext.grid.DefaultColumnModel = Ext.grid.ColumnModel;

Ext.grid.AbstractSelectionModel = function() {
	this.locked = false;
	Ext.grid.AbstractSelectionModel.superclass.constructor.call(this);
};
Ext.extend(Ext.grid.AbstractSelectionModel, Ext.util.Observable, {
	init : function(_1) {
		this.grid = _1;
		this.initEvents();
	},
	lock : function() {
		this.locked = true;
	},
	unlock : function() {
		this.locked = false;
	},
	isLocked : function() {
		return this.locked;
	}
});

Ext.grid.RowSelectionModel = function(_1) {
	Ext.apply(this, _1);
	this.selections = new Ext.util.MixedCollection(false, function(o) {
		return o.id;
	});
	this.last = false;
	this.lastActive = false;
	this.events = {
		"selectionchange" : true,
		"beforerowselect" : true,
		"rowselect" : true,
		"rowdeselect" : true
	};
	this.locked = false;
};
Ext
		.extend(
				Ext.grid.RowSelectionModel,
				Ext.grid.AbstractSelectionModel,
				{
					singleSelect : false,
					initEvents : function() {
						if (!this.grid.enableDragDrop && !this.grid.enableDrag) {
							this.grid.on("mousedown", this.handleMouseDown,
									this);
						}
						this.rowNav = new Ext.KeyNav(this.grid.container, {
							"up" : function(e) {
								if (!e.shiftKey) {
									this.selectPrevious(e.shiftKey);
								} else {
									if (this.last !== false
											&& this.lastActive !== false) {
										var _4 = this.last;
										this.selectRange(this.last,
												this.lastActive - 1);
										this.grid.getView().focusRow(
												this.lastActive);
										if (_4 !== false) {
											this.last = _4;
										}
									} else {
										this.selectFirstRow();
									}
								}
							},
							"down" : function(e) {
								if (!e.shiftKey) {
									this.selectNext(e.shiftKey);
								} else {
									if (this.last !== false
											&& this.lastActive !== false) {
										var _6 = this.last;
										this.selectRange(this.last,
												this.lastActive + 1);
										this.grid.getView().focusRow(
												this.lastActive);
										if (_6 !== false) {
											this.last = _6;
										}
									} else {
										this.selectFirstRow();
									}
								}
							},
							scope : this
						});
						var _7 = this.grid.view;
						_7.on("refresh", this.onRefresh, this);
						_7.on("rowupdated", this.onRowUpdated, this);
						_7.on("rowremoved", this.onRemove, this);
					},
					onRefresh : function() {
						var ds = this.grid.dataSource, i, v = this.grid.view;
						var s = this.selections;
						s.each(function(r) {
							if ((i = ds.indexOfId(r.id)) != -1) {
								v.onRowSelect(i);
							} else {
								s.remove(r);
							}
						});
					},
					onRemove : function(v, _e, r) {
						this.selections.remove(r);
					},
					onRowUpdated : function(v, _11, r) {
						if (this.isSelected(r)) {
							v.onRowSelect(_11);
						}
					},
					selectRecords : function(_13, _14) {
						if (!_14) {
							this.clearSelections();
						}
						var ds = this.grid.dataSource;
						for ( var i = 0, len = _13.length; i < len; i++) {
							this.selectRow(ds.indexOf(_13[i]), true);
						}
					},
					getCount : function() {
						return this.selections.length;
					},
					selectFirstRow : function() {
						this.selectRow(0);
					},
					selectLastRow : function(_18) {
						this
								.selectRow(this.grid.dataSource.getCount() - 1,
										_18);
					},
					selectNext : function(_19) {
						if (this.last !== false
								&& (this.last + 1) < this.grid.dataSource
										.getCount()) {
							this.selectRow(this.last + 1, _19);
							this.grid.getView().focusRow(this.last);
						}
					},
					selectPrevious : function(_1a) {
						if (this.last) {
							this.selectRow(this.last - 1, _1a);
							this.grid.getView().focusRow(this.last);
						}
					},
					getSelections : function() {
						return [].concat(this.selections.items);
					},
					getSelected : function() {
						return this.selections.itemAt(0);
					},
					clearSelections : function(_1b) {
						if (this.locked) {
							return;
						}
						if (_1b !== true) {
							var ds = this.grid.dataSource;
							var s = this.selections;
							s.each(function(r) {
								this.deselectRow(ds.indexOfId(r.id));
							}, this);
							s.clear();
						} else {
							this.selections.clear();
						}
						this.last = false;
					},
					selectAll : function() {
						if (this.locked) {
							return;
						}
						this.selections.clear();
						for ( var i = 0, len = this.grid.dataSource.getCount(); i < len; i++) {
							this.selectRow(i, true);
						}
					},
					hasSelection : function() {
						return this.selections.length > 0;
					},
					isSelected : function(_21) {
						var r = typeof _21 == "number" ? this.grid.dataSource
								.getAt(_21) : _21;
						return (r && this.selections.key(r.id) ? true : false);
					},
					isIdSelected : function(id) {
						return (this.selections.key(id) ? true : false);
					},
					handleMouseDown : function(e, t) {
						var _26 = this.grid.getView(), _27;
						if (this.isLocked()
								|| (_27 = _26.findRowIndex(t)) === false) {
							return;
						}
						if (e.shiftKey && this.last !== false) {
							var _28 = this.last;
							this.selectRange(_28, _27, e.ctrlKey);
							this.last = _28;
							_26.focusRow(_27);
						} else {
							var _29 = this.isSelected(_27);
							if (e.button != 0 && _29) {
								_26.focusRow(_27);
							} else {
								if (e.ctrlKey && _29) {
									this.deselectRow(_27);
								} else {
									this.selectRow(_27, e.button == 0
											&& (e.ctrlKey || e.shiftKey));
									_26.focusRow(_27);
								}
							}
						}
					},
					selectRows : function(_2a, _2b) {
						if (!_2b) {
							this.clearSelections();
						}
						for ( var i = 0, len = _2a.length; i < len; i++) {
							this.selectRow(_2a[i], true);
						}
					},
					selectRange : function(_2e, _2f, _30) {
						if (this.locked) {
							return;
						}
						if (!_30) {
							this.clearSelections();
						}
						if (_2e <= _2f) {
							for ( var i = _2e; i <= _2f; i++) {
								this.selectRow(i, true);
							}
						} else {
							for ( var i = _2e; i >= _2f; i--) {
								this.selectRow(i, true);
							}
						}
					},
					deselectRange : function(_32, _33, _34) {
						if (this.locked) {
							return;
						}
						for ( var i = _32; i <= _33; i++) {
							this.deselectRow(i, _34);
						}
					},
					selectRow : function(_36, _37, _38) {
						if (this.locked
								|| (_36 < 0 || _36 >= this.grid.dataSource
										.getCount())) {
							return;
						}
						if (this.fireEvent("beforerowselect", this, _36, _37) !== false) {
							if (!_37 || this.singleSelect) {
								this.clearSelections();
							}
							var r = this.grid.dataSource.getAt(_36);
							this.selections.add(r);
							this.last = this.lastActive = _36;
							if (!_38) {
								this.grid.getView().onRowSelect(_36);
							}
							this.fireEvent("rowselect", this, _36, r);
							this.fireEvent("selectionchange", this);
						}
					},
					deselectRow : function(_3a, _3b) {
						if (this.locked) {
							return;
						}
						if (this.last == _3a) {
							this.last = false;
						}
						if (this.lastActive == _3a) {
							this.lastActive = false;
						}
						var r = this.grid.dataSource.getAt(_3a);
						this.selections.remove(r);
						if (!_3b) {
							this.grid.getView().onRowDeselect(_3a);
						}
						this.fireEvent("rowdeselect", this, _3a);
						this.fireEvent("selectionchange", this);
					},
					restoreLast : function() {
						if (this._last) {
							this.last = this._last;
						}
					},
					acceptsNav : function(row, col, cm) {
						return !cm.isHidden(col) && cm.isCellEditable(col, row);
					},
					onEditorKey : function(_40, e) {
						var k = e.getKey(), _43, g = this.grid, ed = g.activeEditor;
						if (k == e.TAB) {
							ed.completeEdit();
							if (e.shiftKey) {
								_43 = g.walkCells(ed.row, ed.col - 1, -1,
										this.acceptsNav, this);
							} else {
								_43 = g.walkCells(ed.row, ed.col + 1, 1,
										this.acceptsNav, this);
							}
							e.stopEvent();
						} else {
							if (k == e.ENTER && !e.ctrlKey) {
								ed.completeEdit();
								if (e.shiftKey) {
									_43 = g.walkCells(ed.row - 1, ed.col, -1,
											this.acceptsNav, this);
								} else {
									_43 = g.walkCells(ed.row + 1, ed.col, 1,
											this.acceptsNav, this);
								}
								e.stopEvent();
							} else {
								if (k == e.ESC) {
									ed.cancelEdit();
								}
							}
						}
						if (_43) {
							g.startEditing(_43[0], _43[1]);
						}
					}
				});

Ext.grid.CellSelectionModel = function(_1) {
	Ext.apply(this, _1);
	this.selection = null;
	this.events = {
		"beforecellselect" : true,
		"cellselect" : true,
		"selectionchange" : true
	};
};
Ext
		.extend(
				Ext.grid.CellSelectionModel,
				Ext.grid.AbstractSelectionModel,
				{
					initEvents : function() {
						this.grid.on("mousedown", this.handleMouseDown, this);
						this.grid.container.on(Ext.isIE ? "keydown"
								: "keypress", this.handleKeyDown, this);
						var _2 = this.grid.view;
						_2.on("refresh", this.onViewChange, this);
						_2.on("rowupdated", this.onRowUpdated, this);
						_2.on("beforerowremoved", this.clearSelections, this);
						_2.on("beforerowsinserted", this.clearSelections, this);
						if (this.grid.isEditor) {
							this.grid.on("beforeedit", this.beforeEdit, this);
						}
					},
					beforeEdit : function(e) {
						this.select(e.row, e.column, false, true, e.record);
					},
					onRowUpdated : function(v, _5, r) {
						if (this.selection && this.selection.record == r) {
							v.onCellSelect(_5, this.selection.cell[1]);
						}
					},
					onViewChange : function() {
						this.clearSelections(true);
					},
					getSelectedCell : function() {
						return this.selection ? this.selection.cell : null;
					},
					clearSelections : function(_7) {
						var s = this.selection;
						if (s) {
							if (_7 !== true) {
								this.grid.view.onCellDeselect(s.cell[0],
										s.cell[1]);
							}
							this.selection = null;
							this.fireEvent("selectionchange", this, null);
						}
					},
					hasSelection : function() {
						return this.selection ? true : false;
					},
					handleMouseDown : function(e, t) {
						var v = this.grid.getView();
						if (this.isLocked()) {
							return;
						}
						var _c = v.findRowIndex(t);
						var _d = v.findCellIndex(t);
						if (_c !== false && _d !== false) {
							this.select(_c, _d);
						}
					},
					select : function(_e, _f, _10, _11, r) {
						if (this.fireEvent("beforecellselect", this, _e, _f) !== false) {
							this.clearSelections();
							r = r || this.grid.dataSource.getAt(_e);
							this.selection = {
								record : r,
								cell : [ _e, _f ]
							};
							if (!_10) {
								var v = this.grid.getView();
								v.onCellSelect(_e, _f);
								if (_11 !== true) {
									v.focusCell(_e, _f);
								}
							}
							this.fireEvent("cellselect", this, _e, _f);
							this.fireEvent("selectionchange", this,
									this.selection);
						}
					},
					isSelectable : function(_14, _15, cm) {
						return !cm.isHidden(_15);
					},
					handleKeyDown : function(e) {
						if (!e.isNavKeyPress()) {
							return;
						}
						var g = this.grid, s = this.selection;
						if (!s) {
							e.stopEvent();
							var _1a = g.walkCells(0, 0, 1, this.isSelectable,
									this);
							if (_1a) {
								this.select(_1a[0], _1a[1]);
							}
							return;
						}
						var sm = this;
						var _1c = function(row, col, _1f) {
							return g.walkCells(row, col, _1f, sm.isSelectable,
									sm);
						};
						var k = e.getKey(), r = s.cell[0], c = s.cell[1];
						var _23;
						switch (k) {
						case e.TAB:
							if (e.shiftKey) {
								_23 = _1c(r, c - 1, -1);
							} else {
								_23 = _1c(r, c + 1, 1);
							}
							break;
						case e.DOWN:
							_23 = _1c(r + 1, c, 1);
							break;
						case e.UP:
							_23 = _1c(r - 1, c, -1);
							break;
						case e.RIGHT:
							_23 = _1c(r, c + 1, 1);
							break;
						case e.LEFT:
							_23 = _1c(r, c - 1, -1);
							break;
						case e.ENTER:
							if (g.isEditor && !g.editing) {
								g.startEditing(r, c);
								e.stopEvent();
								return;
							}
							break;
						}
						if (_23) {
							this.select(_23[0], _23[1]);
							e.stopEvent();
						}
					},
					acceptsNav : function(row, col, cm) {
						return !cm.isHidden(col) && cm.isCellEditable(col, row);
					},
					onEditorKey : function(_27, e) {
						var k = e.getKey(), _2a, g = this.grid, ed = g.activeEditor;
						if (k == e.TAB) {
							if (e.shiftKey) {
								_2a = g.walkCells(ed.row, ed.col - 1, -1,
										this.acceptsNav, this);
							} else {
								_2a = g.walkCells(ed.row, ed.col + 1, 1,
										this.acceptsNav, this);
							}
							e.stopEvent();
						} else {
							if (k == e.ENTER && !e.ctrlKey) {
								ed.completeEdit();
								e.stopEvent();
							} else {
								if (k == e.ESC) {
									ed.cancelEdit();
								}
							}
						}
						if (_2a) {
							g.startEditing(_2a[0], _2a[1]);
						}
					}
				});

Ext.grid.EditorGrid = function(_1, _2) {
	Ext.grid.EditorGrid.superclass.constructor.call(this, _1, _2);
	this.container.addClass("xedit-grid");
	if (!this.selModel) {
		this.selModel = new Ext.grid.CellSelectionModel();
	}
	this.activeEditor = null;
	Ext.apply(this.events, {
		"beforeedit" : true,
		"afteredit" : true,
		"validateedit" : true
	});
	this.on("bodyscroll", this.stopEditing, this);
	this.on(this.clicksToEdit == 1 ? "cellclick" : "celldblclick",
			this.onCellDblClick, this);
};
Ext.extend(Ext.grid.EditorGrid, Ext.grid.Grid, {
	isEditor : true,
	clicksToEdit : 2,
	trackMouseOver : false,
	onCellDblClick : function(g, _4, _5) {
		this.startEditing(_4, _5);
	},
	onEditComplete : function(ed, _7, _8) {
		this.editing = false;
		this.activeEditor = null;
		ed.un("specialkey", this.selModel.onEditorKey, this.selModel);
		if (String(_7) != String(_8)) {
			var r = ed.record;
			var _a = this.colModel.getDataIndex(ed.col);
			var e = {
				grid : this,
				record : r,
				field : _a,
				originalValue : _8,
				value : _7,
				row : ed.row,
				column : ed.col,
				cancel : false
			};
			if (this.fireEvent("validateedit", e) !== false && !e.cancel) {
				r.set(_a, _7);
				delete e.cancel;
				this.fireEvent("afteredit", e);
			}
		}
		this.view.focusCell(ed.row, ed.col);
	},
	startEditing : function(_c, _d) {
		this.stopEditing();
		if (this.colModel.isCellEditable(_d, _c)) {
			this.view.focusCell(_c, _d);
			var r = this.dataSource.getAt(_c);
			var _f = this.colModel.getDataIndex(_d);
			var e = {
				grid : this,
				record : r,
				field : _f,
				value : r.data[_f],
				row : _c,
				column : _d,
				cancel : false
			};
			if (this.fireEvent("beforeedit", e) !== false && !e.cancel) {
				this.editing = true;
				(function() {
					var ed = this.colModel.getCellEditor(_d, _c);
					ed.row = _c;
					ed.col = _d;
					ed.record = r;
					ed.on("complete", this.onEditComplete, this, {
						single : true
					});
					ed.on("specialkey", this.selModel.onEditorKey,
							this.selModel);
					this.activeEditor = ed;
					var v = r.data[_f];
					ed.startEdit(this.view.getCell(_c, _d), v);
				}).defer(50, this);
			}
		}
	},
	stopEditing : function() {
		if (this.activeEditor) {
			this.activeEditor.completeEdit();
		}
		this.activeEditor = null;
	}
});

Ext.grid.GridEditor = function(_1, _2) {
	Ext.grid.GridEditor.superclass.constructor.call(this, _1, _2);
};
Ext.extend(Ext.grid.GridEditor, Ext.Editor, {
	alignment : "tl-tl",
	autoSize : "width",
	hideEl : false,
	cls : "x-small-editor x-grid-editor",
	shim : false,
	shadow : "frame"
});

Ext.grid.PropertyRecord = Ext.data.Record.create( [ {
	name : "name",
	type : "string"
}, "value" ]);
Ext.grid.PropertyStore = function(_1, _2) {
	this.grid = _1;
	this.store = new Ext.data.Store( {
		recordType : Ext.grid.PropertyRecord
	});
	this.store.on("update", this.onUpdate, this);
	if (_2) {
		this.setSource(_2);
	}
	Ext.grid.PropertyStore.superclass.constructor.call(this);
};
Ext.extend(Ext.grid.PropertyStore, Ext.util.Observable,
		{
			setSource : function(o) {
				this.source = o;
				this.store.removeAll();
				var _4 = [];
				for ( var k in o) {
					if (this.isEditableValue(o[k])) {
						_4.push(new Ext.grid.PropertyRecord( {
							name : k,
							value : o[k]
						}, k));
					}
				}
				this.store.loadRecords( {
					records : _4
				}, {}, true);
			},
			onUpdate : function(ds, _7, _8) {
				if (_8 == Ext.data.Record.EDIT) {
					var v = _7.data["value"];
					var _a = _7.modified["value"];
					if (this.grid.fireEvent("beforepropertychange",
							this.source, _7.id, v, _a) !== false) {
						this.source[_7.id] = v;
						_7.commit();
						this.grid.fireEvent("propertychange", this.source,
								_7.id, v, _a);
					} else {
						_7.reject();
					}
				}
			},
			getProperty : function(_b) {
				return this.store.getAt(_b);
			},
			isEditableValue : function(_c) {
				if (_c && _c instanceof Date) {
					return true;
				} else {
					if (typeof _c == "object" || typeof _c == "function") {
						return false;
					}
				}
				return true;
			},
			setValue : function(_d, _e) {
				this.source[_d] = _e;
				this.store.getById(_d).set("value", _e);
			},
			getSource : function() {
				return this.source;
			}
		});
Ext.grid.PropertyColumnModel = function(_f, _10) {
	this.grid = _f;
	var g = Ext.grid;
	g.PropertyColumnModel.superclass.constructor.call(this, [ {
		header : this.nameText,
		sortable : true,
		dataIndex : "name",
		id : "name"
	}, {
		header : this.valueText,
		resizable : false,
		dataIndex : "value",
		id : "value"
	} ]);
	this.store = _10;
	this.bselect = Ext.DomHelper.append(document.body, {
		tag : "select",
		style : "display:none",
		cls : "x-grid-editor",
		children : [ {
			tag : "option",
			value : "true",
			html : "true"
		}, {
			tag : "option",
			value : "false",
			html : "false"
		} ]
	});
	Ext.id(this.bselect);
	var f = Ext.form;
	this.editors = {
		"date" : new g.GridEditor(new f.DateField( {
			selectOnFocus : true
		})),
		"string" : new g.GridEditor(new f.TextField( {
			selectOnFocus : true
		})),
		"number" : new g.GridEditor(new f.NumberField( {
			selectOnFocus : true,
			style : "text-align:left;"
		})),
		"boolean" : new g.GridEditor(new f.Field( {
			el : this.beselect,
			selectOnFocus : true
		}))
	};
	this.renderCellDelegate = this.renderCell.createDelegate(this);
	this.renderPropDelegate = this.renderProp.createDelegate(this);
};
Ext.extend(Ext.grid.PropertyColumnModel, Ext.grid.ColumnModel, {
	nameText : "Name",
	valueText : "Value",
	dateFormat : "m/j/Y",
	renderDate : function(_13) {
		return _13.dateFormat(this.dateFormat);
	},
	renderBool : function(_14) {
		return _14 ? "true" : "false";
	},
	isCellEditable : function(_15, _16) {
		return _15 == 1;
	},
	getRenderer : function(col) {
		return col == 1 ? this.renderCellDelegate : this.renderPropDelegate;
	},
	renderProp : function(v) {
		return this.getPropertyName(v);
	},
	renderCell : function(val) {
		var rv = val;
		if (val instanceof Date) {
			rv = this.renderDate(val);
		} else {
			if (typeof val == "boolean") {
				rv = this.renderBool(val);
			}
		}
		return Ext.util.Format.htmlEncode(rv);
	},
	getPropertyName : function(_1b) {
		var pn = this.grid.propertyNames;
		return pn && pn[_1b] ? pn[_1b] : _1b;
	},
	getCellEditor : function(_1d, _1e) {
		var p = this.store.getProperty(_1e);
		var n = p.data["name"], val = p.data["value"];
		if (this.grid.customEditors[n]) {
			return this.grid.customEditors[n];
		}
		if (val instanceof Date) {
			return this.editors["date"];
		} else {
			if (typeof val == "number") {
				return this.editors["number"];
			} else {
				if (typeof val == "boolean") {
					return this.editors["boolean"];
				} else {
					return this.editors["string"];
				}
			}
		}
	}
});
Ext.grid.PropertyGrid = function(_22, _23) {
	_23 = _23 || {};
	var _24 = new Ext.grid.PropertyStore(this);
	this.store = _24;
	var cm = new Ext.grid.PropertyColumnModel(this, _24);
	_24.store.sort("name", "ASC");
	Ext.grid.PropertyGrid.superclass.constructor.call(this, _22, Ext.apply( {
		ds : _24.store,
		cm : cm,
		enableColLock : false,
		enableColumnMove : false,
		stripeRows : false,
		trackMouseOver : false,
		clicksToEdit : 1
	}, _23));
	this.container.addClass("x-props-grid");
	this.lastEditRow = null;
	this.on("columnresize", this.onColumnResize, this);
	this.addEvents( {
		beforepropertychange : true,
		propertychange : true
	});
	this.customEditors = this.customEditors || {};
};
Ext.extend(Ext.grid.PropertyGrid, Ext.grid.EditorGrid, {
	render : function() {
		Ext.grid.PropertyGrid.superclass.render.call(this);
		this.autoSize.defer(100, this);
	},
	autoSize : function() {
		Ext.grid.PropertyGrid.superclass.autoSize.call(this);
		if (this.view) {
			this.view.fitColumns();
		}
	},
	onColumnResize : function() {
		this.colModel.setColumnWidth(1, this.container.getWidth(true)
				- this.colModel.getColumnWidth(0));
		this.autoSize();
	},
	setSource : function(_26) {
		this.store.setSource(_26);
	},
	getSource : function() {
		return this.store.getSource();
	}
});

Ext.LoadMask = function(el, _2) {
	this.el = Ext.get(el);
	Ext.apply(this, _2);
	if (this.store) {
		this.store.on("beforeload", this.onBeforeLoad, this);
		this.store.on("load", this.onLoad, this);
		this.store.on("loadexception", this.onLoad, this);
		this.removeMask = false;
	} else {
		var um = this.el.getUpdateManager();
		um.showLoadIndicator = false;
		um.on("beforeupdate", this.onBeforeLoad, this);
		um.on("update", this.onLoad, this);
		um.on("failure", this.onLoad, this);
		this.removeMask = true;
	}
};
Ext.LoadMask.prototype = {
	msg : "Loading...",
	msgCls : "x-mask-loading",
	disabled : false,
	disable : function() {
		this.disabled = true;
	},
	enable : function() {
		this.disabled = false;
	},
	onLoad : function() {
		this.el.unmask(this.removeMask);
	},
	onBeforeLoad : function() {
		if (!this.disabled) {
			this.el.mask(this.msg, this.msgCls);
		}
	},
	destroy : function() {
		if (this.store) {
			this.store.un("beforeload", this.onBeforeLoad, this);
			this.store.un("load", this.onLoad, this);
			this.store.un("loadexception", this.onLoad, this);
		} else {
			var um = this.el.getUpdateManager();
			um.un("beforeupdate", this.onBeforeLoad, this);
			um.un("update", this.onLoad, this);
			um.un("failure", this.onLoad, this);
		}
	}
};

Ext.debug = {
	init : function() {
		var CP = Ext.ContentPanel;
		var bd = Ext.get(document.body);
		var _3 = new Ext.LayoutDialog("x-debug-browser", {
			autoCreate : true,
			width : 800,
			height : 450,
			title : "Ext Debug Console &amp; Inspector",
			proxyDrag : true,
			shadow : true,
			center : {
				alwaysShowTabs : true
			},
			constraintoviewport : false
		});
		_3.el.swallowEvent("click");
		var _4 = _3.getLayout();
		_4.beginUpdate();
		var _5 = _4.add("center", new Ext.debug.InnerLayout("x-debug-console",
				400, {
					title : "Debug Console"
				}));
		var _6 = _4.add("center", new Ext.debug.InnerLayout(
				"x-debug-inspector", 250, {
					title : "DOM Inspector"
				}));
		var _7 = _5.add("east", new CP( {
			autoCreate : {
				tag : "div",
				children : [ {
					tag : "div"
				}, {
					tag : "textarea"
				} ]
			},
			fitContainer : true,
			fitToFrame : true,
			title : "Script Console",
			autoScroll : Ext.isGecko,
			setSize : function(w, h) {
				Ext.ContentPanel.prototype.setSize.call(this, w, h);
				if (Ext.isGecko && Ext.isStrict) {
					var s = this.adjustForComponents(w, h);
					this.resizeEl.setSize(s.width - 2, s.height - 2);
				}
			}
		}));
		var _b = _7.el;
		var _c = _b.child("textarea");
		_7.resizeEl = _c;
		var _d = _7.toolbar = new Ext.Toolbar(_b.child("div"));
		_d.add( {
			text : "Run",
			handler : function() {
				var s = _c.dom.value;
				if (_f.checked) {
					try {
						var rt = eval(s);
						Ext.debug.dump(rt === undefined ? "(no return)" : rt);
					} catch (e) {
						Ext.debug.log(e.message || e.descript);
					}
				} else {
					var rt = eval(s);
					Ext.debug.dump(rt === undefined ? "(no return)" : rt);
				}
			}
		}, {
			text : "Clear",
			handler : function() {
				_c.dom.value = "";
				_c.dom.focus();
			}
		});
		var _f = Ext.DomHelper.append(_d.el, {
			tag : "input",
			type : "checkbox",
			checked : "checked"
		});
		_f.checked = true;
		_d.add("-", _f, "Trap Errors");
		var _11 = new Ext.grid.PropertyGrid(bd.createChild(), {
			nameText : "Style",
			enableCtxMenu : false,
			enableColumnResize : false
		});
		var _12 = _6.add("east", new Ext.GridPanel(_11, {
			title : "(No element selected)"
		}));
		_11.render();
		_11.getView().mainHd.setDisplayed(false);
		_5.tbar.add( {
			text : "Clear",
			handler : function() {
				Ext.debug.console.jsonData = [];
				Ext.debug.console.refresh();
			}
		});
		var _13 = _6.main.getEl();
		var tb = _6.tbar;
		var _15, _16;
		function inspectListener(e, t) {
			if (!_15.contains(e.getPoint())) {
				findNode(t);
			}
		}
		function stopInspecting(e, t) {
			if (!_15.contains(e.getPoint())) {
				_1b.toggle(false);
				if (findNode(t) !== false) {
					e.stopEvent();
				}
			}
		}
		function stopInspectingEsc(e, t) {
			if (e.getKey() == e.ESC) {
				_1b.toggle(false);
			}
		}
		var _1b = tb.addButton( {
			text : "Inspect",
			enableToggle : true,
			pressed : false,
			toggleHandler : function(n, _1f) {
				var d = Ext.get(document);
				if (_1f) {
					d.on("mouseover", inspectListener, window, {
						buffer : 50
					});
					d.on("mousedown", stopInspecting);
					d.on("keydown", stopInspectingEsc);
					_15 = _3.el.getRegion();
					_16 = true;
				} else {
					d.un("mouseover", inspectListener);
					d.un("mousedown", stopInspecting);
					d.on("keydown", stopInspectingEsc);
					_16 = false;
					var n = _21.getSelectionModel().getSelectedNode();
					if (n && n.htmlNode) {
						onNodeSelect(_21, n, false);
					}
				}
			}
		});
		tb.addSeparator();
		var _22 = tb.addButton( {
			text : "Highlight Selection",
			enableToggle : true,
			pressed : false,
			toggleHandler : function(n, _24) {
				var n = _21.getSelectionModel().getSelectedNode();
				if (n && n.htmlNode) {
					n[_24 ? "frame" : "unframe"]();
				}
			}
		});
		tb.addSeparator();
		var _25 = tb.addButton( {
			text : "Refresh Children",
			disabled : true,
			handler : function() {
				var n = _21.getSelectionModel().getSelectedNode();
				if (n && n.reload) {
					n.reload();
				}
			}
		});
		tb.add("-", {
			text : "Collapse All",
			handler : function() {
				_21.root.collapse(true);
			}
		});
		_4.endUpdate();
		_4.getRegion("center").showPanel(0);
		_11.on("propertychange", function(s, _28, _29) {
			var _2a = _11.treeNode;
			if (_2b) {
				_2a.htmlNode.style[_28] = _29;
			} else {
				_2a.htmlNode[_28] = _29;
			}
			_2a.refresh(true);
		});
		var stb = new Ext.Toolbar(_11.view.getHeaderPanel(true));
		var _2d = stb.addButton( {
			text : "DOM Attributes",
			menu : {
				items : [ new Ext.menu.CheckItem( {
					id : "dom",
					text : "DOM Attributes",
					checked : true,
					group : "xdb-styles"
				}), new Ext.menu.CheckItem( {
					id : "styles",
					text : "CSS Properties",
					group : "xdb-styles"
				}) ]
			}
		});
		_2d.menu.on("click", function() {
			_2b = _2d.menu.items.get("styles").checked;
			_2e[_2b ? "show" : "hide"]();
			_2d.setText(_2b ? "CSS Properties" : "DOM Attributes");
			var n = _21.getSelectionModel().getSelectedNode();
			if (n) {
				onNodeSelect(_21, n);
			}
		});
		var _30 = stb.addButton( {
			text : "Add",
			disabled : true,
			handler : function() {
				Ext.MessageBox.prompt("Add Property", "Property Name:",
						function(btn, v) {
							var _33 = _11.store.store;
							if (btn == "ok" && v && !_33.getById(v)) {
								var r = new Ext.grid.PropertyRecord( {
									name : v,
									value : ""
								}, v);
								_33.add(r);
								_11.startEditing(_33.getCount() - 1, 1);
							}
						});
			}
		});
		var _2e = stb.addButton( {
			text : "Computed Styles",
			hidden : true,
			pressed : false,
			enableToggle : true,
			toggleHandler : function() {
				var n = _21.getSelectionModel().getSelectedNode();
				if (n) {
					onNodeSelect(_21, n);
				}
			}
		});
		var _2b = false, _36;
		var _37 = /^\s*$/;
		var _38 = Ext.util.Format.htmlEncode;
		var _39 = Ext.util.Format.ellipsis;
		var _3a = /\s?([a-z\-]*)\:([^;]*)(?:[;\s\n\r]*)/gi;
		function findNode(n) {
			if (!n || n.nodeType != 1 || n == document.body || n == document) {
				return false;
			}
			var pn = [ n ], p = n;
			while ((p = p.parentNode) && p.nodeType == 1
					&& p.tagName.toUpperCase() != "HTML") {
				pn.unshift(p);
			}
			var cn = _36;
			for ( var i = 0, len = pn.length; i < len; i++) {
				cn.expand();
				cn = cn.findChild("htmlNode", pn[i]);
				if (!cn) {
					return false;
				}
			}
			cn.select();
			var a = cn.ui.anchor;
			_13.dom.scrollTop = Math.max(0, a.offsetTop - 10);
			cn.highlight();
			return true;
		}
		function nodeTitle(n) {
			var s = n.tagName;
			if (n.id) {
				s += "#" + n.id;
			} else {
				if (n.className) {
					s += "." + n.className;
				}
			}
			return s;
		}
		function onNodeSelect(t, n, _46) {
			if (_46 && _46.unframe) {
				_46.unframe();
			}
			var _47 = {};
			if (n && n.htmlNode) {
				if (_22.pressed) {
					n.frame();
				}
				if (_16) {
					return;
				}
				_30.enable();
				_25.setDisabled(n.leaf);
				var dom = n.htmlNode;
				_12.setTitle(nodeTitle(dom));
				if (_2b && !_2e.pressed) {
					var s = dom.style ? dom.style.cssText : "";
					if (s) {
						var m;
						while ((m = _3a.exec(s)) != null) {
							_47[m[1].toLowerCase()] = m[2];
						}
					}
				} else {
					if (_2b) {
						var cl = Ext.debug.cssList;
						var s = dom.style, fly = Ext.fly(dom);
						if (s) {
							for ( var i = 0, len = cl.length; i < len; i++) {
								var st = cl[i];
								var v = s[st] || fly.getStyle(st);
								if (v != undefined && v !== null && v !== "") {
									_47[st] = v;
								}
							}
						}
					} else {
						for ( var a in dom) {
							var v = dom[a];
							if ((isNaN(a + 10))
									&& v != undefined
									&& v !== null
									&& v !== ""
									&& !(Ext.isGecko && a[0] == a[0]
											.toUpperCase())) {
								_47[a] = v;
							}
						}
					}
				}
			} else {
				if (_16) {
					return;
				}
				_30.disable();
				_25.disabled();
			}
			_11.setSource(_47);
			_11.treeNode = n;
			_11.view.fitColumns();
		}
		var _52 = "^(?:";
		var eds = _11.colModel.editors;
		for ( var _54 in eds) {
			_52 += eds[_54].id + "|";
		}
		Ext.each( [ _3.shim ? _3.shim.id : "noshim", _3.proxyDrag.id,
				_3.resizer.overlay.id, _3.resizer.proxy.id ], function(id) {
			_52 += id + "|";
		});
		_52 += _3.el.id;
		_52 += ")$";
		var _56 = new RegExp(_52);
		var _57 = new Ext.tree.TreeLoader();
		_57.load = function(n, cb) {
			var _5a = n.htmlNode == bd.dom;
			var cn = n.htmlNode.childNodes;
			for ( var i = 0, c; c = cn[i]; i++) {
				if (_5a && _56.test(c.id)) {
					continue;
				}
				if (c.nodeType == 1) {
					n.appendChild(new Ext.debug.HtmlNode(c));
				} else {
					if (c.nodeType == 3 && !_37.test(c.nodeValue)) {
						n.appendChild(new Ext.tree.TreeNode( {
							text : "<em>" + _39(_38(String(c.nodeValue)), 35)
									+ "</em>",
							cls : "x-tree-noicon"
						}));
					}
				}
			}
			cb();
		};
		var _21 = new Ext.tree.TreePanel(_13, {
			enableDD : false,
			loader : _57,
			lines : false,
			rootVisible : false,
			animate : false,
			hlColor : "ffff9c"
		});
		_21.getSelectionModel().on("selectionchange", onNodeSelect, null, {
			buffer : 250
		});
		var _5e = _21.setRootNode(new Ext.tree.TreeNode("Ext"));
		_36 = _5e.appendChild(new Ext.debug.HtmlNode(document
				.getElementsByTagName("html")[0]));
		_21.render();
		Ext.debug.console = new Ext.JsonView(_5.main.getEl(),
				"<pre><xmp>> {msg}</xmp></pre>");
		Ext.debug.console.jsonData = [];
		Ext.debug.dialog = _3;
	},
	show : function() {
		var d = Ext.debug;
		if (!d.dialog) {
			d.init();
		}
		if (!d.dialog.isVisible()) {
			d.dialog.show();
		}
	},
	hide : function() {
		if (Ext.debug.dialog) {
			Ext.debug.dialog.hide();
		}
	},
	log : function(_60, _61, etc) {
		Ext.debug.show();
		var m = "";
		for ( var i = 0, len = arguments.length; i < len; i++) {
			m += (i == 0 ? "" : ", ") + arguments[i];
		}
		var cn = Ext.debug.console;
		cn.jsonData.unshift( {
			msg : m
		});
		cn.refresh();
	},
	logf : function(_67, _68, _69, etc) {
		Ext.debug.log(String.format.apply(String, arguments));
	},
	dump : function(o) {
		if (typeof o == "string" || typeof o == "number"
				|| typeof o == "undefined" || o instanceof Date) {
			Ext.debug.log(o);
		} else {
			if (!o) {
				Ext.debug.log("null");
			} else {
				if (typeof o != "object") {
					Ext.debug.log("Unknown return type");
				} else {
					if (o instanceof Array) {
						Ext.debug.log("[" + o.join(",") + "]");
					} else {
						var b = [ "{\n" ];
						for ( var key in o) {
							var to = typeof o[key];
							if (to != "function" && to != "object") {
								b.push(String.format("  {0}: {1},\n", key,
										o[key]));
							}
						}
						var s = b.join("");
						if (s.length > 3) {
							s = s.substr(0, s.length - 2);
						}
						Ext.debug.log(s + "\n}");
					}
				}
			}
		}
	},
	_timers : {},
	time : function(_70) {
		_70 = _70 || "def";
		Ext._timers[_70] = new Date().getTime();
	},
	timeEnd : function(_71, _72) {
		var t = new Date().getTime();
		_71 = _71 || "def";
		var v = String.format("{0} ms", t - Ext._timers[_71]);
		Ext._timers[_71] = new Date().getTime();
		if (_72 !== false) {
			Ext.debug.log("Timer " + (_71 == "def" ? v : _71 + ": " + v));
		}
		return v;
	}
};
Ext.debug.HtmlNode = function() {
	var _75 = Ext.util.Format.htmlEncode;
	var _76 = Ext.util.Format.ellipsis;
	var _77 = /^\s*$/;
	var _78 = [ {
		n : "id",
		v : "id"
	}, {
		n : "className",
		v : "class"
	}, {
		n : "name",
		v : "name"
	}, {
		n : "type",
		v : "type"
	}, {
		n : "src",
		v : "src"
	}, {
		n : "href",
		v : "href"
	} ];
	function hasChild(n) {
		for ( var i = 0, c; c = n.childNodes[i]; i++) {
			if (c.nodeType == 1) {
				return true;
			}
		}
		return false;
	}
	function renderNode(n, _7d) {
		var tag = n.tagName.toLowerCase();
		var s = "&lt;" + tag;
		for ( var i = 0, len = _78.length; i < len; i++) {
			var a = _78[i];
			var v = n[a.n];
			if (v && !_77.test(v)) {
				s += " " + a.v + "=&quot;<i>" + _75(v) + "</i>&quot;";
			}
		}
		var _84 = n.style ? n.style.cssText : "";
		if (_84) {
			s += " style=&quot;<i>" + _75(_84.toLowerCase()) + "</i>&quot;";
		}
		if (_7d && n.childNodes.length > 0) {
			s += "&gt;<em>" + _76(_75(String(n.innerHTML)), 35) + "</em>&lt;/"
					+ tag + "&gt;";
		} else {
			if (_7d) {
				s += " /&gt;";
			} else {
				s += "&gt;";
			}
		}
		return s;
	}
	var _85 = function(n) {
		var _87 = !hasChild(n);
		this.htmlNode = n;
		this.tagName = n.tagName.toLowerCase();
		var _88 = {
			text : renderNode(n, _87),
			leaf : _87,
			cls : "x-tree-noicon"
		};
		_85.superclass.constructor.call(this, _88);
		this.attributes.htmlNode = n;
		if (!_87) {
			this.on("expand", this.onExpand, this);
			this.on("collapse", this.onCollapse, this);
		}
	};
	Ext.extend(_85, Ext.tree.AsyncTreeNode, {
		cls : "x-tree-noicon",
		preventHScroll : true,
		refresh : function(_89) {
			var _8a = !hasChild(this.htmlNode);
			this.setText(renderNode(this.htmlNode, _8a));
			if (_89) {
				Ext.fly(this.ui.textNode).highlight();
			}
		},
		onExpand : function() {
			if (!this.closeNode && this.parentNode) {
				this.closeNode = this.parentNode.insertBefore(
						new Ext.tree.TreeNode( {
							text : "&lt;/" + this.tagName + "&gt;",
							cls : "x-tree-noicon"
						}), this.nextSibling);
			} else {
				if (this.closeNode) {
					this.closeNode.ui.show();
				}
			}
		},
		onCollapse : function() {
			if (this.closeNode) {
				this.closeNode.ui.hide();
			}
		},
		render : function(_8b) {
			_85.superclass.render.call(this, _8b);
		},
		highlightNode : function() {
		},
		highlight : function() {
		},
		frame : function() {
			this.htmlNode.style.border = "1px solid #0000ff";
		},
		unframe : function() {
			this.htmlNode.style.border = "";
		}
	});
	return _85;
}();
Ext.debug.InnerLayout = function(id, w, cfg) {
	var el = Ext.DomHelper.append(document.body, {
		id : id
	});
	var _90 = new Ext.BorderLayout(el, {
		north : {
			initialSize : 28
		},
		center : {
			titlebar : false
		},
		east : {
			split : true,
			initialSize : w,
			titlebar : true
		}
	});
	Ext.debug.InnerLayout.superclass.constructor.call(this, _90, cfg);
	_90.beginUpdate();
	var _91 = _90.add("north", new Ext.ContentPanel( {
		autoCreate : true,
		fitToFrame : true
	}));
	this.main = _90.add("center", new Ext.ContentPanel( {
		autoCreate : true,
		fitToFrame : true,
		autoScroll : true
	}));
	this.tbar = new Ext.Toolbar(_91.el);
	var _92 = _91.resizeEl = _91.el.child("div.x-toolbar");
	_92.setStyle("border-bottom", "0 none");
	_90.endUpdate(true);
};
Ext.extend(Ext.debug.InnerLayout, Ext.NestedLayoutPanel, {
	add : function() {
		return this.layout.add.apply(this.layout, arguments);
	}
});
Ext.debug.cssList = [ "background-color", "border", "border-color",
		"border-spacing", "border-style", "border-top", "border-right",
		"border-bottom", "border-left", "border-top-color",
		"border-right-color", "border-bottom-color", "border-left-color",
		"border-top-width", "border-right-width", "border-bottom-width",
		"border-left-width", "border-width", "bottom", "color", "font-size",
		"font-size-adjust", "font-stretch", "font-style", "height", "left",
		"letter-spacing", "line-height", "margin", "margin-top",
		"margin-right", "margin-bottom", "margin-left", "marker-offset",
		"max-height", "max-width", "min-height", "min-width", "orphans",
		"outline", "outline-color", "outline-style", "outline-width",
		"overflow", "padding", "padding-top", "padding-right",
		"padding-bottom", "padding-left", "quotes", "right", "size",
		"text-indent", "top", "width", "word-spacing", "z-index", "opacity",
		"outline-offset" ];
if (typeof console == "undefined") {
	console = Ext.debug;
}
Ext.EventManager.on(window, "load", function() {
	Ext.get(document).on("keydown", function(e) {
		if (e.ctrlKey && e.shiftKey && e.getKey() == e.HOME) {
			Ext.debug.show();
		}
	});
});
Ext.print = Ext.log = Ext.debug.log;
Ext.printf = Ext.logf = Ext.debug.logf;
Ext.dump = Ext.debug.dump;
Ext.timer = Ext.debug.time;
Ext.timerEnd = Ext.debug.timeEnd;
