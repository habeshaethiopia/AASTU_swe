function drawDDALine (x1, y1, x2, y2) {
  const canvas = document.getElementById('canvas');
  const ctx = canvas.getContext('2d');
  ctx.strokeStyle = 'blue';
  const dx = x2 - x1;
  const dy = y2 - y1;
  const steps = Math.max(Math.abs(dx), Math.abs(dy));
  const xIncrement = dx / steps;
  const yIncrement = dy / steps;

  let x = x1;
  let y = y1;

  ctx.beginPath();
  ctx.moveTo(x1, y1);

  for (let i = 0; i < steps; i++) {
    x += xIncrement;
    y += yIncrement;
    ctx.lineTo(Math.round(x), Math.round(y));
    ctx.strokeRect(50, 50, x, y);
    console.log(x, y);
  }
}
drawDDALine(50, 50, 200, 200);
