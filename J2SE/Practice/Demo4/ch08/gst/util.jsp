<%!
    public static String toHtml(String str)
    {
        if(str==null)
            return null;
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++)
        {
            char c = str.charAt(i);
            switch(c)
            {                  
            case ' ':
                sb.append("&nbsp;");
                break;
            case '\n':
                sb.append("<br>");
               break;
            case '\r':
               break;
            case '\'':
                sb.append("&#39;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '&':
                sb.append("&amp;");
                break;
            case '"':
                sb.append("&#34;");
                break;
            case '\\':
                sb.append("&#92;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }   
%>