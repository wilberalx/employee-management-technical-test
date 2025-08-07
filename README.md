# Employee Management Technical Test

## API (Spring Boot + Kotlin + Gradle + Java 17)
Folder: `api/`

### How to run:
1. Navigate to the `api/` folder.
2. Build and run the project using Gradle:
   ```bash
   ./gradlew bootRun
   ```
3. The API will run at:
   ```
   http://localhost:8080
   ```

---

## Web (Angular 17)
Folder: `web/`

### How to run:
1. Navigate to the `web/` folder.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   ng serve
   ```
4. Open your browser and go to:
   ```
   http://localhost:4200
   ```

---

## Requirements
- Java 17 JDK
- Gradle
- Node.js and npm
- Angular CLI (to run `ng serve`)

---

## Notes
- The frontend is configured to communicate with the backend API at `http://localhost:8080`.
- Make sure both projects are running simultaneously for full functionality.
