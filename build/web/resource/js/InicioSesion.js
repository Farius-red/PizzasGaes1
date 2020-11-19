const regexEmail = /\w+@\w+\.+[a-zA-Z]/;
const regexfiveTofifteencharacters = /\w{5,15}/;
const numeroCelular = /[0-9]{10,10}/;

let usuario = document.getElementById("usuario");
let formularioInicioSesion = document.getElementById("formularioInicioSesion");
let Contraseña = document.getElementById("contraseña");

function validacionEmail(e) {
    if(!regexEmail.test(usuario.value)){
        usuario.style.border ='1px solid red';
        e.preventDefault();
    }else{
        usuario.style.border ='';
        
    }
}

function validarPass(e) {
    if(!regexfiveTofifteencharacters.test(Contraseña.value)){
        Contraseña.style.border = '1px solid red';
        e.preventDefault();
    }else{
        Contraseña.style.border='';
    }
}

function validacionGeneral(e) {
    validacionEmail(e);
    validarPass(e);
    redireccionar();
}
formularioInicioSesion.addEventListener("submit",validacionGeneral);

let usuarioCliente = "Cliente@gmail.com";
let password = "123456";

let usuarioadmin = "Juan@gmail.com";
let passwordadmin = "123456";

let usuarioAux = "Sebastian@gmail.com";
let passwordAux = "123456";

let usuarioCajero = "Diego@gmail.com";
let passwordCajero = "123456";

let usuarioMesero = "Ana@gmail.com";
let passwordMesero = "123456";

function redireccionar(){
    if (usuarioCliente === usuario.value && password === Contraseña.value){
        window.open("./Pagina.xhtml");
    }else if(usuarioadmin === usuario.value && passwordadmin === Contraseña.value){
        window.open("./Perfil administrador.xhmtl");
    }else if(usuarioAux === usuario.value && passwordAux === Contraseña.value){
        window.open("./Intefaz");
    }else if(usuarioCajero === usuario.value && passwordCajero=== Contraseña.value){
        window.open("./Interfaz");
    }else if(usuarioMesero === usuario.value && passwordMesero === Contraseña.value){
        window.open("./Interfaz");
    }
}
