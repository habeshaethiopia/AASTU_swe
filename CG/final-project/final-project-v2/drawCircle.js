export function drawCircle(ctx, xc, yc, radius, color) {
  let x = 0;
  let y = radius;
  let p = 3 - 2 * radius;

  // Function to set pixel at given (x, y) coordinates
  function setPixel(x, y) {
    ctx.strokeStyle = color
    ctx.lineWidth = 5;
    ctx.strokeRect(x, y, 1, 1);
  }

  // Function to draw symmetry points in eight octants
  function drawSymmetryPoints(x, y) {
    setPixel(xc + x, yc + y);
    setPixel(xc - x, yc + y);
    setPixel(xc + x, yc - y);
    setPixel(xc - x, yc - y);
    setPixel(xc + y, yc + x);
    setPixel(xc - y, yc + x);
    setPixel(xc + y, yc - x);
    setPixel(xc - y, yc - x);
  }

  // Initial point
  drawSymmetryPoints(x, y);

  while (x < y) {
    x++;

    if (p < 0) {
      p = p + 4 * x + 6;
    } else {
      y--;
      p = p + 4 * (x - y) + 10;
    }

    // Draw symmetry points for each position
    drawSymmetryPoints(x, y);
  }
  function hexToRgb(hex) {
    let result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result
      ? `rgb(${parseInt(result[1], 16)}, ${parseInt(result[2], 16)}, ${parseInt(
          result[3],
          16
        )})`
      : null;
  }
  function boundaryFill(x, y, fill_color, boundary_color) {
    fill_color = hexToRgb(fill_color);
    boundary_color = hexToRgb(boundary_color);
    fill_color = 'rgb(34, 204, 204)'
    boundary_color = 'rgb(34, 204, 204)'
    let stack = [[200, 200]];
    let cnut = 0;
    while (stack.length) {
      let [x, y] = stack.pop();

      if (x >= 0 && y >= 0 && x < ctx.canvas.width && y < ctx.canvas.height) {
        let pixelData = ctx.getImageData(x, y, 1, 1).data;
        let currentColor = `rgb(${pixelData[0]}, ${pixelData[1]}, ${pixelData[2]})`;
        if (currentColor !== boundary_color && currentColor !== fill_color) {
          ctx.fillStyle = fill_color;
          ctx.strokeRect(x, y, 1, 1);
          cnut++;
          if (cnut == 100) {
            break;
          }
          console.log(stack.length,x , y, currentColor, fill_color);
          // Add the neighboring pixels to the stack
          stack.push([x + 1, y]);
          stack.push([x, y + 1]);
          stack.push([x - 1, y]);
          stack.push([x, y - 1]);
        }
      }
    }
  }
   boundaryFill(xc, yc, '#3a0057', '#3a0057');
}
