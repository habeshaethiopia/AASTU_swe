import { arabicToGeez } from "./arabicToGeez.js";
export function showTime(today){
    let h = today.getHours() - 6; // 0 - 23
    let m = today.getMinutes(); // 0 - 59
    let s = today.getSeconds(); // 0 - 59
    let session = "ጠዋት";
    
    if(h == 0){
        h = 12;
    }
    
    
    if(h > 12){
        h = h - 12;
        session = "ማታ";
    }else if (h >= 6 && h <= 12){
      session = "ከሰዓት"
    }
    
    h = (h < 10) ? "0" + h : h;
    m = (m < 10) ? "0" + m : m;
    s = (s < 10) ? "0" + s : s;
    // let amaharic_h = arabicToGeez(h)
    // let amaharic_s = arabicToGeez(s)
    // let amaharic_m = arabicToGeez(m)
    // console.log(amaharic_h)
    let time = h +  ":" + m + ":" + s+ " ፣ " + session; 
    document.getElementById("MyClockDisplay").innerText = time;
    document.getElementById("MyClockDisplay").textContent = time;
    
  }

export function getDay(ethiopianDate){
    const date = ethiopianDate[1] + " ፣ "+ arabicToGeez(ethiopianDate[2]) +  " ፣ " +arabicToGeez( ethiopianDate[0]);
    document.getElementById("date").innerHTML = date;
  }