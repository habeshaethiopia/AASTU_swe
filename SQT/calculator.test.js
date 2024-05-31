const calculator = require('./calculator.js');
describe("sum",() => {
    test("sould sum two integer nums ", () => {
        const r = calculator.sum(2, 5);
        expect(r).toBe(7);
      });
      test("sould sum two float num  ", () => {
          const r = calculator.sum(2.5, 5.5);
          expect(r).toBe(8.0);
        });
});
describe("substruction",() => {
    test("sould substruct two integer nums ", () => {
        const r = calculator.sub(2, 5);
        expect(r).toBe(-3);
      });
      test("sould sub two float num  ", () => {
          const r = calculator.sub(2.5, 5.5);
          expect(r).toBe(-3.0);
        });
});
describe("div",() => {
    test("sould div two integer nums ", () => {
        const r = calculator.div(2, 5);
        expect(r).toBe(0.4);
      });
      test("sould div two float num  ", () => {
          const r = calculator.div(2.5, 0);
          expect(r).toBe("Cannot divide by zero");
        });
});

