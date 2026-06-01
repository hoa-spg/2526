window.ns = {


    init: function(element, view) {
        element.onclick = async event => {
            let result = await view.$server.add(39, 3);
            alert("We got this from Java: " + result);
        }
    },

    toggle: function() {
        alert("Yuppieeee... this is Javascript ;-) ");
    }
}
