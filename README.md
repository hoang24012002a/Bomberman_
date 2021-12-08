# Bomberman_
##Demo

![](core/assets/cartoon/demo.gif)

Game được phát triển với core viết bằng ngôn ngữ Java và được xây dựng bởi các sinh viên:
1. Vũ Duy Hoàng (Nhóm 7, MSSV: 20020413, Manager)
2. Vũ Văn Tuấn (Nhóm 9, MSSV: 20020497)
3. Nguyễn Văn Trường (Nhóm 9, MSSV: 20020491)

Hướng dẫn chơi:

    A - move left
    S - move down
    D - move right
    W - move up
    Space - place bomb
    ON/OFF - mute background sound
    PLAY - choose map to play
    P - pause game
    C - pass level
    

Mô tả cấu trúc của file map: 

Dòng 1: Số hàng

Dòng 2: Số cột

Các dòng tiếp theo: 

    rỗng - Grass

Tile:

    # - Wall
    * - Brick
    x - portal

Character: 

    p - Bomber
    1 - Balloon
    2 - Oneal
    3 - Doll

Item: 
    
    b - BombItem
    f - FlameItem
    s - SpeedItem


Cây kế thừa:

![](core/assets/img/EXTEND TREE.png)

Ưu điểm: Đồ hoạ dễ dùng thân thiện, lên đến 3 màn chơi, có thêm sound effect, thuật toán AI cho từng loại
quái.

Source code: tự xây dựng cây kế thừa đồng thời kết hợp với libGDX để phát triển

Thư viện được sử dụng để phát triển game https://github.com/libgdx/libgdx
