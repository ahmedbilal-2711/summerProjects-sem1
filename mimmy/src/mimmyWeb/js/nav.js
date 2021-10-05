let AUPage = document.getElementById("AUPage");
let HPage = document.getElementById("HPage");
let nav = document.getElementById("ul").children;
let navArr = Array.from(nav);
document.title="Mimmy.Home";
navArr.forEach((element)=>{
    // console.log(element.children);
    HPage.style.display="block";
    element.addEventListener("click",()=>{
        if(element.children[0].id==`H`){
            element.children[0].style.textDecoration='none';
            HPage.style.display="block";
            AUPage.style.display="none";
            document.title="Mimmy.Home";
            element.children[0].style.textDecoration="underline";
        }
        else if (element.children[0].id==`AU`) {
            element.children[0].style.textDecoration="none";
            AUPage.style.display="block";
            HPage.style.display="none";
            document.title="Mimmy.About Us";
            element.children[0].style.textDecoration="underline";
        }
    });
});
