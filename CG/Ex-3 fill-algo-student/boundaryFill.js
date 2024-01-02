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

function isSameColor(color1, color2) {
  return (
    color1[0] === color2[0] &&
    color1[1] === color2[1] &&
    color1[2] === color2[2] &&
    color1[3] === color2[3]
  );
}

function boundaryFill(x, y, fillColor, boundaryColor) {
  const imageData = ctx.getImageData(x, y, 1, 1);
  const pixel = imageData.data;
  ctx.fillStyle = `rgba(${fillColor[0]}, ${fillColor[1]}, ${fillColor[2]}, ${fillColor[3] / 255
    })`;

  setTimeout(2000);
  if (!isSameColor(pixel, boundaryColor) && !isSameColor(pixel, fillColor)) {
    ctx.fillRect(x, y, 1, 1);
    setTimeout(() => {
      // TODO: recall boundaryFill with all 4 directions
      boundaryFill(x + 1, y, fillColor, boundaryColor);
      boundaryFill(x, y + 1, fillColor, boundaryColor);
      boundaryFill(x - 1, y, fillColor, boundaryColor);
      boundaryFill(x, y - 1, fillColor, boundaryColor);
      // boundaryFill(x + 1, y + 1, fillColor, boundaryColor);
      // boundaryFill(x + 1, y - 1, fillColor, boundaryColor);
      // boundaryFill(x - 1, y - 1, fillColor, boundaryColor);
      // boundaryFill(x - 1, y + 1, fillColor, boundaryColor);
    }, 200);
  }
}

boundaryFill(circle.x, circle.y, [255, 0, 0, 255], [0, 0, 255, 255]);
