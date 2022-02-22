object reverseVowelsOfString{

    val isVowel2 = Set('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')
    
    def reverseVowels2(s: String): String = {
        val a = s.toArray
        @tailrec
        def reverse(i: Int = 0, j: Int = a.length - 1): Unit = {
            if (i < j) {
                if (!isVowel2(a(i))) reverse(i+1, j)
                else if (!isVowel2(a(j))) reverse(i, j-1)
                else {
                    val tmp = a(i)
                    a(i) = a(j)
                    a(j) = tmp
                    reverse(i+1, j-1)
                }
            }
        }
        reverse()
        a.mkString
    }
    
    
    def isVowel(ch: Char): Boolean = {
        String vowels = "aeiouAEIOU"
        return vowels.contains(ch + "")
    }
    
    def reverseVowels(s: String): String = {
        var arr = s.toCharArray()
        var left = 0
        var right = arr.size - 1

        while(left < right){

            while(left < right && isVowel(arr(left) == false)){
                left += 1
            }
            while(left < right && isVowel(arr(right) == false)){
                right -= 1
            }

            var temp = arr(left)
            arr(left) = arr(right)
            arr(right) = temp

            left += 1
            right -=1
        }
        String.valueOf(arr)
    }

    def main(args: Array[String]): Unit = {
        var s  = "hello"
        print(reverseVowels(s))
    }
}
