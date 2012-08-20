/**
* @author jquedena
*/
var ListenerKey_LetterOnly = 0;
var ListenerKey_NumberOnly = 1;
var ListenerKey_LetterAndNumber = 2;
var ListenerKey_NotNumber = 3;
var ListenerKey_NumberSign = 4;
var ListenerKey_FakeReg = 5;
var ListenerKey_EmailReg = 6;

(function($) {
    $.fn.ListenerKey = function(TypeKey, FocusControl) {
        /**
         * LetterOnly =/[A-Za-z]/	::Solo acepta letras
         * NumberOnly = /\d/		::Solo acepta numeros
         * LetterAndNumber = /\w/	::Acepta numeros y letras
         * NotNumber = /\D/		::No acepta numeros
         * NumberSign = /[\d.-]/	::Numeros, punto y el signo -
         * FakeReg = /(.)\1{2,}/	::Texto Falso
         * EmailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/ ::Formato de correo electronico
         **/

        var LetterOnly = /[A-Za-z]/;
        var NumberOnly = /\d/;
        var LetterAndNumber = /\w/;
        var NotNumber = /\D/;
        var NumberSign = /[\d.-]/;
        var FakeReg = /(.)\1{2,}/;
        var EmailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

        function getTypeKey(_typeKey) {
            switch(_typeKey) {
                case 0:
                    return LetterOnly;
                case 1:
                    return NumberOnly;
                case 2:
                    return LetterAndNumber;
                case 3:
                    return NotNumber;
                case 4:
                    return NumberSign;
                case 5:
                    return FakeReg;
                case 6:
                    return EmailReg;                    
            }
        }

        return this.each( function() {
            $(this).data('typekey', TypeKey);
            $(this).data('focusControl', FocusControl);

            $(this).keypress( function(event) {
                _typeKey = $(this).data('typekey');
                _focusControl = $(this).data('focusControl');

                Key = event.which;

                if (Key == 8)
                    return true; // Tecla de Retroceso
                if (Key == 0)
                    return true; // Tecla de Tab
                if (Key == 13) {
                    // if(_focusControl.length > 0) $(_focusControl).focus();
                    if(_focusControl != null) _focusControl.focus();
                    return true; // Tecla de Enter
                }

                if(_typeKey >= 0 && _typeKey < 5) {
                    Char = String.fromCharCode(Key);
                    return getTypeKey(_typeKey).test(Char);
                } else {
                    return true;
                }

            });
        });
    };
})(jQuery);

