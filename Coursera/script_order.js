let order = [
  { item: "pomme", quantity: 10, price: 4.2 },
  { item: "poire", quantity: 5, price: 10.5 },
  { item: "scoubidou", quantity: 2, price: 5.8 },
];

function generateReceipt() {
  let receipt = 0;
  console.log("receipt");
  console.log("-----------------");
  for (let i = 0; i < order.length; i++) {
    let quantityString = String(order[i].quantity);
    let priceString = String(order[i].price);
    let totalitem = order[i].quantity * order[i].price;

    console.log(
      quantityString +
        " " +
        order[i].item +
        " à " +
        priceString +
        " pour un total de " +
        totalitem
    );

    receipt = receipt + order[i].quantity * order[i].price;
  }
  console.log("-----------------");
  console.log("grand total de " + receipt);
}

generateReceipt(order);
