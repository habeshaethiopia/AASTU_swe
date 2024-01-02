const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d", { willReadFrequently: true });

ctx.fillStyle = "rgba(255,255,255,1)";
ctx.fillRect(0, 0, canvas.width, canvas.height);

const circle = {
  x: 150,
  y: 150,
  radius: 120,
};

ctx.beginPath();
ctx.arc(circle.x, circle.y, circle.radius, 0, 2 * Math.PI);
ctx.strokeStyle = "rgba(0, 0, 255, 1)";
ctx.lineWidth = 3;
ctx.stroke();

function floodFill(x, y, newColor, targetColor) {
  const stack = [];
  const initialColor = ctx.getImageData(x, y, 1, 1).data;

  if (
    initialColor[0] === newColor[0] &&
    initialColor[1] === newColor[1] &&
    initialColor[2] === newColor[2]
  ) {
    return;
  }

  stack.push({ x, y });

  while (stack.length) {
    const { x, y } = stack.pop();
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
      ctx.fillRect(x, y, 1, 1);

      stack.push({ x: x + 1, y });
      stack.push({ x: x - 1, y });
      stack.push({ x, y: y + 1 });
      stack.push({ x, y: y - 1 });
    }
  }
}

const initialColor = ctx.getImageData(circle.x + 10, circle.y + 10, 1, 1).data;
floodFill(circle.x, circle.y, "purple", initialColor);
