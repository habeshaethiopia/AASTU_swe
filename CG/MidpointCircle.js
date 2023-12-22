function drawMidpointCircle(centerX, centerY, radius) {
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");
    ctx.strokeStyle = 'red';
    var x = radius;
    var y = 0;
    var radiusError = 1 - x;

    ctx.beginPath();
    ctx.moveTo(centerX + x, centerY - y);

    while (x >= y) {
        ctx.lineTo(centerX + x, centerY - y);
        ctx.lineTo(centerX + y, centerY - x);
        ctx.lineTo(centerX - y, centerY - x);
        ctx.lineTo(centerX - x, centerY - y);
        ctx.lineTo(centerX - x, centerY + y);
        ctx.lineTo(centerX - y, centerY + x);
        ctx.lineTo(centerX + y, centerY + x);
        ctx.lineTo(centerX + x, centerY + y);

        y++;

        if (radiusError < 0) {
            radiusError += 2 * y + 1;
        } else {
            x--;
            radiusError += 2 * (y - x) + 1;
        }
    }

    ctx.stroke();
}
