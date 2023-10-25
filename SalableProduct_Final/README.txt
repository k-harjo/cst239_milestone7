VIDEO: https://youtu.be/waJAve982ts

# SalableProduct Application Readme

This Java code repository contains a SalableProduct Application for a fictional store called "Bloodbath and Beyond." This system allows users to manage the store's inventory, add and remove products from a shopping cart, view their purchases, and provides administration capabilities for updating and retrieving inventory. Additionally, it offers the capability to load and save inventory data to/from JSON files.

## Table of Contents

1. [Introduction](#introduction)
2. [Usage](#usage)
3. [Code Structure](#code-structure)
4. [Features](#features)
5. [Testing](#testing)
6. [Dependencies](#dependencies)
7. [Contributors](#contributors)
8. [License](#license)

## Introduction
...
## Usage
...
## Code Structure
...
## Features
...

## Testing

The repository includes unit tests to validate the functionality of individual classes and methods, ensuring the correct behavior of the application. The test packages consist of multiple test classes, each focusing on a specific class in the application. 

### Running Tests

To run the tests, navigate to the `test` package and execute each test class. The test classes include:

- `StoreFrontTest`: Tests methods related to purchasing and canceling products, and sorting products in the `StoreFront` class.
- `StoreFrontApplicationTest`: Validates the functionality in the `StoreFrontApplication` class.
- `ShoppingCartTest`: Confirms the correctness of adding and removing products in the `ShoppingCart` class along with other associated methods.
- `SalableProductTest`: Tests getters, setters, and other methods in the `SalableProduct` class to ensure they are working as expected.
  
### Writing Tests

When extending the application or modifying existing functionalities, corresponding tests should be updated or new tests should be added to maintain the reliability of the software. 

Here is a brief overview of how the tests are structured:

- **Setup**: Most test classes use a `setUp` method annotated with `@Before` to initialize objects and set up prerequisites for the tests.
- **Test Methods**: Each test method, annotated with `@Test`, represents a single unit test focusing on a specific method or functionality. They typically involve arranging prerequisites, acting on the method under test, and asserting the outcomes.
- **Assertions**: The tests use `assertEquals`, `assertTrue`, and other assertion methods to confirm that the actual outcomes match the expected ones.
  
Remember to consider edge cases and varied inputs while writing new tests to ensure comprehensive coverage.

## Dependencies

This SalableProduct Application relies on the following dependencies:

- [Jackson Databind](https://github.com/FasterXML/jackson-databind): A library for JSON serialization and deserialization. It is used to load and save inventory data in JSON format.

## Contributors

The code in this repository was developed by an individual contributor.

## License

This project is provided under the MIT License. You are free to use and modify the code for your purposes. See the [LICENSE](LICENSE) file for more details.
