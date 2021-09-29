let menu=document.querySelector("#logoBox>img");
let logo=document.getElementById("centerBox");

let menuBtn = document.getElementById("menuImg");
console.log(menuBtn.src);
menuBtn.addEventListener('click',()=>{
    if(menuBtn.src=="http://127.0.0.1:5500/images/menu.png"){
        menuBtn.src="../images/cross.png";
        document.getElementById("ul").style.transform="scale(1,1)";
        console.log("clicked");
        console.log(menuBtn.src);
    }
    else{
        menuBtn.src="../images/menu.png";
        document.getElementById("ul").style.transform="scale(0,1)";
        console.log("unclicked");
        console.log(menuBtn.src);
    }
});