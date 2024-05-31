function sum(x, y) {
  return x + y;
}
function sub(x, y) {
  return x - y;
}
function div(x, y) {
  if (y === 0) {
    throw new Error("Cannot divide by zero");
  }
  return x / y;
}
module.exports = { sum, sub , div};
