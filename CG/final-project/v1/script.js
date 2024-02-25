import { arabicToGeez } from "./arabicToGeez.js";
import { toEthiopian } from "./gcToEthiopianCalendar.js";

import { getDay, showTime} from "./date.js";


const canvas = document.querySelector('#canvas');
const context = canvas.getContext('2d' );

const geezNumbers = ['0',"፩", "፪","፫","፬","፭","፮","፯","፰","፱","፲","፲፩","፲፪" ]
let today = new Date();
let day = today.getDate();
let month = today.getMonth() + 1;
let year = today.getFullYear()



let radius= canvas.height / 2;
context.translate(radius, radius);
radius * 0.9;

function drawClock() {
    
    drawFace(context, radius);
    drawNumbers (context, radius);
    drawTime(context, radius);
    showTime(today)
    getDay(toEthiopian([year, month, day]))
 
}

let colorBlacka = '#333';
let colorBlackb= '#222'; 
let colorBlue = '#2cc';
let colorVoilet = '#3a0057';
let colorGray = '#555';

function drawFace(context, radius) {
    
    let gradient;
    
    context.beginPath();
    context.arc(0, 0, radius, 0, 2 * Math.PI);
    context.fillStyle= colorBlackb;
    context.fill();
   
    gradient = context.createRadialGradient(0, 0, radius * 0.95, 0,0, radius*1.05);
    gradient.addColorStop(0, colorBlacka);
    gradient.addColorStop(0.5, colorGray);
    gradient.addColorStop(1, colorBlacka);
    context.strokeStyle= gradient;
    context.lineWidth = radius * 0.1;
    context.stroke();
    context.beginPath();
    context.arc(0,0, radius* 0.1, 0, 2 * Math.PI);
    context.fillStyle= colorBlue;
    context.fill();
}

function drawNumbers (context, radius) {
    let angles;
    let numbers;
    context.font = radius* 0.15+"px arial";
    context.textBaseline = "middle";
    context.textAlign="center";
    for (numbers = 1; numbers < 13; numbers++){
        angles = (numbers * Math.PI) / 6;
        context.rotate (angles);
        context.translate(0, -radius* 0.85);
        context.rotate(-angles);
        context.fillText (geezNumbers[numbers], 0, 0);
        context.rotate(angles);
        context.translate(0, radius * 0.85);
        context.rotate(-angles);
        // console.log(arabicToGeez[numbers])
    }
}
function drawTime(context, radius){
    let now = new Date();
    let hour = now.getHours();
    let minute = now.getMinutes();
    let second = now.getSeconds();
    
    hour
    hour=hour%12 + 6;
    hour=(hour*Math.PI/6)+(minute*Math.PI/(6*60))+(second*Math.PI/(360*60));
    drawHand(context, hour, radius*0.4, radius*0.07);
    
    minute
    minute=(minute*Math.PI/30)+(second*Math.PI/(30*60));
    drawHand(context, minute, radius*0.6, radius*0.05);
    
    second
    second=(second*Math.PI/30);
    drawHand(context, second, radius*0.7, radius*0.02);
}  



function drawHand(context, pos, length, width){
    context.beginPath();
    context.lineWidth = width;
    context.lineCap = "round";
    context.moveTo(0, 0);
    context.rotate (pos);
    context.lineTo(0, -length);
    context.stroke();
    context.rotate(-pos);
}





setInterval(drawClock, 1000);






