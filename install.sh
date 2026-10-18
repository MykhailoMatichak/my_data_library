#!/bin/bash

# 1. Папка, куди встановлюємо (стандартна для Linux/Mac)
INSTALL_DIR="$HOME/.local/bin"
JAR_PATH="$INSTALL_DIR/my_data_library.jar"
DOWNLOAD_URL="https://github.com/MykhailoMatichak/my_data_library/releases/download/v.1.0.0/my_data_library-0.0.1-SNAPSHOT.jar"

# 2. Створюємо папку, якщо її немає
mkdir -p "$INSTALL_DIR"

echo "⏳ Завантаження програми з GitHub..."
# 3. Скачуємо jar-файл
curl -L -o "$JAR_PATH" "$DOWNLOAD_URL"

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

echo "✅ Встановлення завершено!"
echo "Тепер ви можете запустити програму командою: mylib"