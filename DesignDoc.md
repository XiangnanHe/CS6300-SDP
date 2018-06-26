# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Xiangnan He

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

*Describe any assumption, background, or dependencies of the software, its use, the operational environment, or significant project issues.*

1. Since authentication is optional, and there is a single system running the application, this will not be addressed in this design document.
2. The app will not have cross session state, in another word, when the player go back to choose a different cryptogram to solve, the progress of the current cryptogram will be lost, and a new cryptogram will be initialized for the player to solve. Also, when the app restarts, an entirely new session will be initialized. 
3. There is not a limitation on the number of cryptogram to be created in this design consideration.
4. Data of the users, players, cryptograms, and etc., are stored on SQLlite.

### 1.2 Constraints

*Describe any constraints on the system that have a significant impact on the design of the system.*

1. The design is to be implemented on an Android device through Android Studio, therefore, the user will need an Android device to play
2. The user/player will need to have basic cryptogram knowledge to solve the problems.
3. The device have enough space to store and run the cryptogram app

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

1. Hardware: Android device
2. Platform: Android Studio
3. OS: Android

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*



### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely state why.*
