# vimhelp-minimal

This is a fork of the excellent [liquidz/clj-vimhelp](https://github.com/liquidz/clj-vimhelp) library which aims to provide a more minimal interface and improved Hiccup generation.

This library parses vim help files into Clojure data structures:
- Intermediate representation: `vimhelp.core/help-file->ir`
- Hiccup: `vimhelp.core/help-file->hiccup`

Unlike the upstream repo, vimhelp-minimal's Hiccup generation uses Hiccup 2.0 (`hiccup2.core`) which improves escaping by wrapping raw HTML strings in a special object (`hiccup.util/RawString`). This means that users can use the Hiccup in whatever ways they want without worrying about unintentionally escaping a string twice.

## License
Copyright © 2019-2020 https://twitter.com/uochan[Masashi Iizuka]

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
