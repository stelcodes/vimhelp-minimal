# vimhelp-minimal

This is a fork of the excellent [liquidz/clj-vimhelp](https://github.com/liquidz/clj-vimhelp) library which aims to provide a more minimal interface, with some slight tweaks to the html rendering.

Parse vim help files into Clojure data structures:
- Intermediate representation (Hiccup w/ custom tags): `vimhelp.core/help-file->ir`
- HTML Hiccup: `vimhelp.core/help-file->hiccup`
- HTML fragment string: `vimhelp.core/help-file->html`
