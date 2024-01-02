const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d', { willReadFrequently: true });

ctx.fillStyle = 'rgba(255,255,255,1)';
ctx.fillRect(0, 0, canvas.width, canvas.height);

const circle = {
  x: 150,
  y: 150,
  radius: 20
};

ctx.beginPath();
ctx.arc(circle.x, circle.y, circle.radius, 0, 2 * Math.PI);
ctx.strokeStyle = 'rgba(0, 0, 255, 1)';
ctx.lineWidth = 3;
ctx.stroke();

function floodFill (x, y, newColor, targetColor) {
  const pixel = ctx.getImageData(x, y, 1, 1).data;

  if (
    x >= 0 &&
    y >= 0 &&
    x < canvas.width &&
    y < canvas.height &&
    pixel[0] === targetColor[0] &&
    pixel[1] === targetColor[1] &&
    pixel[2] === targetColor[2] &&
    pixel[3] === targetColor[3]
  ) {
    ctx.fillStyle = newColor;
    // TODO: recall floodFill with all 4 directions
    setInterval(() => {
      ctx.fillRect(x, y, 1, 1);
      floodFill(x + 1, y, newColor, targetColor);
      floodFill(x, y + 1, newColor, targetColor);
      floodFill(x - 1, y, newColor, targetColor);
      floodFill(x, y - 1, newColor, targetColor);
    }, 1000);
  }
}
