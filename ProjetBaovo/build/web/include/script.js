const diapo = document.querySelector(".diapo");



let next = document.querySelector("#nav-droite");

let prev = document.querySelector("#nav-gauche");

let compteur = 0;

let timer ,elements,slides,slideWidth;

elements = document.querySelector(".elements");

slides = Array.from(elements.children);

slideWidth = diapo.getBoundingClientRect().width

next.addEventListener("click",slideNext);

prev.addEventListener("click",slidePrev);

function slideNext()
{
    compteur++;
    if(compteur == slides.length)
    {
        compteur=0;
    }
    let decal = -slideWidth*compteur;
    elements.style.transform = 'translateX(${decal}px)';
}

function slidePrev()
{
    compteur--;
    if(compteur<0)
    {
        compteur=slides.length-1;
    }
    let decal = -slideWidth*compteur;
    elements.style.transform = 'translateX(${decal}px)';
}

timer = setInterval(slideNext,4000);

diapo.addEventListener("mouseover",stopTimer);

diapo.addEventListener("mouseout",startTimer);

function stopTimer()
{
    clearInterval(timer);
}

function startTimer()
{
    timer = setInterval(slideNext,4000);
}