export function drawLine(ctx, x1, y1, x2, y2, width) {
    const dx = Math.abs(x2 - x1);
    const dy = Math.abs(y2 - y1);
    const signX = x1 < x2 ? 1 : -1;
    const signY = y1 < y2 ? 1 : -1;

    let x = x1;
    let y = y1;
    let err = dx - dy;
    

    while (x !== x2 || y !== y2) {
        ctx.strokeRect(x, y,width,width);
        ctx.stroke();
        const err2 = 2 * err;

        if (err2 > -dy) {
            err -= dy;
            x += signX;
        }
        if (err2 < dx) {
            err += dx;
            y += signY;
        }
    }

    ctx.stroke();
    // context.lineTo(0, -length);
    ctx.lineCap = "round";
}