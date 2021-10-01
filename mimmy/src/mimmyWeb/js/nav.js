let AUPage = document.getElementById("AUPage");
let HPage = document.getElementById("HPage");
let nav = document.getElementById("ul").children;
let navArr = Array.from(nav);
navArr.forEach((element)=>{
    console.log(element.children[0].id);
    element.addEventListener("click",()=>{
        if(element.children[0].id==`H`){
            HPage.style.display="block";
            AUPage.style.display="none";
            console.log("HOme clicked");
        }
        else if (element.children[0].id==`AU`) {
            AUPage.style.display="block";
            HPage.style.display="none";
            console.log("Aboiut us clicked");
        }
    });
});
