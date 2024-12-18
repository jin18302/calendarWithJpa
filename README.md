<script type="module">
  import mermaid from "https://cdn.jsdelivr.net/npm/mermaid/dist/mermaid.esm.min.mjs";
  mermaid.initialize({ startOnLoad: true });
</script>

<div class="mermaid">
erDiagram
    USER {
        int id
        string name
        string email
    }
    POST {
        int id
        string title
        string content
        int user_id
    }
    USER ||--o| POST : "writes"
</div>
