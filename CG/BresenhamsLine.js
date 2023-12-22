function drawBresenhamLine (x1, y1, x2, y2) {
  let canvas = document.getElementById('myCanvas');
  let ctx = canvas.getContext('2d');
  ctx.strokeStyle = 'blue';
  let dx = Math.abs(x2 - x1);
  let dy = Math.abs(y2 - y1);
  let signX = (x1 < x2) ? 1 : -1;
  let signY = (y1 < y2) ? 1 : -1;

  let error = dx - dy;

  ctx.beginPath();
  ctx.moveTo(x1, y1);

  while (x1 !== x2 || y1 !== y2) {
    ctx.lineTo(x1, y1);
    let error2 = 2 * error;

    if (error2 > -dy) {
      error -= dy;
      x1 += signX;
    }

    if (error2 < dx) {
      error += dx;
      y1 += signY;
    }
  }

  ctx.stroke();
}
