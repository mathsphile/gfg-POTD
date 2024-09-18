// Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
// For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

// Note: The driver code prints "balanced" if function return true, otherwise it prints "not balanced".

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        
        // Stack to store opening brackets.
        Stack<Character> stack = new Stack<>();
        
        // Traversing the expression.
        for (int i = 0; i < x.length(); i++)
        {
            char ch = x.charAt(i);

            // If it's an opening bracket, push to the stack.
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }
            // If it's a closing bracket.
            else
            {
                // If the stack is empty, it means there is no matching opening bracket.
                if (stack.isEmpty())
                {
                    return false;
                }

                char lastBracket = stack.pop();

                // Check if the closing bracket matches the corresponding opening bracket.
                if (ch == ')' && lastBracket != '(') return false;
                if (ch == '}' && lastBracket != '{') return false;
                if (ch == ']' && lastBracket != '[') return false;
            }
        }

        // In the end, if the stack is empty, all brackets were balanced.
        return stack.isEmpty();
    }
}
