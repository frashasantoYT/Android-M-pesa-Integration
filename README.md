# Android App with M-Pesa STK Push Integration using Daraja API

This repository contains an Android application that demonstrates integration of M-Pesa STK Push functionality using Safaricom's Daraja API.

## Features

- **STK Push Integration**: Allows users to initiate payments directly from the app using M-Pesa's STK Push functionality.
- **Transaction Status**: Retrieves transaction status after the payment is initiated.
- **User-friendly Interface**: Simple and intuitive interface for a seamless payment experience.

## Technologies Used

- **Android**: Native platform for the mobile application.
- **Java**: Primary programming language for Android development.
- **Safaricom Daraja API**: Used to facilitate M-Pesa integrations.

## Requirements

- Android Studio
- Safaricom Developer Account (for Daraja API access)
- Internet connection (for API calls)

## Getting Started

To get started with the project, follow these steps:

1. **Clone the repository**:
https://github.com/frashasantoYT/Android-M-pesa-Integration.git



2. **Open in Android Studio**:
- Launch Android Studio.
- Choose "Open an existing Android Studio project".
- Navigate to the cloned project and select the `build.gradle` file in the root directory.

3. **Set up Daraja API**:
- Obtain your credentials (Consumer Key and Consumer Secret) from Safaricom Developer Portal.
- Configure these credentials in the app's PaymentViewModel.kt file

4. **Build and Run**:
- Build the project and run it on an Android device or emulator.

## Usage

- Launch the app on your device.
- Navigate to the payment section.
- Enter payment details and initiate the payment.
- Follow the prompts on the screen to complete the payment using the M-Pesa STK Push.

## Screenshots

![Screenshot 1](/screenshots/screenshot1.png)
![Screenshot 2](/screenshots/screenshot2.png)

## Contributing

Contributions are welcome! If you'd like to contribute:
- Fork the repository.
- Create your feature branch (`git checkout -b feature/YourFeature`).
- Commit your changes (`git commit -am 'Add some feature'`).
- Push to the branch (`git push origin feature/YourFeature`).
- Create a new Pull Request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

- Safaricom Daraja API Documentation
- Contributors and maintainers of open source libraries used in this project
