# Алгоритм
def find_closest_bikes(students, bikes):
    n = len(students)  # Оюутнуудын тоо
    m = len(bikes)     # Дугуйнуудын тоо
    
    result = [-1] * n  # Оюутан бүрт дугуй сонгох индексийг хадгалах
    bike_taken = [False] * m  # Дугуйг эзэмшиж байгаа эсэхийг хадгалах
    
    for student_index in range(n):
        min_distance = float('inf')  # Хамгийн ойр зай
        chosen_bike = -1  # Сонгогдсон дугуй
        
        for bike_index in range(m):
            if not bike_taken[bike_index]:
                distance = abs(students[student_index][0] - bikes[bike_index][0]) + abs(students[student_index][1] - bikes[bike_index][1])
                
                if distance < min_distance:
                    min_distance = distance
                    chosen_bike = bike_index
                elif distance == min_distance:
                    # Хэрэв зай нь тэнцүү бол хамгийн бага индекс бүхий дугуйг сонгоно
                    if bike_index < chosen_bike:
                        chosen_bike = bike_index
        
        # Оюутан сонгосон дугуйг эзэмшинэ
        result[student_index] = chosen_bike
        bike_taken[chosen_bike] = True  # Дугуйг эзэмшсэн гэж тэмдэглэнэ
    
    return result


# Тест
import unittest

class TestClosestBikes(unittest.TestCase):
    
    def test_find_closest_bikes(self):
        self.assertEqual(find_closest_bikes([(0, 0), (1, 1)], [(0, 1), (4, 3), (2, 1)]), [0, 2])
        self.assertEqual(find_closest_bikes([(1, 1), (2, 2)], [(1, 0), (3, 2), (0, 2)]), [0, 2])
        self.assertEqual(find_closest_bikes([(0, 0)], [(1, 1), (2, 2)]), [0])
        self.assertEqual(find_closest_bikes([(1, 1)], [(2, 2), (3, 3)]), [0])

if __name__ == '__main__':
    unittest.main()
