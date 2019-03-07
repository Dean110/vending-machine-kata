# vending-machine-kata

## The Plan
The education goal of this kata is to push the boundaries of my integration and unit testing knowledge.  
The design goal is to create an API that simulates a vending machine's inner workings.  I am using Guy Royse's Vending Machine Kata as a design spec for my vending machine.

### The Design
I want to write three API's that work together to form a vending machine.
- #### The Interface
    The Interface API will represent the front panel of the vending machine.  It will handle the display message and button pushes.
- #### The Coin Hopper
    The Coin Hopper API will represent the bank operations inside the vending machine.  It will handle coin validation, making change, tracking the available change, and handling coin return requests.
- #### The Product Dispenser
    The Product Dispenser API will represent the dispensing operations.  It will handle product counts and product price information.
