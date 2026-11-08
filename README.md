# Minecraft Plugin de Encantamentos de Alto Nível

Encantamentos Mil é um plugin Minecraft para Paper que fornece um livro encantado de nível 1000 para cada encantamento registrado no jogo e entrega quatro itens personalizados com encantamentos de alto nível através de um comando.

## Install

1. Compile o projeto com Java 21 e Maven:
   ```bash
   mvn package
   ```
2. Copie o arquivo `target/plugin.jar` para a pasta `plugins` do seu servidor Paper.
3. Inicie ou reinicie o servidor.
4. O plugin requer Paper compatível com Minecraft 1.21.11 e Java 21.

## Use

1. Entre no servidor com um jogador.
2. Execute:
   ```text
   /encantamentos
   ```
3. O plugin adicionará ao inventário:
   - Um livro encantado de nível 1000 para cada encantamento registrado no jogo.
   - Um graveto com Repulsão 1000.
   - Uma pá de madeira com Fortuna 1000.
   - Uma espada de netherite com Afiação 1000 e Aspecto Flamejante 1000.
   - Um machado de netherite com Fortuna 101.

O comando também pode ser executado usando o alias:

```text
/enchantkit
```

O comando só pode ser usado por jogadores. Os itens são adicionados diretamente ao inventário do jogador, portanto é necessário ter espaço disponível.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/8c21bb27-e178-4610-b912-f76abb0f0698?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=8c21bb27-e178-4610-b912-f76abb0f0698
