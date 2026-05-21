# FabricOrdersBack

FabricOrdersBack is a Spring Boot backend for managing fabric orders, user profiles, company settings, and manufacturer data.

## What this app does

- Provides authentication and authorization using JWT tokens
- Supports user signup, login, email verification, password reset
- Stores user settings and company settings separately
- Uploads and stores profile images
- Manages manufacturers with create/update/delete operations
- Uses Spring Data JPA with MySQL for persistence
- Sends emails through configurable SMTP providers

## Key features

- `Spring Boot 4` backend
- `Java 17` toolchain
- `Spring Security` + JWT authentication
- Secure password hashing with BCrypt
- File upload for profile pictures
- Email verification and password reset flows
- Configurable CORS and application settings

## Important endpoints

### Auth
- `GET /auth/test` - server health check
- `GET /auth/check-id?loginId={loginId}` - check login ID availability
- `POST /auth/email/send` - send signup verification code
- `POST /auth/email/verify` - verify signup email code
- `POST /auth/signup` - register a new user
- `POST /auth/login` - login and receive JWT token
- `POST /auth/find-password/send-code` - send password reset code
- `POST /auth/find-password/verify` - verify password reset code
- `POST /auth/find-password/reset` - reset password

### Manufacturer
- `GET /manufacturers` - list manufacturers
- `POST /manufacturers` - create manufacturer
- `PUT /manufacturers/{id}` - update manufacturer
- `DELETE /manufacturers/{id}` - delete manufacturer

### Upload
- `POST /upload/profile` - upload profile image for authenticated user

## Getting started

### Requirements

- Java 17
- Gradle wrapper (`./gradlew`)
- MySQL database

### Setup

1. Copy or create `src/main/resources/application.yml` with your own values.
2. Set your database URL, username, and password.
3. Configure `security.jwt.secret` with a strong random string (at least 32 chars).
4. Configure mail settings for Gmail or Naver if you need email verification.

### Run locally

```bash
./gradlew clean build -x test
./gradlew bootRun
```

Or build a jar:

```bash
./gradlew clean build -x test
java -jar build/libs/*.jar
```

## Notes

- Do not commit real credentials to `application.yml`.
- Keep the JWT secret private.
- `uploads/` should remain ignored in git to avoid storing user-uploaded files.

## Verified

- Build verified with `./gradlew clean build -x test`.
