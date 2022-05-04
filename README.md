# vimhelp-minimal

This is a fork of the excellent [liquidz/clj-vimhelp](https://github.com/liquidz/clj-vimhelp) library which aims to provide a more minimal interface and improved Hiccup generation.

This library parses vim help files into Clojure data structures:
- Intermediate representation: `vimhelp.core/help-file->ir`
- Hiccup: `vimhelp.core/help-file->hiccup`

Unlike the upstream repo, vimhelp-minimal's Hiccup generation uses Hiccup 2.0 (`hiccup2.core`) which improves escaping by wrapping raw HTML strings in a special object (`hiccup.util/RawString`). This means that users can use the Hiccup in whatever ways they want without worrying about unintentionally escaping a string twice.
