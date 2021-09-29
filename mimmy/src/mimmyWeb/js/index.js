let signup = document.getElementById("signupA");
let box = document.getElementById("rSec");
let c=box.children;
console.log(c);
signup.addEventListener('click',()=>{
    if(c[4].innerHTML=="Create Account"){
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(180deg)';
        setTimeout(() => {
            box.style.boxShadow='0px 0px 18px 14px rgba(80, 184, 89, 0.781)';
            box.style.backgroundColor=' rgba(158, 250, 189, 0.24)';
            c[0].children[0].innerHTML='Sign Up';       
            c[4].innerHTML='Cancel';
            c[3].innerHTML="Sign Up";
            Array.from(c).forEach(element => {
                element.style.transform='rotateY(-180deg)';
            });
        }, 500);
    }
    else{
        box.style.transitionDuration="2000ms";
        box.style.transform='rotateY(360deg)';
        setTimeout(() => {
            box.style.boxShadow='0px 0px 18px 14px rgba(80, 135, 184, 0.781)';
            box.style.backgroundColor=' rgba(158, 207, 250, 0.24)';
            c[0].children[0].innerHTML='Sign In';
            c[3].innerHTML="Sign In";
            c[4].innerHTML='Create Account';
            Array.from(c).forEach(element => {
                element.style.transform='rotateY(0deg)';
            });
        }, 500);
    }
});