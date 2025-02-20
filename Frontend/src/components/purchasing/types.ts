export type item = {
    cost: number,
    name: string,
    group: string
}

export type cartItem = {
    item : item,
    quantity : number
}

export type customerOrder = {
    cartItems : cartItem[],
    customer : string
}