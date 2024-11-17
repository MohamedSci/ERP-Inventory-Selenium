# ERP-Inventory-Selenium

To create a new Maven project directly from Visual Studio Code (VS Code), you can use the **Maven for Java Extension Pack**. Here’s how you can do it step by step:

---

### **1. Install Required Extensions**

- Open VS Code.
- Go to the Extensions view (`Ctrl+Shift+X` on Windows/Linux or `Cmd+Shift+X` on macOS).
- Search for and install:
  - **"Maven for Java"** (part of the "Extension Pack for Java").
  - **"Java Extension Pack"** (optional but helpful for Java development).

---

### **2. Create a New Maven Project**

1. **Open Command Palette**
   - Press `Ctrl+Shift+P` (Windows/Linux) or `Cmd+Shift+P` (macOS) to open the Command Palette.

2. **Search for Maven Command**
   - Type `Maven` and select **"Maven: Generate from Archetype"**.

3. **Choose an Archetype**
   - VS Code will display a list of Maven archetypes. Common ones include:
     - `maven-archetype-quickstart` (basic Java project).
     - `maven-archetype-webapp` (web project).
   - Use the arrow keys to navigate and select the desired archetype.

4. **Provide Project Details**
   - VS Code will prompt you for the following inputs:
     - **Group ID**: A unique identifier for your project (e.g., `com.mohamedsaidibrahim`).
     - **Artifact ID**: The name of your project (e.g., `inventory`).
     - **Version**: Default is `1.0-SNAPSHOT`.
     - **Package**: The base package name (e.g., `com.mohamedsaidibrahim.inventory`).

5. **Choose the Project Directory**
   - Select the folder where you want your project to be created.

6. **Finish**
   - VS Code generates the project, including the POM file and directory structure.

---

### **3. Open the Project in VS Code**

- Navigate to the project directory in the file explorer.
- Open the folder in VS Code (`File > Open Folder`).
- You can now start coding!

---

### **4. Verify the Setup**

- In the `Explorer` view, expand the project folder to ensure the following are present:
  - **`src/main/java`**: Source code directory.
  - **`src/test/java`**: Test code directory.
  - **`pom.xml`**: Maven's Project Object Model configuration.

---

### **5. Run Maven Commands in VS Code**

- Use the **Maven view** in VS Code:
  1. Open the Maven tab in the Activity Bar (on the left-hand side).
  2. You can run commands like `clean`, `install`, or `package` directly from the GUI.

---

### **Alternative Using VS Code Terminal**

If you prefer using the terminal within VS Code:

1. Open the terminal (`Ctrl+`` or`View > Terminal`).
2. Run your Maven command directly:

   ```bash
   mvn archetype:generate -DgroupId=com.mohamedsaidibrahim -DartifactId=inventory -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```
