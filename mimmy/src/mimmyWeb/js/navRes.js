let menu=document.querySelector("#logoBox>img");
let logo=document.getElementById("centerBox");

let imgLogo = document.createElement("img");
imgLogo.id="resLogo";
imgLogo.src='../images/logoMimmy.png';

    if(window.innerWidth<725){
        menu.src="../images/menu.png";
        document.getElementById("centerBox").appendChild(imgLogo,document.getElementById("ul"));
        document.getElementById("ul").style.display="none";
    }
    else{
        menu.src="../images/logoMimmy.png";
        document.getElementById("centerBox").style.display="block";
    }

let menuBtn = document.getElementById("logo");
menuBtn.addEventListener('click',()=>{

    if(menu.src=="http://127.0.0.1:5500/images/menu.png"){
        menu.src="../images/cross.png";
        document.getElementById("ul").style.display="block";
    }
    else{
        menu.src="../images/menu.png";
        document.getElementById("ul").style.display="none";
    }
});