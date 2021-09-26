let signup = document.getElementById("signupA");
let box = document.getElementById("rSec");
let c=box.children;
signup.addEventListener('click',()=>{
    if(c[5].innerHTML=="Create Account"){
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(180deg)';
        box.style.boxShadow='0px 0px 18px 14px rgba(80, 184, 89, 0.781)';
        box.style.backgroundColor=' rgba(158, 250, 189, 0.24)';
        c[0].innerHTML='Sign Up';       
        c[4].innerHTML='Sign Up';
        c[5].innerHTML='Cancel';
        Array.from(c).forEach(element => {
            element.style.transform='rotateY(-180deg)';
        });
    }
    else{
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(360deg)';
        box.style.boxShadow='0px 0px 18px 14px rgba(80, 135, 184, 0.781)';
        box.style.backgroundColor=' rgba(158, 207, 250, 0.24)';
        c[0].innerHTML='Sign In';
        c[4].innerHTML='Sign In';
        c[5].innerHTML='Create Account';
        Array.from(c).forEach(element => {
            element.style.transform='rotateY(0deg)';
        });
        
    }
});