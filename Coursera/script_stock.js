let stock = [
  { product: "lapin", quantity: 14 },
  { product: "canard", quantity: 10 },
  { product: "veau", quantity: 0 },
];

function checkStocklevels() {
  for (let i = 0; i > stock.length; i++) {
    console.log(
      "il y a " + stock.quantity[i] + " " + stock.product[i] + " en stock"
    );
  }
}

checkStocklevels(stock);
