function drawBresenhamCircle (centerX, centerY, radius) {
  const canvas = document.getElementById('myCanvas');
  const ctx = canvas.getContext('2d');
  ctx.strokeStyle = 'yellow';
  let x = 0;
  let y = radius;
  let decisionOver2 = 1 - radius; // Decision criterion divided by 2 evaluated at x=r, y=0

  ctx.beginPath();
  ctx.moveTo(centerX + x, centerY - y);

  while (y >= x) {
    ctx.lineTo(centerX + x, centerY - y);
    ctx.lineTo(centerX + y, centerY - x);
    ctx.lineTo(centerX - y, centerY - x);
    ctx.lineTo(centerX - x, centerY - y);
    ctx.lineTo(centerX - x, centerY + y);
    ctx.lineTo(centerX - y, centerY + x);
    ctx.lineTo(centerX + y, centerY + x);
    ctx.lineTo(centerX + x, centerY + y);

    x++;

    if (decisionOver2 <= 0) {
      decisionOver2 += 2 * x + 1; // Change in decision criterion for x -> x+1
    } else {
      y--;
      decisionOver2 += 2 * (x - y) + 1; // Change for x -> x+1 and y -> y-1
    }
  }

  ctx.stroke();
}
