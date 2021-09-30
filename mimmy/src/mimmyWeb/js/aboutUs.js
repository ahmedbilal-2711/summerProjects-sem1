//Hover on dev amazing animation
let dev=document.getElementsByClassName("devImg");
let para=document.querySelectorAll(".detail");
let lm=document.getElementsByClassName("learn");
let aboutDev=document.createElement('p');
let text;
let a=Array.from(dev);
let lma=Array.from(lm);
text1=document.createTextNode(`Nabeel Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda molestiae quam enim quisquam
similique deserunt incidunt rerum cumque. Voluptas fuga, consequatur tenetur quibusdam accusantium
cumque sequi, a quo omnis doloribus nemo dolores facere ut est minus harum! Eos, iure in! In,
voluptatibus voluptates! Architecto delectus deserunt enim ea esse praesentium!`);
text2=document.createTextNode(`Maryam Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda molestiae quam enim quisquam
similique deserunt incidunt rerum cumque. Voluptas fuga, consequatur tenetur quibusdam accusantium
cumque sequi, a quo omnis doloribus nemo dolores facere ut est minus harum! Eos, iure in! In,
voluptatibus voluptates! Architecto delectus deserunt enim ea esse praesentium!`);
text3=document.createTextNode(`Ahmed Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda molestiae quam enim quisquam
similique deserunt incidunt rerum cumque. Voluptas fuga, consequatur tenetur quibusdam accusantium
cumque sequi, a quo omnis doloribus nemo dolores facere ut est minus harum! Eos, iure in! In,
voluptatibus voluptates! Architecto delectus deserunt enim ea esse praesentium!`);

lma.forEach(element => {
    element.addEventListener('click',()=>{
        if(element.innerHTML=="Learn More"){
            if(element.id=="learn1" && para[0].id=="abt1"){
                aboutDev.innerHTML=null;
                aboutDev.appendChild(text1);
                para[0].appendChild(aboutDev);
                para[0].lastChild.style.transform=("scale(0,0)");
                para[0].lastChild.style.textAlign=("center");
                setTimeout(() => {
                    para[0].lastChild.style.transformOrigin=("top");
                    para[0].lastChild.style.transform=("scale(1,1)");
                    para[0].lastChild.style.transitionDuration=("1000ms");
                }, 100);
            }
            else if(element.id=="learn2"  && para[1].id=="abt2"){
                aboutDev.innerHTML=null;
                aboutDev.appendChild(text2);
                para[1].appendChild(aboutDev);
                para[1].lastChild.style.transform=("scale(0,0)");
                para[1].lastChild.style.textAlign=("center");
                setTimeout(() => {
                    para[1].lastChild.style.transformOrigin=("top");
                    para[1].lastChild.style.transform=("scale(1,1)");
                    para[1].lastChild.style.transitionDuration=("1000ms");
                }, 100);
            }
            else{
                aboutDev.innerHTML=null;
                aboutDev.appendChild(text3);
                para[2].appendChild(aboutDev);
                para[2].lastChild.style.transform=("scale(0,0)");
                para[2].lastChild.style.textAlign=("center");
                setTimeout(() => {
                    para[2].lastChild.style.transformOrigin=("top");
                    para[2].lastChild.style.transform=("scale(1,1)");
                    para[2].lastChild.style.transitionDuration=("1000ms");
                }, 100);
            }
            element.innerHTML="Learn Less";
        }
        else{
            element.innerHTML="Learn More";
            if(element.id.includes("learn1")){
                para[0].removeChild(document.querySelector(".detail>p"));
            }
            else if(element.id.includes("learn2")){
                para[1].removeChild(document.querySelector(".detail>p"));
            }
            else{
                para[2].removeChild(document.querySelector(".detail>p"));
            }
        }
    });
});

//Vision Box
let visionBox=document.getElementById("vision");
let angle=0;
setInterval(() => {
    angle+=180;
    visionBox.style.transform=`rotateY(${angle}deg)`;
    visionBox.style.transitionDuration='5000ms';
    console.log(`rotateY(${angle}+180deg)`);
}, 5000);