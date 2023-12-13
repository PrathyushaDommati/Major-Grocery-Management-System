import { CartItem } from "./CartItem";

export class Cart{
    items:CartItem[] = [];
get totalPrice() :number{
    let totalPrice = 0;
    this.items.forEach(item =>{
        totalPrice += item.price * item.quantity;
    });
    return totalPrice;
}

}