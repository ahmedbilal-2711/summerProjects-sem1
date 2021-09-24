let signup = document.getElementById("signupA");
let box = document.getElementById("rSec");
let c=box.children;
signup.addEventListener('click',()=>{
    if(c[5].innerHTML=="Create Account"){
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(180deg)';
        c[0].innerHTML='Sign Up';
        c[0].style.color='rgb(109, 0, -67)';       
        c[1].style.color='rgb(109, 0, -67)';       
        c[5].style.color='rgb(109, 0, -67)';       
        c[4].innerHTML='Sign Up';
        c[5].innerHTML='Cancel';
        c[0].style.transform='rotateY(-180deg)';
        c[5].style.transform='rotateY(-180deg)';
        c[1].style.transform='rotateY(-180deg)';
        c[2].style.transform='rotateY(-180deg)';
        c[3].style.transform='rotateY(-180deg)';
        c[4].style.transform='rotateY(-180deg)';
    }
    else{
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(360deg)';
        c[0].innerHTML='Sign In';
        c[4].innerHTML='Sign In';
        c[5].innerHTML='Create Account';
        c[0].style.transform='rotateY(0deg)';
        c[5].style.transform='rotateY(0deg)';
        c[1].style.transform='rotateY(0deg)';
        c[2].style.transform='rotateY(0deg)';
        c[3].style.transform='rotateY(0deg)';
        c[4].style.transform='rotateY(0deg)';

    }
});
console.log(c);