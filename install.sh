#!/bin/bash

# 1. Папка, куди встановлюємо (стандартна для Linux/macOS)
INSTALL_DIR="$HOME/.local/bin"
JAR_PATH="$INSTALL_DIR/my_data_library.jar"
DOWNLOAD_URL="https://github.com/MykhailoMatichak/my_data_library/releases/download/v.1.0.0/my_data_library-0.0.1-SNAPSHOT.jar"

# 2. Створюємо папку, якщо її немає
mkdir -p "$INSTALL_DIR"

echo "⏳ Завантаження програми з GitHub..."
# 3. Скачуємо jar-файл
curl -sL -o "$JAR_PATH" "$DOWNLOAD_URL"

# Перевірка, чи файл дійсно скачався
if [ ! -f "$JAR_PATH" ]; then
    echo "❌ Помилка: Не вдалося завантажити файл. Перевірте посилання."
    exit 1
fi

echo "⚙️ Створення команди 'mylib'..."
# 4. Створюємо файл-обгортку (нашу коротку команду)
cat << 'EOF' > "$INSTALL_DIR/mylib"
#!/bin/bash
java -jar "$HOME/.local/bin/my_data_library.jar" "$@"
EOF

# 5. Робимо цю команду виконуваною
chmod +x "$INSTALL_DIR/mylib"

# 6. АВТОМАТИЧНА ПЕРЕВІРКА PATH (для Mac та Linux)
if [[ ":$PATH:" != *":$HOME/.local/bin:"* ]]; then
    echo "🔧 Додаємо ~/.local/bin у системний PATH..."

    # Визначаємо, який файл налаштувань використовується (zsh для Mac, bash для Linux)
    if [ -n "$ZSH_VERSION" ] || [ "$(basename "$SHELL")" = "zsh" ]; then
        SHELL_RC="$HOME/.zshrc"
    else
        SHELL_RC="$HOME/.bashrc"
    fi

    # Додаємо шлях, якщо його там ще немає
    if ! grep -q 'export PATH="$HOME/.local/bin:$PATH"' "$SHELL_RC" 2>/dev/null; then
        echo 'export PATH="$HOME/.local/bin:$PATH"' >> "$SHELL_RC"
        echo "✅ Шлях додано у $SHELL_RC"
    fi

    # Застосовуємо зміни в поточній сесії
    export PATH="$HOME/.local/bin:$PATH"
fi

echo "✅ Встановлення завершено!"
echo "Тепер ви можете запустити програму командою: mylib"