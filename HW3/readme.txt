# Chess Game Application

## Overview

This is a simple chess game application that demonstrates the State design pattern. The application manages the game's
different states, allowing it to handle turns and game over scenarios effectively.

## States

The application has three main states:

- **White's Turn**: When it is White's turn to play.
- **Black's Turn**: When it is Black's turn to play.
- **Game Over**: When the game has ended (either by checkmate or stalemate).

## Purpose

The purpose of this application is to show how the State design pattern allows an object to change its behavior based
on its internal state. Each state is represented by its own class, making the code easier to manage and understand.

## Implementation

### Key Components

1. **State Interface**: Defines methods like `nextTurn` and `gameOver` that each state must implement.

2. **Concrete State Classes**:
   - **WhiteTurn**: Manages actions during White's turn.
   - **BlackTurn**: Manages actions during Black's turn.
   - **GameOver**: Manages the game's end state.

3. **Game Context Class**: Holds the current state of the game and allows transitions between states.


