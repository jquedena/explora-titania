/**
 * NumericUpDown - jQuery plugin
 * @author Iwasaki
 * http://code.google.com/p/yk-project/
 */
(function($) {
	$.fn.extend({
		NumericUpDown: function(opt) {
			return this.each(function() {
				if (!$(this).is("input")) return false;

				var txtB = $(this), thisID = txtB.attr("id");
				opt = $.extend({
					
					UpButtonImage:"../images/numericUpdown/BGupbutton.png",
					DownButtonImage:"../images/numericUpdown/BGdownbutton.png",
					hoverPosition: "0 -12px", activePosition: "0 -24px",
					max: null, min: null,
					interval: 1, timeInterval: 250,
					valChange:function(){}
				}, opt || {});

				var buttonBox = $(document.createElement("div"));
				buttonBox.css({"display": "inline","float":"left"});
				var UpBtn = $(document.createElement("div"));
				UpBtn.addClass("up").css("background-image", "URL('" + opt.UpButtonImage + "')");
				var DnBtn = $(document.createElement("div"));
				DnBtn.addClass("down").css("background-image", "URL('" + opt.DownButtonImage + "')");

				buttonBox.append(UpBtn).append(DnBtn);
				txtB.addClass("val").after(buttonBox).bind("change", check).bind("change", opt.valChange);
				
				function check(){
					var val = parseFloat(txtB.val());
					if (val != "" && !isNaN(val)){val = limitCheck(val);} 
					else val = 0;
					txtB.val(val);
				}
				function limitCheck(val) {
					if (opt.min != null && val < opt.min) val = opt.min;
					if (opt.max != null && val > opt.max) val = opt.max;
					return val;
				}
				function cntUp() {
					var val = txtB.val();
					if (!isNaN(val)) { val = parseFloat(val) + opt.interval; val = limitCheck(val); txtB.val(val).change(); }
				}
				function cntdwn() {
					var val = txtB.val();
					if (!isNaN(val)) { val = parseFloat(val) - opt.interval; val = limitCheck(val); txtB.val(val).change(); }
				}
				function over() { $(this).css("background-position", opt.hoverPosition); }
				function out() { $(this).css("background-position", "0 0"); }
				$.fn.mouseUp = function() {
					var btn = $(this);
					btn.unbind("mouseleave");
					(function() { $(document).one("mouseup",
						function(e) {
							clearTimeout(to);
							try{clearInterval(itv);}catch(er){}
							var tg = $(e.target);
							if (tg.is(".up") || tg.is(".down")) btn.css("background-position", opt.hoverPosition);
							else btn.css("background-position", "0 0");
							tg.bind("mouseleave", out);
						});})();
					return false;
				};

				//event
				UpBtn.hover(over, out).mousedown(function(e) {
					cntUp();
					$(this).mouseUp();
					to = setTimeout(function(){
						$(this).css("background-position", opt.activePosition);
						itv = setInterval(cntUp, opt.timeInterval);
					},500);
				});
				DnBtn.hover(over, out).mousedown(function() {
					cntdwn();
					$(this).mouseUp();
					to = setTimeout(function(){
						$(this).css("background-position", opt.activePosition);
						itv = setInterval(cntdwn, opt.timeInterval);
					},500);
				});
				txtB.keydown(function(e) {
				var code = e.keyCode;
				if (code >= 96 && code <= 105 || code >= 48 && code <= 57 || code == 13 || code == 9 || code == 8)// TenKey0-9_Check || Main0-9_Check || ENTER_Check || TAB_Check || BACKSPACE_Check 
					txtB.one("keyup", check);
				else return false;
				});
			});
		}
	});
})(jQuery);