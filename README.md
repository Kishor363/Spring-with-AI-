
# Spring AI Project – Text, Image & Vision with OpenAI

## 📌 Overview

This project demonstrates how to integrate **Spring Boot** with **Spring AI** to interact with OpenAI models.
It supports:

* **Text Generation** → Send a prompt and get back an AI-generated response.
* **Image Generation** → Send a prompt and get back an AI-generated image.
* **Image-to-Text (Vision)** → Upload an image and get back a description of it.

---

## ⚙️ Tech Stack

* **Java 17+**
* **Spring Boot 3**
* **Spring AI** (OpenAI integration)
* **Maven**
* **REST APIs**

---

## 🚀 Features

* Ask questions via REST API → Get AI-powered answers.
* Generate images from text prompts.
* Analyze an image and get descriptive captions.
* Secure API key handling (via `application.properties` + environment variable).

---

## 📂 Project Structure

```
src/main/java/com/openAI/
│── controller/       # REST controllers
│── OpenAiImplimentingSpringBoot1Application.java
src/main/resources/
│── application.properties
```

---

## 🔑 Configuration

Add your OpenAI API key in `application.properties`:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

> ⚠️ **Important:** Never hardcode your API key. Use environment variables.

Set the environment variable before running:

```bash
export OPENAI_API_KEY=your-key-here       # Linux / Mac
setx OPENAI_API_KEY "your-key-here"       # Windows PowerShell
```

---

## ▶️ Run the Project

```bash
mvn spring-boot:run
```

---

## 📡 API Endpoints

### 1️⃣ Text Completion

**POST** `/api/text`
Request Body:

```json
{
  "prompt": "Explain microservices in simple words"
}
```

Response:

```json
{
  "result": "Microservices are small, independent services..."
}
```

---

### 2️⃣ Image Generation

**POST** `/api/image`
Request Body:

```json
{
  "prompt": "A futuristic city on Mars"
}
```

Response:

```json
{
  "imageUrl": "https://..."
}
```

---

### 3️⃣ Image Description (Vision)

**POST** `/api/vision` (send image as `MultipartFile`)

Response:

```json
{
  "description": "A red sports car parked near the beach..."
}
```

---

## 🛡️ Security Note

* Never commit API keys into GitHub.
* Use `.gitignore` for `application.properties` if it contains secrets.
* Enable GitHub Push Protection (already active).

---

## 📖 References

* [Spring AI Docs](https://docs.spring.io/spring-ai/reference/)
* [OpenAI API](https://platform.openai.com/docs/)

---

✨ **Author:** Kishor Mohanty
📌 GitHub: [Kishor363](https://github.com/Kishor363)

