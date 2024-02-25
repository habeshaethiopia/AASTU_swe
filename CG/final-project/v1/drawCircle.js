export function drawCircle(ctx, xc, yc, radius) {
    

    let x = 0;
    let y = radius;
    let p = 3 - 2 * radius;

    // Function to set pixel at given (x, y) coordinates
    function setPixel(x, y) {
        ctx.fillRect(x, y, 1, 1);
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
}


